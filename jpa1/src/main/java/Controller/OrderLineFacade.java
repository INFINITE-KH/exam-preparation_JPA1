package Controller;

import Entity.OrderLine;
import Interfaces.IOrderLine;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class OrderLineFacade implements IOrderLine {

    private EntityManagerFactory emf;
    
    public OrderLineFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    @Override
    public OrderLine createOrderLine(OrderLine ol) {
        EntityManager em = emf.createEntityManager();
       
        try
        {
            em.getTransaction().begin();
            em.persist(ol);
            em.getTransaction().commit();
            return ol;
        }
        finally
        {
            em.close();
        }
    }
    
}
