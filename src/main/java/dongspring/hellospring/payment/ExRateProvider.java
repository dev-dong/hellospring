package dongspring.hellospring.payment;

import java.math.BigDecimal;

public interface ExRateProvider {
    // 인터페이스의 모든 메서드는 public이다.
    BigDecimal getExRate(String currency);
}
