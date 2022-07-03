package com.remember.repositories.question;

import com.remember.domains.Question;
import com.remember.domains.UserIdentityField;
import com.remember.searchParams.QuestionParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface QuestionSearchRepository<T, ID> {
    Page<Question> findAll(Pageable pageable, UserIdentityField user, QuestionParams params);

    Page<T> findAll(Pageable pageable, UserIdentityField user);

    Optional<T> findById(ID id);

    Optional<UserIdentityField> findUserOfQuestionById(ID id);
}
