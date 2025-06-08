package org.galla;

import io.javalin.Javalin;

import org.galla.compartidos.ExceptionController;
import org.galla.compartidos.HealthController;
import org.galla.productos.ProductoController;
import org.galla.productos.ProductoRepository;
import org.galla.productos.ProductoService;
import org.galla.recetas.RecetaController;
import org.galla.recetas.RecetaRepository;
import org.galla.recetas.RecetaService;
import org.galla.usuarios.UsuarioController;
import org.galla.usuarios.UsuarioRepository;
import org.galla.usuarios.UsuarioService;
import org.galla.restaurantes.RestauranteController;
import org.galla.restaurantes.RestauranteRepository;
import org.galla.restaurantes.RestauranteService;
import org.galla.eventosgastronomicos.EventogastronomicoController;
import org.galla.eventosgastronomicos.EventogastronomicoRepository;
import org.galla.eventosgastronomicos.EventogastronomicoService;
import org.galla.ingredienteslocales.IngredienteLocalController;
import org.galla.ingredienteslocales.IngredienteLocalRepository;
import org.galla.ingredienteslocales.IngredienteLocalService;
import org.galla.categorias.CategoriaController;
import org.galla.categorias.CategoriaRepository;
import org.galla.categorias.CategoriaService;
import org.galla.chefs.ChefController;
import org.galla.chefs.ChefRepository;
import org.galla.chefs.ChefService;
import org.galla.comentarios.ComentarioController;
import org.galla.comentarios.ComentarioRepository;
import org.galla.comentarios.ComentarioService;
import org.galla.rutasgastronomicas.RutaGastronomicaController;
import org.galla.rutasgastronomicas.RutaGastronomicaRepository;
import org.galla.rutasgastronomicas.RutaGastronomicaService;
import org.galla.mercado.MercadoLocalController;
import org.galla.mercado.MercadoLocalRepository;
import org.galla.mercado.MercadoLocalService;
import org.galla.bebidas.BebidaController;
import org.galla.bebidas.BebidaRepository;  
import org.galla.bebidas.BebidaService;



public class Main {
    public static void main(String[] args) {
        ProductoRepository productoRepository = new ProductoRepository();
        ProductoService productoService = new ProductoService(productoRepository);
        ProductoController productoController = new ProductoController(productoService);

        ExceptionController exceptionController = new ExceptionController();
        HealthController healthController = new HealthController();

        RecetaRepository recetaRepository = new RecetaRepository();
        RecetaService recetaService = new RecetaService(recetaRepository);
        RecetaController recetaController = new RecetaController(recetaService);

        UsuarioRepository usuarioRepository = new UsuarioRepository();
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        UsuarioController usuarioController = new UsuarioController(usuarioService);

        RestauranteRepository restauranteRepository = new RestauranteRepository();
        RestauranteService restauranteService = new RestauranteService(restauranteRepository);
        RestauranteController restauranteController = new RestauranteController(restauranteService);

        EventogastronomicoRepository eventogastronomicoRepository = new EventogastronomicoRepository();
        EventogastronomicoService eventogastronomicoService = new EventogastronomicoService(eventogastronomicoRepository);
        EventogastronomicoController eventogastronomicoController = new EventogastronomicoController(eventogastronomicoService);

        MercadoLocalRepository mercadoLocalRepository = new MercadoLocalRepository();
        MercadoLocalService mercadoLocalService = new MercadoLocalService(mercadoLocalRepository);
        MercadoLocalController mercadoLocalController = new MercadoLocalController(mercadoLocalService);

        IngredienteLocalRepository ingredienteLocalRepository = new IngredienteLocalRepository();
        IngredienteLocalService ingredienteLocalService = new IngredienteLocalService(ingredienteLocalRepository);
        IngredienteLocalController ingredienteLocalController = new IngredienteLocalController(ingredienteLocalService);

        CategoriaRepository categoriaRepository = new CategoriaRepository();
        CategoriaService categoriaService = new CategoriaService(categoriaRepository);
        CategoriaController categoriaController = new CategoriaController(categoriaService);

        ChefRepository chefRepository = new ChefRepository();
        ChefService chefService = new ChefService(chefRepository);
        ChefController chefController = new ChefController(chefService);

        ComentarioRepository comentarioRepository = new ComentarioRepository();
        ComentarioService comentarioService = new ComentarioService(comentarioRepository);
        ComentarioController comentarioController = new ComentarioController(comentarioService);

        RutaGastronomicaRepository rutaGastronomicaRepository = new RutaGastronomicaRepository();
        RutaGastronomicaService rutaGastronomicaService = new RutaGastronomicaService(rutaGastronomicaRepository);
        RutaGastronomicaController rutaGastronomicaController = new RutaGastronomicaController(rutaGastronomicaService);

        Javalin app = Javalin.create();
        exceptionController.iniciarControl(app);
        
        healthController.configurarRutas(app);

        productoController.configurarRutas(app);

        recetaController.configurarRutas(app);

        usuarioController.configurarRutas(app);

        restauranteController.configurarRutas(app);

        eventogastronomicoController.configurarRutas(app);

        ingredienteLocalController.configurarRutas(app);

        categoriaController.configurarRutas(app);

        chefController.configurarRutas(app);

        comentarioController.configurarRutas(app);

        rutaGastronomicaController.configurarRutas(app);

        mercadoLocalController.configurarRutas(app);

        app.before((ctx) ->ctx.header("content-type", "application/json"));
        app.start(8080);
    
    }
}
