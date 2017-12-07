package be.quatrefeuilles.webshop.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Page {

    @Id
    private String id;

    private Orientation orientation;

    private double price;

    private PageFormat pageFormat;

    private boolean color;

}