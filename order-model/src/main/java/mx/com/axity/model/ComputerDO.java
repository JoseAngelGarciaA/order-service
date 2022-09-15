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
@Table(name = "computer", schema = "public")
public class ComputerDO implements Comparable<ComputerDO>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcomputer")
    private Long idComputer;

    @Column(name = "brand")
    private String brand;

    @Column(name = "serialNumber")
    private String serialNumber;

    @Column(name = "idmonitor")
    private Integer idMonitor;

    @Column(name = "idmouse")
    private Integer idMouse;

    @Column(name = "idkeyboard")
    private Integer idKeyboard;

    /**
     * {@inheritDoc}
     */
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
    @Override
    public int compareTo(ComputerDO o) {
        return new CompareToBuilder().append(this.idComputer, o.idComputer).toComparison();
    }
}
