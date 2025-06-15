package com.vipul.expense;

import com.vipul.expense.model.User;
import com.vipul.expense.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private UserRepo repo;

    @PostMapping
    @Transactional
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty() || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return ResponseEntity.badRequest().build();
        }

        User savedUser = repo.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsersByName(@RequestParam String name) {
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<User> users = repo.findByName(name);
        return ResponseEntity.ok(users);
    }


}
