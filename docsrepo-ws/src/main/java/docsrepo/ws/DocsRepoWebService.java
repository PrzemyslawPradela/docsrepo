package docsrepo.ws;

import docsrepo.ws.entities.Document;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@WebService(serviceName = "DocsRepoService")
public class DocsRepoWebService {

    private final EntityManagerFactory emf;

    public DocsRepoWebService() {
        this.emf = Persistence.createEntityManagerFactory("docsrepoPU");
    }

    /**
     * Web service operation
     *
     * @param doc
     */
    @WebMethod(operationName = "createDocument")
    @Oneway
    public void createDocument(@WebParam(name = "doc") Document doc) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(doc);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Web service operation
     *
     * @param doc
     */
    @WebMethod(operationName = "updateDocument")
    @Oneway
    public void updateDocument(@WebParam(name = "doc") Document doc) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(doc);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Web service operation
     *
     * @param id
     */
    @WebMethod(operationName = "removeDocument")
    @Oneway
    public void removeDocument(@WebParam(name = "id") int id) {
        EntityManager em = emf.createEntityManager();
        Document doc = (Document) em.createNamedQuery("Document.findById").setParameter("id", id).getSingleResult();
        em.getTransaction().begin();
        em.remove(doc);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Web service operation
     *
     * @param id
     * @return document
     */
    @WebMethod(operationName = "getDocument")
    public Document getDocument(@WebParam(name = "id") int id) {
        EntityManager em = emf.createEntityManager();
        Document doc = (Document) em.createNamedQuery("Document.findById").setParameter("id", id).getSingleResult();
        return doc;
    }

    /**
     * Web service operation
     *
     * @return list of decuments
     *
     */
    @WebMethod(operationName = "getDocuments")
    public List<Document> getDocuments() {
        EntityManager em = emf.createEntityManager();
        List<Document> documents = em.createNamedQuery("Document.findAll").getResultList();
        return documents;
    }

}
