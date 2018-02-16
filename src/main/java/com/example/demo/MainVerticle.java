package com.example.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import com.example.demo.RouteHandle;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.TemplateHandler;
import io.vertx.ext.web.templ.HandlebarsTemplateEngine;
import io.vertx.ext.web.templ.TemplateEngine;
import io.vertx.core.logging.LoggerFactory;
import org.slf4j.*;

public class MainVerticle extends AbstractVerticle {

    HandlebarsTemplateEngine engine=HandlebarsTemplateEngine.create();

    Router route = Router.router(vertx);
    @Override
    public void start() throws Exception {

        RouteHandle routehandle= new RouteHandle();

        route.get("/").handler(routehandle::render);

        route.get("/theme").handler(routehandle::theme);


        vertx.createHttpServer().requestHandler(route::accept).listen(3000);
    }
}
