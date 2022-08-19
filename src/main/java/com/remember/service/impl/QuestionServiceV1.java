package com.remember.service.impl;

import com.remember.dto.QuestionDto;
import com.remember.paging.PageInfoImpl;
import com.remember.paging.Pageable;
import com.remember.repository.QuestionRepository;
import com.remember.response.PageResponse;
import com.remember.response.EntityResponse;
import com.remember.service.QuestionService;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.resteasy.reactive.links.RestLinksProvider;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * 쿼리요청을 동시에 하기 위한 방법
 * https://quarkus.io/blog/mutiny-concurrent-uni/
 */
@ApplicationScoped
@RequiredArgsConstructor
public class QuestionServiceV1 implements QuestionService {
    private final QuestionRepository questionRepository;
    private final RestLinksProvider linksProvider;

    @Override
    public Uni<PageResponse<QuestionDto>> findAll(Pageable pageable) {
        return Panache.withTransaction(() ->
                Uni.combine().all().unis(questionRepository.count(), questionRepository.findAll(pageable))
                .asTuple().map((tuple) ->
                     PageResponse.of(
                         QuestionDto.of(tuple.getItem2()),
                         PageInfoImpl.of(pageable, Math.toIntExact(tuple.getItem1())))
                ));
    }

    @Override
    public Uni<EntityResponse<QuestionDto>> findById(long id) {
        return questionRepository.findById(id)
                .onItem().transform(QuestionDto::of)
                .onItem().transform(EntityResponse::of);
    }
}
