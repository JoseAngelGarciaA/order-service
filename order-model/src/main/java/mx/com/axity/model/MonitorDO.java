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
@Table(name = "monitor", schema = "public")
public class MonitorDO implements Comparable<MonitorDO>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmonitor")
    private Long idMonitor;

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
                .append("idMonitor", this.idMonitor)
                .append("Brand", this.brand)
                .append("Model", this.model)
                .append("SerialNumber", this.serialNumber)
                .toString();
    }
    @Override
    public int compareTo(MonitorDO o) {
        return new CompareToBuilder().append(this.idMonitor, o.idMonitor).toComparison();
    }
}
