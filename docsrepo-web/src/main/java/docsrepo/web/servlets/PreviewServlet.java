package docsrepo.web.servlets;

import docsrepo.ejb.DocsServiceBean;
import docsrepo.ejb.soap.client.Document;
import java.io.IOException;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

@WebServlet(name = "PreviewServlet", urlPatterns = {"/PreviewServlet"})
@MultipartConfig
public class PreviewServlet extends HttpServlet {

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
        Document document = docsServiceBean.getDocument(id);
        request.setAttribute("document", document);
        request.getRequestDispatcher("preview.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        String name = request.getParameter("name");
        String contentDescription = request.getParameter("contentDescription");
        Part filePart = request.getPart("file");
        byte[] fileAsByteArray = null;
        if (filePart != null) {
            InputStream filecontent = filePart.getInputStream();
            fileAsByteArray = IOUtils.toByteArray(filecontent);
        }
        docsServiceBean.updateDocument(id, name, contentDescription, fileAsByteArray);
        response.sendRedirect("index.jsp");
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
