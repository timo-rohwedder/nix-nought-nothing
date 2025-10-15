package org.example.nixnoughtnothing.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    User findUserByName(String name);

    List<User> getUserList();

}
