package com.ericnorrwing.wsj_lek_4.controller;


import com.ericnorrwing.wsj_lek_4.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {

    //getMapping Method level, requestMapping class and method level
    //Patch/put mappings, indempotent//non-indempotent (Might be wrong order D: )

    private final List<User> userList = new ArrayList<>(
            List.of(
                    new User(1 ,"benny", "123"),
                    new User(2, "Frida", "456")
            )
    );

    @GetMapping
    public List<User> getUsers() {
        return userList;
    }

    @PostMapping("/{username}")
    public boolean postUser(@PathVariable String username) {
        return userList.add(new User(userList.size()+1,username, "1337"));
    }

    @DeleteMapping("/{id}")
    public User removeUserById(@PathVariable int id){
        for (User user: userList){
            if (user.id() == id)
                return userList.remove(id);
        }
        return null;
    }
}
