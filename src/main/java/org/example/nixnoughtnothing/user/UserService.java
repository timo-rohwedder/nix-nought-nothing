package org.example.nixnoughtnothing.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUserList() {
        return userRepository.getUserList();
    }

    public User getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public User createUser(User user) {
        var userEntity = new UserEntity();
        userEntity.setName(user.name());

        var savedUser = userRepository.save(userEntity);

        return User.builder()
                .name(savedUser.getName())
                .build();
    }
}
