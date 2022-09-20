package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

@Getter
@Setter
public class OrderTO {

    private Long orderId;
    private String dateOrder;
    private List<ComputerTO> computers;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("orderId", this.orderId)
                .append("dateOrder",this.dateOrder)
                .append("computers",this.computers)
                .toString();
    }
}
