package dongspring.hellospring;

import dongspring.hellospring.order.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class DataClient {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
        EntityManagerFactory emf = beanFactory.getBean(EntityManagerFactory.class);

        // em
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // em.persist - 영속화
        Order order = new Order("100", BigDecimal.TEN);
        em.persist(order); // save의 내부에 보면 persist를 호출한다.

        System.out.println(order);

        em.getTransaction().commit();
        em.close();
    }
}
