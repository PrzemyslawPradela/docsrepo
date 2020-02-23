package docsrepo.ejb;

import docsrepo.ws.client.DocsService;
import docsrepo.ws.client.DocsWebService;
import docsrepo.ws.client.Document;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

@Stateless
@LocalBean
public class DocsServiceBean {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/docsrepo-ws/DocsService?wsdl")
    private DocsService service;

    public void addDocument(Document doc) {

        try { // Call Web Service Operation
            DocsWebService port = service.getDocsWebServicePort();
            port.createDocument(doc);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void updateDocument(Document doc) {

        try { // Call Web Service Operation
            DocsWebService port = service.getDocsWebServicePort();
            port.updateDocument(doc);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void deleteDocument(int id) {

        try { // Call Web Service Operation
            DocsWebService port = service.getDocsWebServicePort();
            port.removeDocument(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Document getDocument(int id) {

        Document document = null;
        try { // Call Web Service Operation
            DocsWebService port = service.getDocsWebServicePort();
            Document result = port.getDocument(id);
            document = result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return document;
    }

    public byte[] downloadDocFile(int documentId) {

        byte[] file = null;
        try { // Call Web Service Operation
            DocsWebService port = service.getDocsWebServicePort();
            int id = documentId;
            Document result = port.getDocument(id);
            file = result.getFile();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return file;
    }

    public List<Document> getDocuments() {

        List<Document> documents = null;
        try { // Call Web Service Operation
            DocsWebService port = service.getDocsWebServicePort();
            List<Document> result = port.getDocuments();
            documents = result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return documents;
    }
}
