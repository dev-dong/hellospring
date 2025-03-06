package dongspring.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);
        OrderService orderService = beanFactory.getBean(OrderService.class);

        System.out.println(
                paymentService.exRateProvider == orderService.exRateProvider
        );

        // @Configuration 어노테이션을 만드면 스프링이 여러번 호출하더라도 딱 한번만 만들고 만든 객체를 계속 반환해준다.
        ObjectFactory objectFactory = beanFactory.getBean(ObjectFactory.class);
        PaymentService paymentService1 = objectFactory.paymentService();
        PaymentService paymentService2 = objectFactory.paymentService();
        System.out.println(paymentService1 == paymentService2); // true

        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
