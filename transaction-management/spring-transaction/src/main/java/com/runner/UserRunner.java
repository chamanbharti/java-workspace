package com.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;
import com.service.UserService;

import java.util.Arrays;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;
    
    @Transactional
    @Override
    public void run(String... strings) throws Exception {

    	// step I
          try {
        	  User user1 = new User("Peter", "Ops", 12000L);
              User user2 = new User("Sam", "Tech", 22000L);
              User user3 = new User("Ryan King", "Tech", 32000L);
              User user4 = new User("Nick", "Ops", 18000L);
              userService.insert(Arrays.asList(
                      user1, user2,user3, user4
              ));
		} catch (RuntimeException e) {
			  System.out.println("Exception...!"+e.getMessage());
		}
        System.out.println(userService.getUsers());
    	
    	// step II
//        try {
//            User user1 = new User("Peter", "Ops", 12000L);
//            User user2 = new User("Sam", "Tech", 22000L);
//            userService.insert(Arrays.asList(
//                    user1, user2
//            ));
//        }
//        catch (RuntimeException exception) {
//            System.out.println("Exception in batch 1...!" + exception.getMessage());
//        }
//
//
//        try {
//            User user3 = new User("Ryan King", "Tech", 32000L);
//            User user4 = new User("Nick", "Ops", 18000L);
//            userService.insert(Arrays.asList(
//                    user3, user4
//            ));
//        }
//        catch (RuntimeException exception) {
//            System.out.println("Exception in batch 2...!" + exception.getMessage());
//        }
//       System.out.println(userService.getUsers());
    }
}
