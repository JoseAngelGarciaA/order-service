package mx.com.axity.commons.to;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@Getter
@Setter
public class ComputerTO implements Serializable {

    private Long idComputer;
    private String brand;
    private String serialNumber;
    private Integer idMonitor;
    private Integer idMouse;
    private Integer idKeyboard;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("idComputer", this.idComputer)
                .append("Brand", this.brand)
                .append("SerialNumber", this.serialNumber)
                .append("idMonitor", this.idMonitor)
                .append("idMouse", this.idMouse)
                .append("idKeyboard", this.idKeyboard)
                .toString();
    }
}
