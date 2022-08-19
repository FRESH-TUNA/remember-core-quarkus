package com.remember.controller;

import com.remember.service.QuestionService;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.RoutingContext;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/hello")
public class GreetingResource {
    @Inject
    QuestionService service;

    @GET
    @Path("hello")
    public Uni<String> hello2(RoutingContext context) {
        return Uni.createFrom().item("Hello world!");
    }
}
