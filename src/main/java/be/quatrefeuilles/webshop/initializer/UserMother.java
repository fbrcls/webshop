package be.quatrefeuilles.webshop.initializer;

import be.quatrefeuilles.webshop.documents.User;

public class UserMother {

    public static User mickey() {
        return User.builder()
                .firstName("Mickey")
                .lastName("Mouse")
                .email("mickey.mouse@disney.com")
                .build();
    }

    public static User minnie() {
        return User.builder()
                .firstName("Minnie")
                .lastName("Mouse")
                .email("minnie.mouse@disney.com")
                .build();
    }

}