package be.quatrefeuilles.webshop.initializer;

import be.quatrefeuilles.webshop.documents.Command;

import static be.quatrefeuilles.webshop.initializer.StatusMother.*;
import static com.google.common.collect.Lists.newArrayList;

public class CommandMother {

    public static Command newCommand() {
        return Command.builder()
                .statuses(newArrayList(statusNew()))
                .build();
    }

    public static Command payedCommand() {
        return Command.builder()
                .statuses(newArrayList(statusNew(), statusPayed()))
                .build();
    }

    public static Command printedCommand() {
        return Command.builder()
                .statuses(newArrayList(statusNew(), statusPayed(), statusPrinted()))
                .build();
    }

    public static Command deliveredCommand() {
        return Command.builder()
                .statuses(newArrayList(statusNew(), statusPayed(), statusPrinted(), statusDelivered()))
                .build();
    }

}