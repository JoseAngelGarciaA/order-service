package mx.com.axity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "computer", schema = "public")
public class ComputerDO implements Serializable {

    private static final long serialVersionUID = 9178661439383356177L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "computer_id")
    private Long computerId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "monitor_id")
    private Integer monitorId;

    @Column(name = "mouse_id")
    private Integer mouseId;

    @Column(name = "keyboard_id")
    private Integer keyboardId;

    @Column(name = "order_id")
    private Integer orderId;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("computerId", this.computerId)
                .append("brand", this.brand)
                .append("serialNumber", this.serialNumber)
                .append("monitorId", this.monitorId)
                .append("mouseId", this.mouseId)
                .append("keyboardId", this.keyboardId)
                .append("orderId", this.orderId)
                .toString();
    }
    public int compareTo(ComputerDO o) {
        return new CompareToBuilder().append(this.computerId, o.computerId).toComparison();
    }

}
