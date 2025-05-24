package org.galla.compartidos;

import io.javalin.Javalin;

public class HealthController {

    public void configurarRutas(Javalin app) {
        app.get("/health", ctx -> {
            ctx.result("OK");
            ctx.status(200);
        });
    }
}
