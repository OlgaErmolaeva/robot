package io.github.bookcrawler.repositories;

import io.github.bookcrawler.entities.RobotUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends JpaRepository<RobotUser,String> {

    List<RobotUser> findByLogin(String login);
}
