package be.quatrefeuilles.webshop.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class File {

    @Id
    private String id;

    private String url;

    @DBRef
    private List<Page> pages;

    public double price() {
        return pages.stream()
                .mapToDouble(Page::getPrice)
                .sum();
    }

}