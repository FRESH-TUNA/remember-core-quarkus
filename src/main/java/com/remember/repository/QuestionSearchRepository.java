package com.remember.repository;

import com.remember.domain.Question;
import com.remember.paging.Pageable;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface QuestionSearchRepository {
    Uni<List<Question>> findAll(Pageable pageable);
}
