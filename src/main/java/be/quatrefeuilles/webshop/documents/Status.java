package be.quatrefeuilles.webshop.documents;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Status {

    private StatusCode statusCode;
    private LocalDateTime date;

}
