package dongspring.hellospring.payment;

import dongspring.hellospring.exrate.CachedExRateProvider;
import dongspring.hellospring.exrate.WebApiExRateProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

@Configuration
@ComponentScan
public class TestObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new ExRateProviderStub(valueOf(1_000));
    }
}
