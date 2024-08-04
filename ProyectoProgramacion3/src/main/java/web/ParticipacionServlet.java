package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import model.Participacion;
import service.ParticipacionService;

import java.io.IOException;
import java.util.List;

@WebServlet("/participacion")
public class ParticipacionServlet extends HttpServlet {
    private ParticipacionService participacionService = new ParticipacionService();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Participacion participacion = gson.fromJson(req.getReader(), Participacion.class);
        participacionService.addParticipacion(participacion);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"status\":\"success\"}");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Participacion> participaciones = participacionService.getParticipaciones();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(participaciones));
    }
}
