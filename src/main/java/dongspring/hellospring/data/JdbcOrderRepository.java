package dongspring.hellospring.data;

import dongspring.hellospring.order.Order;
import dongspring.hellospring.order.OrderRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;

public class JdbcOrderRepository implements OrderRepository {
    private final JdbcClient jdbcClient;

    public JdbcOrderRepository(DataSource dataSource) {
        this.jdbcClient = JdbcClient.create(dataSource);
    }

    @PostConstruct
    void initDb() {
        jdbcClient.sql("""
                        DROP TABLE IF EXISTS orders;
                        DROP SEQUENCE IF EXISTS orders_SEQ;
                        CREATE TABLE orders (
                            id bigint not null,
                            no varchar(255),
                            total numeric(38,2),
                            PRIMARY KEY (id));
                        alter table if exists orders add constraint UK_43egxxciqr9ncgmxbdx2avi8n unique (no);
                        create sequence orders_SEQ start with 1 increment by 50;
                        """)
                .update();
    }

    @Override
    public void save(Order order) {
        Long id = jdbcClient.sql("select next value for orders_SEQ").query(Long.class).single();
        order.setId(id);

        jdbcClient.sql("insert into orders (id, no, total) values (?, ?, ?)")
                .params(order.getId(), order.getNo(), order.getTotal())
                .update();
    }
}
