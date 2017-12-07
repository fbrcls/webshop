package be.quatrefeuilles.webshop.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    @Id
    private String id;

    private PageFormat pageFormat;

    private boolean color;

}