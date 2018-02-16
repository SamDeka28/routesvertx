package com.example.demo;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;


public class RouteHandle extends MainVerticle {

    HttpServerResponse response;

    public void render(RoutingContext routingContext){

        response = routingContext.response();
        response.end();
    }

    public void theme(RoutingContext routingContext) {
        response = routingContext.response();

        engine.render(routingContext, "templates", "theme",res -> {
            if (res.succeeded()) {
                routingContext.response().end(res.result());
            } else {
                routingContext.fail(res.cause());
            }
        });
    }
}
