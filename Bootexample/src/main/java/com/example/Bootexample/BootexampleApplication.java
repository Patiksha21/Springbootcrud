package com.example.Bootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Optional;
import java.util.*;
import com.example.Bootexample.dao.UserRepository;
import com.example.Bootexample.entities.User;

@SpringBootApplication
public class BootexampleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootexampleApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

        // Create a new user
        User user = new User();
        user.setName("Pratiksha Shinde");
        user.setCity("Pune");
        user.setStatus("I am a Java developer");
        
        User user1 = new User();
        user1.setName("Pooja Shinde");
        user1.setCity("Nagpur");
        user1.setStatus("I am a Sql developer");
        
       
        User user2 = new User();
        user2.setName("sakshi verma");
        user2.setCity("Sangavi");
        user2.setStatus("I am a Backend developer");



        // Save the user to the database
       userRepository.save(user);
        System.out.println("User saved successfully: " + user);
        
      /*  userRepository.save(user1);
        System.out.println("User saved successfully: " + user1);

        userRepository.save(user2);
        System.out.println("User saved successfully: " + user2);*/
        
        List<User> users= List.of( user,user1,user2);
        Iterable<User>saveAll = userRepository.saveAll(users);
        
        //save multiple objects
        saveAll.forEach(savedUser -> System.out.println("Saved user: " + savedUser));

        

        // Update an existing user
        int userIdToUpdate = 2; // ID of the user to update
        Optional<User> optional = userRepository.findById(userIdToUpdate);
        if (optional.isPresent()) {
            User existingUser = optional.get();
            existingUser.setCity("Mumbai"); // Update the city
            userRepository.save(existingUser); // Save the updated user
            System.out.println("User updated successfully: " + existingUser);
        } else {
            System.out.println("User with ID " + userIdToUpdate + " not found.");
        }
        
        //how to get the data
        /*Iterable<User> itr=userRepository.findAll();
        Iterator<User> iterator = itr.iterator();
        while(iterator.hasNext())
        {
        	User currentuser=iterator.next();
        	System.out.println(currentuser);*/
     // Retrieve and print all users from the database
        Iterable<User> itr = userRepository.findAll();

        // Using lambda expression with forEach
        itr.forEach(cuser -> System.out.println(users));
        
        //deleting the user
        userRepository.deleteById(652);
        System.out.println("deleted");
        
    }

}
