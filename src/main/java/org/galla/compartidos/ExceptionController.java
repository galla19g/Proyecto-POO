package org.galla.compartidos;

import io.javalin.Javalin;
import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;
import org.galla.compartidos.Mensaje;

public class ExceptionController {

    public void iniciarControl(Javalin app) {
        app.exception(NotFoundException.class, (e, ctx) -> {
            Mensaje mensaje = new Mensaje(e.getMessage(), null);
            ctx.status(404);
            ctx.json(mensaje);
        });

        app.exception(BadParameterException.class, (e, ctx) -> {
            Mensaje mensaje = new Mensaje(e.getMessage(), null);
            ctx.status(400);
            ctx.json(mensaje);
        });
    }
}
