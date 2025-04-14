package dongspring.hellospring;

import dongspring.hellospring.data.OrderRepository;
import dongspring.hellospring.order.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class DataClient {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
        OrderRepository repository = beanFactory.getBean(OrderRepository.class);

        // em.persist - 영속화
        Order order = new Order("100", BigDecimal.TEN);
        repository.save(order);
        System.out.println(order);

        Order order2 = new Order("100", BigDecimal.ONE);
        repository.save(order2);
        System.out.println(order2);
    }
}
