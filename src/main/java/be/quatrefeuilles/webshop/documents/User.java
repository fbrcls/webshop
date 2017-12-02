package be.quatrefeuilles.webshop.documents;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {

    private String firstName;
    private String lastName;
    private List<Command> Commands;

}
