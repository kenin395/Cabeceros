package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Producto;
import services.ProductoServices;
import services.ProductoServivesImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cabeceras/producto.xls")
public class ProductoXlsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProductoServices services = new ProductoServivesImplement();
        List<Producto> productos = services.Listar();

        // Verificamos si el usuario pidió descargar el archivo
        String download = req.getParameter("descargar");

        if ("true".equals(download)) {
            // Forzar descarga como Excel
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment; filename=productos.xls");
        } else {
            // Mostrar en navegador
            resp.setContentType("text/html; charset=UTF-8");
        }

        // Obtener el contexto dinámico (por ejemplo: /servlet_war_exploded)
        String contextPath = req.getContextPath();

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Listado de Productos</title>");
            out.println("<style>");
            out.println("body { font-family: Arial; background-color: #f7f9fc; color: #333; }");
            out.println("table { border-collapse: collapse; width: 80%; margin: 20px auto; }");
            out.println("th, td { border: 1px solid #999; padding: 8px; text-align: center; }");
            out.println("th { background-color: #007acc; color: white; }");
            out.println("tr:nth-child(even) { background-color: #eef3f9; }");
            out.println(".botones { text-align: center; margin: 20px; }");
            out.println("a.button { display:inline-block; margin:10px; padding:10px 20px; background:#007acc; color:white; text-decoration:none; border-radius:5px; }");
            out.println("a.button:hover { background:#005fa3; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2 style='text-align:center;'>Listado de Productos</h2>");

            // Botones
            out.println("<div class='botones'>");
            out.println("<a class='button' href='" + contextPath + "/cabeceras/producto.xls?descargar=true'>Descargar Excel</a>");
            out.println("<a class='button' href='" + contextPath + "/index.html'>Volver al inicio</a>");
            out.println("</div>");

            // Tabla
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>ID PRODUCTO</th>");
            out.println("<th>NOMBRE</th>");
            out.println("<th>TIPO</th>");
            out.println("<th>PRECIO</th>");
            out.println("</tr>");

            for (Producto producto : productos) {
                out.println("<tr>");
                out.println("<td>" + producto.getIdProducto() + "</td>");
                out.println("<td>" + producto.getNombre() + "</td>");
                out.println("<td>" + producto.getTipo() + "</td>");
                out.println("<td>$" + producto.getPrecio() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
