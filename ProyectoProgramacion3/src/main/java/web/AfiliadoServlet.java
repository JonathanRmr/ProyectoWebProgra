package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import model.Afiliado;
import service.AfiliadoService;

import java.io.IOException;
import java.util.List;

@WebServlet("/afiliado")
public class AfiliadoServlet extends HttpServlet {
    private AfiliadoService afiliadoService = new AfiliadoService();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Afiliado afiliado = gson.fromJson(req.getReader(), Afiliado.class);
        afiliadoService.addAfiliado(afiliado);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"status\":\"success\"}");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Afiliado> afiliados = afiliadoService.getAfiliados();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(afiliados));
    }
}
