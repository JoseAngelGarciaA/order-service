package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.io.Serializable;

@Getter
@Setter
public class UserTO implements Serializable {

    private int id;
    private String name;
    private String lastName;
    private int age;

    /*
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("idUser", this.id)
                .append("Name", this.name)
                .append("LastName", this.lastName)
                .append("Age", this.age)
                .toString();
    }
}
