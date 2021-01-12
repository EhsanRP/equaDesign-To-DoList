package ir.equaDesign.equaDesignToDoList.bootstrap;

import ir.equaDesign.equaDesignToDoList.domain.ToDo;
import ir.equaDesign.equaDesignToDoList.repositories.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"default", "H2"})
@Component
public class BootstrapDataH2 implements CommandLineRunner {

    private final ToDoRepository toDoRepository;

    public BootstrapDataH2( ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (toDoRepository.count() == 0)
            loadToDoes();

        System.out.println(toDoRepository.count());
    }

    private void loadToDoes() {
        toDoRepository.save(ToDo.builder().description("TO Do 1").build());
        toDoRepository.save(ToDo.builder().description("TO Do 2").build());
        toDoRepository.save(ToDo.builder().description("TO Do 3").build());
        toDoRepository.save(ToDo.builder().description("TO Do 4").build());
        toDoRepository.save(ToDo.builder().description("TO Do 5").build());

    }
}
