package mx.com.axity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "mouse", schema = "public")
public class MouseDO implements Comparable<MouseDO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmouse")
    private Long idMouse;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "serialNumber")
    private String serialNumber;

    /**
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
    @Override
    public int compareTo(MouseDO o) {
        return new CompareToBuilder().append(this.idMouse, o.idMouse).toComparison();
    }
}
