package com.remember.repository;

import com.remember.domain.Question;
import com.remember.paging.Pageable;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class QuestionRepository implements QuestionSearchRepository, PanacheRepository<Question> {

    @Override
    public Uni<List<Question>> findAll(Pageable pageable) {
        return this.findAll().page(
                Page.of(Math.toIntExact(pageable.getPageNumber()),
                        Math.toIntExact(pageable.getPageSize())))
                .list();
    }
}
