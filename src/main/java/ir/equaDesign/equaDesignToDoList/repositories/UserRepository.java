package ir.equaDesign.equaDesignToDoList.repositories;

import ir.equaDesign.equaDesignToDoList.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
