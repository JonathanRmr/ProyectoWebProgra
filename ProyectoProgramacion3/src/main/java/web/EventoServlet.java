package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import model.Evento;
import service.EventoService;

import java.io.IOException;
import java.util.List;

@WebServlet("/evento")
public class EventoServlet extends HttpServlet {
    private EventoService eventoService = new EventoService();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Evento evento = gson.fromJson(req.getReader(), Evento.class);
        eventoService.addEvento(evento);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"status\":\"success\"}");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Evento> eventos = eventoService.getEventos();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(eventos));
    }
}
