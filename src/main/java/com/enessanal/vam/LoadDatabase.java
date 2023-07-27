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
            for(int i=0;i<5; i++)
            {
                UserAddDto user = new UserAddDto();
                user.setUsername(faker.name().username());
                user.setEmail(faker.internet().safeEmailAddress());
                user.setPassword(faker.crypto().md5());
                user.setFirstName(faker.name().firstName());
                user.setLastName(faker.name().lastName());

                userService.addUser(user);

            }













//            log.info("Preloading " + userRepository.save(new User("enes")));
//            log.info("Preloading " + userRepository.save(new User("jack")));
//            log.info("Preloading " + userRepository.save(new User("daniel")));
////
////
//            User user = new User("user_has_asset");
//            userRepository.save(user);
////
//            Asset asset1 = new Asset("norealapi.com.com.comc.om.com");
//            Asset asset2 = new Asset("2.3.1.1");
////
//            asset1.setUser(user);
//            asset2.setUser(user);
////
//            assetRepository.save(asset1);
//            assetRepository.save(asset2);


//            Faker faker= new Faker();
//
//
//            List<User> users = new ArrayList<>();
//            for(int i=0;i<5; i++)
//            {
//                User user = new User(faker.name().username(), faker.internet().safeEmailAddress());
//                user.setPassword(faker.crypto().md5());
//                users.add(user);
//            }
//
//            userRepository.saveAll(users);



//            userRepository.save(new User("aaaaaaaaaaaaaaa11","11"));
//            userRepository.save(new User("aaaaaaaaaaaaaaa112","1"));



//            log.info("Preloading " + assetRepository.save(new Asset("1.1.1.1")));
//            log.info("Preloading " + assetRepository.save(new Asset("8.8.8.8")));
//            log.info("Preloading " + assetRepository.save(new Asset("google.com")));



        };
    }
}
