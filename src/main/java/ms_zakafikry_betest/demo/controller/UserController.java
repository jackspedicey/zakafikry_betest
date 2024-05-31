package ms_zakafikry_betest.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ms_zakafikry_betest.demo.entity.User;
import ms_zakafikry_betest.demo.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<User>> createUsers(@RequestBody List<User> users) {
        List<User> createdUsers = userService.createUsers(users);
        return ResponseEntity.ok(createdUsers);
    }


    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<Optional<User>> getUserByAccountNumber(@PathVariable String accountNumber) {
        Optional<User> user = userService.getUserByAccountNumber(accountNumber);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/identity/{identityNumber}")
    public ResponseEntity<Optional<User>> getUserByIdentityNumber(@PathVariable String identityNumber) {
        Optional<User> user = userService.getUserByIdentityNumber(identityNumber);
        return ResponseEntity.ok(user);
    }
}