package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;

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

}
