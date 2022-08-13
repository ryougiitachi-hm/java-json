package per.itachi.java.json.jackson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Order {

    private Long id;

    private OrderStatusEnum status;

    private String orderNbr;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSSSS")
    private LocalDateTime cdate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSSSS")
    private LocalDateTime edate;

    private Order() {}

    public Order(Long id, String orderNbr) {
        this.id = id;
        this.orderNbr = orderNbr;
        this.status = OrderStatusEnum.CREATED;
        this.cdate = LocalDateTime.now();
        this.edate = LocalDateTime.now();
    }

    public Order convertToInProgress() {
        switch (this.status) {
            case CREATED:
                this.status = OrderStatusEnum.IN_PROGRESS;
                this.edate = LocalDateTime.now();
                return this;
            default:
                throw new IllegalStateException(String
                        .format("The order %s can't be converted into IN_PROGRESS, status=%s. ",
                                orderNbr, status));
        }
    }

    public Order convertToFinished() {
        switch (this.status) {
            case IN_PROGRESS:
                this.status = OrderStatusEnum.FINISHED;
                this.edate = LocalDateTime.now();
                return this;
            default:
                throw new IllegalStateException(String
                        .format("The order %s can't be converted into FINISHED, status=%s. ",
                                orderNbr, status));
        }
    }
}
