package runner;

import jakarta.servlet.Servlet;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationPath("/api")
public class Main extends ResourceConfig {

    public Main() {
        // Registrar recursos y proveedores de JAX-RS
        packages("runner");
    }

    public static void main(String[] args) {
        try {
            // Configuración de Jersey con el contenedor de servlets
            ServletContainer servletContainer = new ServletContainer(new Main());
            org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8080);
            org.eclipse.jetty.servlet.ServletContextHandler context = new org.eclipse.jetty.servlet.ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            server.setHandler(context);

            context.addServlet(new ServletHolder((Servlet) servletContainer), "/api/*");
            context.addServlet(new ServletHolder(new org.eclipse.jetty.servlet.DefaultServlet()), "/*");

            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
