package be.quatrefeuilles.webshop.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;

    @DBRef
    private List<Command> commands;

    public void addCommand(Command command) {
        if (commands == null) {
            commands = new ArrayList();
        }
        commands.add(command);
    }

}
