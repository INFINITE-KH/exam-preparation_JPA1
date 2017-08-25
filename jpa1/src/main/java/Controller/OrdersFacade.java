package Controller;

import Entity.Orders;
import Interfaces.IOrder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class OrdersFacade implements IOrder {

    private EntityManagerFactory emf;
    
    public OrdersFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    @Override
    public Orders createOrder(Orders o) {
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
    public Orders addOrderToCustomer(Orders o) {
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
    public Orders getOrders(Long id) {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Orders os = em.find(Orders.class, id);
            em.getTransaction().commit();
            return os;
        }
        finally
        {
            em.close();
        }
    }
    
}
