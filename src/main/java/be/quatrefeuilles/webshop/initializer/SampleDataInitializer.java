
package be.quatrefeuilles.webshop.initializer;

import be.quatrefeuilles.webshop.documents.User;
import be.quatrefeuilles.webshop.repository.CommandRepository;
import be.quatrefeuilles.webshop.repository.UserRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static be.quatrefeuilles.webshop.initializer.CommandMother.*;
import static be.quatrefeuilles.webshop.initializer.UserMother.mickey;
import static be.quatrefeuilles.webshop.initializer.UserMother.minnie;
import static com.google.common.collect.Lists.newArrayList;

@Component
@CommonsLog
public class SampleDataInitializer implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommandRepository commandRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        commandRepository.deleteAll();
        userRepository.deleteAll();

        User mickey = mickey();
        mickey.addCommand(commandRepository.save(payedCommand()));
        mickey.addCommand(commandRepository.save(deliveredCommand()));

        User minnie = minnie();
        minnie.addCommand(commandRepository.save(newCommand()));
        minnie.addCommand(commandRepository.save(printedCommand()));

        userRepository.saveAll(newArrayList(mickey, minnie));

    }

}