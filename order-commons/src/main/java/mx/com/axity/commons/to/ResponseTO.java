package mx.com.axity.commons.to;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

@Getter
@Setter
public class ResponseTO implements Serializable {

    private static final long serialVersionUID = 7449115534572237478L;

    private Integer code;
    private String message;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", this.code).append("message", this.message).toString();
    }
}
