package serg.madi.trello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import serg.madi.trello.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLogin(String login);
}
