package docsrepo.ws;

import docsrepo.ws.entities.Document;
import docsrepo.ws.utils.HibernateUtil;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@WebService(serviceName = "DocsService")
public class DocsWebService {

    /**
     * Web service operation
     *
     * @param doc
     */
    @WebMethod(operationName = "createDocument")
    @Oneway
    public void createDocument(@WebParam(name = "doc") Document doc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        try {
            tx = session.beginTransaction();
            session.save(doc);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    /**
     * Web service operation
     *
     * @param doc
     */
    @WebMethod(operationName = "updateDocument")
    @Oneway
    public void updateDocument(@WebParam(name = "doc") Document doc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        try {
            tx = session.beginTransaction();
            session.update(doc);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    /**
     * Web service operation
     *
     * @param id
     */
    @WebMethod(operationName = "removeDocument")
    @Oneway
    public void removeDocument(@WebParam(name = "id") int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Document as doc where doc.id=" + id);
            Document document = (Document) query.uniqueResult();
            session.delete(document);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    /**
     * Web service operation
     *
     * @param id
     * @return document
     */
    @WebMethod(operationName = "getDocument")
    public Document getDocument(@WebParam(name = "id") int id) {
        Document document = new Document();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Document as doc where doc.id=" + id);
            document = (Document) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return document;
    }

    /**
     * Web service operation
     *
     * @return list of decuments
     *
     */
    @WebMethod(operationName = "getDocuments")
    public List<Document> getDocuments() {
        List<Document> documents = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Document");
            documents = query.list();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return documents;
    }
}
