package com.remember.service;

import com.remember.dto.QuestionDto;
import com.remember.paging.Pageable;
import com.remember.response.PageResponse;
import com.remember.response.EntityResponse;
import io.smallrye.mutiny.Uni;

public interface QuestionService {
    Uni<PageResponse<QuestionDto>> findAll(Pageable pageable);

    Uni<EntityResponse<QuestionDto>> findById(long id);
}
