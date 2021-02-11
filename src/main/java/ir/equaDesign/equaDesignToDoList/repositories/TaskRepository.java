package ir.equaDesign.equaDesignToDoList.repositories;

import ir.equaDesign.equaDesignToDoList.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<ToDo, Integer> {
}
