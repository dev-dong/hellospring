package dongspring.hellospring.order;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String no;

    private BigDecimal total;

    // JPA에서는 파라미터 있는 생성자 생성 시 기본생성자 필수
    public Order() {}

    public Order(String no, BigDecimal total) {
        this.no = no;
        this.total = total;
    }
}
