package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceros-request")
public class CabecerasHttpRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Configurar tipo de contenido y codificación
        resp.setContentType("text/html;charset=UTF-8");

        // Obtener información básica de la petición
        String metodoHttp = req.getMethod();
        String requestURI = req.getRequestURI();
        String requestURL = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ip = req.getRemoteAddr();
        int port = req.getServerPort();

        // Generar la respuesta HTML
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Manejo de cabeceros 2025-2026</title>");
            out.println("<style>");
            out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f0f4f8; color: #333; margin: 0; padding: 0; }");
            out.println("h1 { background-color: #007acc; color: white; padding: 20px; margin: 0; text-align: center; }");
            out.println("h2 { color: #007acc; margin-top: 30px; text-align: center; }");
            out.println("ul { list-style: none; padding: 0; max-width: 700px; margin: 20px auto; background: white; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
            out.println("ul li { padding: 10px 20px; border-bottom: 1px solid #ddd; }");
            out.println("ul li:last-child { border-bottom: none; }");
            out.println("b { color: #007acc; }");
            out.println("a { display: block; width: 200px; margin: 30px auto; text-align: center; background-color: #007acc; color: white; text-decoration: none; padding: 10px; border-radius: 5px; transition: 0.3s; }");
            out.println("a:hover { background-color: #005fa3; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Manejo de Cabeceros HTTP</h1>");
            out.println("<ul>");
            out.println("<li><b>Método de petición:</b> " + metodoHttp + "</li>");
            out.println("<li><b>URI:</b> " + requestURI + "</li>");
            out.println("<li><b>URL:</b> " + requestURL + "</li>");
            out.println("<li><b>Contexto:</b> " + contextPath + "</li>");
            out.println("<li><b>Servlet Path:</b> " + servletPath + "</li>");
            out.println("<li><b>Dirección IP del cliente:</b> " + ip + "</li>");
            out.println("<li><b>Puerto del servidor:</b> " + port + "</li>");
            out.println("</ul>");

            // Mostrar cabeceras HTTP
            out.println("<h2>Cabeceras HTTP</h2>");
            out.println("<ul>");
            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String header = headerNames.nextElement();
                out.println("<li><b>" + header + ":</b> " + req.getHeader(header) + "</li>");
            }
            out.println("</ul>");

            out.println("<a href='index.html'>Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
