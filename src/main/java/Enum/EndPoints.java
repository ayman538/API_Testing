package Enum;
import lombok.Getter;
import lombok.Data;
public enum EndPoints {

    USER("/api/v3/user/mario");
    @Getter
    private final String value;
    EndPoints(String value) {
        this.value = value;
    }


}
