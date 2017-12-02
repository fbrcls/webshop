package be.quatrefeuilles.webshop.documents;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Command {

    private List<Status> status;
    private List<Document> documents;

}
