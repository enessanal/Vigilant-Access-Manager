package com.enessanal.vam;

import com.enessanal.vam.model.Asset;
import com.enessanal.vam.model.User;
import com.enessanal.vam.repository.AssetRepository;
import com.enessanal.vam.repository.UserRepository;
import com.enessanal.vam.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.util.List;

@Configuration
public class LoadDatabase
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private UserService userService;



    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase()
    {
        return args -> {
            log.info("Preloading " + userRepository.save(new User("enes")));
            log.info("Preloading " + userRepository.save(new User("jack")));
            log.info("Preloading " + userRepository.save(new User("daniel")));


            User user = new User("user_has_asset");
            userRepository.save(user);

            Asset asset1 = new Asset("norealapi.com.com.comc.om.com");
            Asset asset2 = new Asset("2.3.1.1");

            asset1.setUser(user);
            asset2.setUser(user);

            assetRepository.save(asset1);
            assetRepository.save(asset2);






//            log.info("Preloading " + assetRepository.save(new Asset("1.1.1.1")));
//            log.info("Preloading " + assetRepository.save(new Asset("8.8.8.8")));
//            log.info("Preloading " + assetRepository.save(new Asset("google.com")));



        };
    }
}
