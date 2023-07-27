package com.enessanal.vam;

import com.enessanal.vam.dto.UserAddDto;
import com.enessanal.vam.model.User;
import com.enessanal.vam.service.UserService;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDatabase
{
    @Autowired
    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase()
    {
        return args ->
        {
            Faker faker= new Faker();

            List<User> users = new ArrayList<>();
            for(int i=0;i<40; i++)
            {
                UserAddDto user = new UserAddDto();
                user.setUsername(faker.name().username());
                user.setEmail(faker.internet().safeEmailAddress());
                user.setPassword(faker.crypto().md5());
                user.setFirstName(faker.name().firstName());
                user.setLastName(faker.name().lastName());

                userService.addUser(user);

            }
        };
    }
}
