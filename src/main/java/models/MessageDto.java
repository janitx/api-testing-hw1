package models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private String message;

    public String asString() {
        return String.format("{\"message\":\"%s\"}", message);
    }
}
