package com.lcwd.electronic.store.repositories;

import com.lcwd.electronic.store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByEmail(String  email);
    Optional<User> findByEmailAndPassword(String email,String password);
    List<User> findByNameContaining(String keywords);

}
