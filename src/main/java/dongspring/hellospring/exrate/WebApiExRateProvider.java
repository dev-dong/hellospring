package dongspring.hellospring.exrate;

import com.fasterxml.jackson.databind.ObjectMapper;
import dongspring.hellospring.payment.ExRateProvider;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

@Component
public class WebApiExRateProvider implements ExRateProvider {
    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        URL url = new URL("http://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // InputStream은 File이나 Network를 통해서 넘겨오는 데이터를 byte 형태로 return
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        ObjectMapper mapper = new ObjectMapper();
        ExRateData data = mapper.readValue(response, ExRateData.class);

        System.out.println("API ExRate: " + data.rates().get("KRW"));

        return data.rates().get("KRW");
    }
}
