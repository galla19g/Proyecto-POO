package org.galla.controller;

import io.javalin.Javalin;
import org.galla.exception.BadParameterException;
import org.galla.exception.NotFoundException;
import org.galla.model.Mensaje;

public class ExceptionController {
    public void iniciarControl(Javalin app) {
        app.exception(BadParameterException.class, (e, ctx) -> {
            Mensaje mensaje = new Mensaje(e.getMessage(), (Object) null);
            ctx.status(400);
            ctx.json(mensaje);
        });
        app.exception(NotFoundException.class, (e, ctx) -> {
            Mensaje mensaje = new Mensaje(e.getMessage(), (Object) null);
            ctx.status(404);
            ctx.json(mensaje);
        });
    }
}


