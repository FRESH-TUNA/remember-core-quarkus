package com.remember.repositories.question;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import com.remember.domains.QQuestion;
import com.remember.domains.Question;
import com.remember.domains.UserIdentityField;
import com.remember.predicateFactories.QuestionPredicateFactory;
import com.remember.searchParams.QuestionParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class QuestionSearchRepositoryImpl implements QuestionSearchRepository<Question, Long> {
    private final JPAQueryFactory queryFactory;

    public QuestionSearchRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<Question> findAll(Pageable pageable, UserIdentityField user, QuestionParams params) {
        JPAQuery<Long> counts_query = counts_base_query(user);
        JPAQuery<Question> query = findAll_base_query(user);
        Predicate predicate = QuestionPredicateFactory.generate(params);

        // count query all
        return new PageImpl<>(pagedFetch(query, pageable), pageable, counts_query.where(predicate).fetchOne());
    }

    @Override
    public Page<Question> findAll(Pageable pageable, UserIdentityField user) {
        JPAQuery<Long> counts_query = counts_base_query(user);
        JPAQuery<Question> query = findAll_base_query(user);

        // count query all
        return new PageImpl<>(pagedFetch(query, pageable), pageable, counts_query.fetchOne());
    }

    @Override
    public Optional<Question> findById(Long id) {
        QQuestion question = QQuestion.question;

        JPAQuery<Question> query = queryFactory
                .selectDistinct(question)
                .from(question)
                .innerJoin(question.platform).fetchJoin()
                .leftJoin(question.algorithms).fetchJoin()
                .where(question.id.eq(id));

        return Optional.ofNullable(query.fetchOne());
    }

    @Override
    public Optional<UserIdentityField> findUserOfQuestionById(Long id) {
        QQuestion question = QQuestion.question;
        return Optional.ofNullable(queryFactory
                .select(question.user)
                .from(question)
                .where(question.id.eq(id))
                .fetchOne());
    }

    /*
     * base queries
     */
    private JPAQuery<Question> findAll_base_query(UserIdentityField user) {
        QQuestion question = QQuestion.question;
        return queryFactory
                .selectDistinct(question)
                .from(question)
                .innerJoin(question.platform).fetchJoin()
                .leftJoin(question.algorithms)
                .where(question.user.eq(user));
    }

    private JPAQuery<Long> counts_base_query(UserIdentityField user) {
        QQuestion question = QQuestion.question;
        return queryFactory.select(question.count())
                .from(question)
                .where(question.user.eq(user));
    }

    private List<Question> pagedFetch(JPAQuery<Question> query, Pageable pageable) {
        return query.offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();
    }
}
