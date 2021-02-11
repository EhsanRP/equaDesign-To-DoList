package ir.equaDesign.equaDesignToDoList.repositories;

import ir.equaDesign.equaDesignToDoList.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
