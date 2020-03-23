package com.hasitha.springbootsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
public class HomeResource {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome user</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome admin</h1>");
    }


    /*I used below method only for saving user and role data into  DB. Here among user and role there is
    * a many to many relationship.*/
    @GetMapping("/saveData")
    public String saveData(){
        User user1= new User();
        user1.setUserName("hasitha");
        user1.setPassWord("hasitha");
        user1.setActive(true);

        User user2= new User();
        user2.setUserName("kamal");
        user2.setPassWord("kamal");
        user2.setActive(true);



        Role adminRole= new Role();
        adminRole.setRoll("ROLE_ADMIN");

        Role userRole= new Role();
        userRole.setRoll("ROLE_USER");

        List<Role> user1Roles= new ArrayList<>();
        user1Roles.add(adminRole);
        user1Roles.add(userRole);


        List<Role> user2Roles= new ArrayList<>();
        user2Roles.add(userRole);

        user1.setRoles(user1Roles);
        user2.setRoles(user2Roles);


        adminRole.getUsers().add(user1);

        userRole.getUsers().add(user1);
        userRole.getUsers().add(user2);



        userRepository.save(user1);
        userRepository.save(user2);

        return ("<h1>Data Saved Successfully...</h1>");
    }


}
