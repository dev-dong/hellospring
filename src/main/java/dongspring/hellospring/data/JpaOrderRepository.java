package dongspring.hellospring.data;

import dongspring.hellospring.order.Order;
import dongspring.hellospring.order.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }
}
