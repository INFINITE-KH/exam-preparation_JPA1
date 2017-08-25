package Controller;

import Entity.Customer;
import Interfaces.ICustomer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FacadeCustomer implements ICustomer {

    private EntityManagerFactory emf;
    
    public FacadeCustomer(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    @Override
    public Customer createCustomer(Customer o) {
        EntityManager em = emf.createEntityManager();
       
        try
        {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            return o;
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public Customer getCustomer(Long id) {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Customer o = em.find(Customer.class, id);
            em.getTransaction().commit();
            return o;
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        EntityManager em = emf.createEntityManager();

        List<Customer> cus = null;
        
        try
        {
            em.getTransaction().begin();
            cus= em.createQuery("Select o from Customer o").getResultList();
            em.getTransaction().commit();
            return cus;
        }
        finally
        {
            em.close();
        }
    }
    
}
