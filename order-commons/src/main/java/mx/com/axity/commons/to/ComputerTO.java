package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;

@Getter
@Setter
public class ComputerTO {
    private Long computerId;
    private String brand;
    private String serialNumber;
    private Integer monitorId;
    private Integer mouseId;
    private Integer keyboardId;
    private Integer orderId;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("computerId", this.computerId)
                .append("brand",this.brand)
                .append("monitorId",this.monitorId)
                .append("mouseId",this.mouseId)
                .append("keyboardId",this.keyboardId)
                .append("orderId",this.orderId)
                .toString();
    }
}
