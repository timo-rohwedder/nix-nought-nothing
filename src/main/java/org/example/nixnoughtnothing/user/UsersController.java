package org.example.nixnoughtnothing.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUserList() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @GetMapping("/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        var createdUser = userService.createUser(user);

        var createdUri = MvcUriComponentsBuilder.fromMethodCall(on(UsersController.class).getUserByName(createdUser.name())).build().toUri();

        return ResponseEntity.created(createdUri).build();
    }
}
