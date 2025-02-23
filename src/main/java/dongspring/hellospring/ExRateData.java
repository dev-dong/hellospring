package dongspring.hellospring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Map;

// JSON 안에 없는 데이터는 무시한다. 즉, 내가 보여줄 json 만 보여주고 싶은데 mapper에서 읽은 json의 쓸모없는 데이터가 많을때
// "난 내가 정의한 필드만 받을거야, 나머지는 무시해!"
@JsonIgnoreProperties(ignoreUnknown = true)
public record ExRateData(String result, Map<String, BigDecimal> rates) {
}
