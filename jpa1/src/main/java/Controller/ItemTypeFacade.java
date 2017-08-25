package Controller;

import Entity.ItemType;
import Interfaces.IItemType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ItemTypeFacade implements IItemType {

    private EntityManagerFactory emf;
    
    public ItemTypeFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    @Override
    public ItemType createItemType(ItemType it) {
        
        EntityManager em = emf.createEntityManager();
       
        try
        {
            em.getTransaction().begin();
            em.persist(it);
            em.getTransaction().commit();
            return it;
        }
        finally
        {
            em.close();
        }
    }
    
}
