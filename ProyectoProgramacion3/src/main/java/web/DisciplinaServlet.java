package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import model.Disciplina;
import service.DisciplinaService;

import java.io.IOException;
import java.util.List;

@WebServlet("/disciplina")
public class DisciplinaServlet extends HttpServlet {
    private DisciplinaService disciplinaService = new DisciplinaService();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Disciplina disciplina = gson.fromJson(req.getReader(), Disciplina.class);
        disciplinaService.addDisciplina(disciplina);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"status\":\"success\"}");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Disciplina> disciplinas = disciplinaService.getDisciplinas();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(disciplinas));
    }
}
