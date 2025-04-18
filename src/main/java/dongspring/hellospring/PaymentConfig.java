package dongspring.hellospring;

import dongspring.hellospring.api.ApiTemplate;
import dongspring.hellospring.api.ErApiExRateExtractor;
import dongspring.hellospring.api.SimpleApiExecutor;
import dongspring.hellospring.exrate.RestTemplateExRateProvider;
import dongspring.hellospring.exrate.WebApiExRateProvider;
import dongspring.hellospring.payment.ExRateProvider;
import dongspring.hellospring.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;

@Configuration
@ComponentScan
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ApiTemplate apiTemplate() {
        return new ApiTemplate(new SimpleApiExecutor(), new ErApiExRateExtractor());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new RestTemplateExRateProvider(restTemplate());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
