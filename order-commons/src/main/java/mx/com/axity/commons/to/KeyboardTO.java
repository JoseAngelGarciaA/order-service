package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@Getter
@Setter
public class KeyboardTO implements Serializable {

    private Long idKeyboard;
    private String brand;
    private String model;
    private String serialNumber;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("idKeyboard", this.idKeyboard)
                .append("Brand", this.brand)
                .append("Model", this.model)
                .append("SerialNumber", this.serialNumber)
                .toString();
    }
}
