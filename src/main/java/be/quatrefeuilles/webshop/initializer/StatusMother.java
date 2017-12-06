package be.quatrefeuilles.webshop.initializer;

import be.quatrefeuilles.webshop.documents.Status;

import static be.quatrefeuilles.webshop.documents.StatusCode.*;
import static java.time.LocalDateTime.now;

public class StatusMother {

    public static Status statusNew() {
        return Status.builder()
                .statusCode(NEW)
                .date(now())
                .build();
    }

    public static Status statusPayed() {
        return Status.builder()
                .statusCode(PAYED)
                .date(now())
                .build();
    }

    public static Status statusPrinted() {
        return Status.builder()
                .statusCode(PRINTED)
                .date(now())
                .build();
    }

    public static Status statusDelivered() {
        return Status.builder()
                .statusCode(DELIVERED)
                .date(now())
                .build();
    }

}
