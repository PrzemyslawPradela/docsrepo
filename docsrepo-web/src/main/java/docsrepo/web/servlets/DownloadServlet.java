package docsrepo.web.servlets;

import docsrepo.ejb.DocsServiceBean;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.Normalizer;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

@WebServlet(name = "DownloadServlet", urlPatterns = {"/DownloadServlet"})
public class DownloadServlet extends HttpServlet {

    @EJB
    private DocsServiceBean docsServiceBean;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        String name = request.getParameter("name");
        String filename = Normalizer.normalize(name
                .replaceAll(" ", "_")
                .toLowerCase()
                .concat(".doc"), Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
        response.setContentType("application/msword");
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        byte[] fileByteArray = docsServiceBean.downloadDocFile(id);
        InputStream inputStream = new ByteArrayInputStream(fileByteArray);
        try (OutputStream outputStream = response.getOutputStream()) {
            IOUtils.copy(inputStream, outputStream);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
