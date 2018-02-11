package com.example.demo;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;


public class RouteHandle extends MainVerticle {

    HttpServerResponse response;

    public void render(RoutingContext routingContext){

        response = routingContext.response();
        response.end("Hello world");
    }
}
