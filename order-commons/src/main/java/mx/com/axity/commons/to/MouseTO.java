package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.io.Serializable;

@Getter
@Setter
public class MouseTO implements Serializable{

    private Integer idMouse;
    private String brand;
    private String model;
    private String serialNumber;

    /*
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("idMouse", this.idMouse)
                .append("Brand", this.brand)
                .append("Model", this.model)
                .append("SerialNumber", this.serialNumber)
                .toString();
    }
}
