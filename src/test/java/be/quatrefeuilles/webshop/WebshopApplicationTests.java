package be.quatrefeuilles.webshop;

import be.quatrefeuilles.webshop.repository.CommandRepository;
import be.quatrefeuilles.webshop.repository.UserRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@CommonsLog
public class WebshopApplicationTests {

	@Autowired
	private CommandRepository commandRepository;

	@Autowired
	private UserRepository userRepository;

//	@Test
//	public void contextLoads() {
//	}

    @Test
    public void findAllCommands() {
        commandRepository.findAll().stream().forEach(log::info);
    }

    @Test
    public void findPayedCommands() {
        commandRepository.findPayedCommands().stream().forEach(c -> log.info(c.currentStatus()));
    }

}