package com.vipul.expense;

import com.vipul.expense.model.User;
import com.vipul.expense.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    UserRepo repo;

    @PostMapping("/add")
    public void addUser(@RequestBody User user ) {
        repo.save(user);
    }
}
