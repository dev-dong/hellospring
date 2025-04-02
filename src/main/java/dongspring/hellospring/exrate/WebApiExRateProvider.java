package dongspring.hellospring.exrate;

import dongspring.hellospring.api.*;
import dongspring.hellospring.payment.ExRateProvider;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WebApiExRateProvider implements ExRateProvider {
    private final ApiTemplate apiTemplate;

    public WebApiExRateProvider(ApiTemplate apiTemplate) {
        this.apiTemplate = apiTemplate;
    }

    @Override
    public BigDecimal getExRate(String currency) {
        String url = "https://open.er-api.com/v6/latest/" + currency;

        // 람다를 사용할 수 있는 이유는 인터페이스에 메소드가 1개만 선언되어 있어 사용이 가능하다.
        return apiTemplate.getForExRate(url);
    }
}
