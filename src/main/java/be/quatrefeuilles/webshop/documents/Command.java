package be.quatrefeuilles.webshop.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static java.util.Comparator.comparing;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Command {

    @Id
    private String id;

    private List<Status> statuses;
    private List<File> files;

    public Status currentStatus() {
        return statuses.stream()
                .sorted(comparing(Status::getDate).reversed())
                .findFirst()
                .get();
    }

    public double price() {
        return files.stream()
                .mapToDouble(File::price)
                .sum();
    }

}