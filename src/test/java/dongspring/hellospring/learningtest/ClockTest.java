package dongspring.hellospring.learningtest;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockTest {
    // Clock을 이용해서 LocalDateTime.now?
    @Test
    void clock() {
        Clock clock = Clock.systemDefaultZone(); // 현재 시스템의 시간대 ex> 한국이면 서울시간대

        LocalDateTime dt1 = LocalDateTime.now(clock);
        LocalDateTime dt2 = LocalDateTime.now(clock);

        assertThat(dt2).isEqualTo(dt1);
    }

    // Clock을 Test에서 사용할 때 내가 원하는 시간을 지정해서 현재 시간을 가져오게 할 수 있는가?
    @Test
    void fixedClock() {
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

        LocalDateTime dt1 = LocalDateTime.now(clock);
        LocalDateTime dt2 = LocalDateTime.now(clock);

        assertThat(dt2).isEqualTo(dt1);
    }
}
