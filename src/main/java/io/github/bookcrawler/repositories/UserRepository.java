package io.github.bookcrawler.repositories;

import io.github.bookcrawler.entities.RobotUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<RobotUser,String> {

}
