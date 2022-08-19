package com.remember.controller;

import com.remember.dto.QuestionDto;
import com.remember.paging.PageRequest;
import com.remember.response.PageResponse;
import com.remember.response.EntityResponse;
import com.remember.service.QuestionService;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.RoutingContext;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/questions")
public class QuestionController {

    @Inject
    QuestionService service;

    @GET
    @Path("/{id}")
    public Uni<EntityResponse<QuestionDto>> findById(RoutingContext context, @PathParam("id") long id) {
        return service.findById(id);
    }

    @GET
    public Uni<PageResponse<QuestionDto>> findAll(RoutingContext context) {
        return service.findAll(PageRequest.of(0, 2));
    }
}
