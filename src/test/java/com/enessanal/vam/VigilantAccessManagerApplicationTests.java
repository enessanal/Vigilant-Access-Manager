package com.enessanal.vam;

import com.enessanal.vam.model.Asset;
import com.enessanal.vam.model.User;
import com.enessanal.vam.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VigilantAccessManagerApplicationTests
{

    @Autowired
    private UserRepository userRepository;

    @Test
    @Disabled
    void contextLoads()
    {

    }

    @Test
    public void initUsers()
    {

        User user = new User("test_user1");
        Asset asset1 = new Asset("192.168.1.12");
        Asset asset2 = new Asset("192.168.100.210");



        user.getAssets().add(asset1);
        user.getAssets().add(asset2);

        User savedUser = userRepository.save(user);

        System.out.println(savedUser);
        System.out.println(savedUser.getAssets());
    }

}
