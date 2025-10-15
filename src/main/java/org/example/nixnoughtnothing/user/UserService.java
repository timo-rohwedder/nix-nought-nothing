package org.example.nixnoughtnothing.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public User createUser(User user) {
        if (user == null || user.name() == null || user.name().isBlank()) {
            throw new IllegalArgumentException("User name must not be blank");
        }

        var userEntity = new UserEntity();
        userEntity.setName(user.name());

        var savedUser = userRepository.save(userEntity);

        return User.builder()
                .name(savedUser.getName())
                .build();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id)
                .map(u -> User.builder().name(u.getName()).build());
    }
}
