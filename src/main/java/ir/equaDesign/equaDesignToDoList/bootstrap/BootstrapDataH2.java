package ir.equaDesign.equaDesignToDoList.bootstrap;

import ir.equaDesign.equaDesignToDoList.domain.Task;
import ir.equaDesign.equaDesignToDoList.domain.User;
import ir.equaDesign.equaDesignToDoList.repositories.UserRepository;
import ir.equaDesign.equaDesignToDoList.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"default", "h2"})
@Component
public class BootstrapDataH2 implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserService userService;

    public BootstrapDataH2(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        loadToDoes();


        System.out.println(userService.updateTask(1,1,"trying").getDescription());
    }

    private void loadToDoes() {

        userCreator("Ehsan",5);
        userCreator("Negar",5);
        userCreator("Arian",5);

    }

    private void userCreator(String name, int tasksCount) {
        var user = User.builder().name(name).build();
        addtasks(user , tasksCount);
        userRepository.save(user);
    }

    private void addtasks(User user, int bound) {
        for (int i = 1; i <= bound ; i++) {
            var task = Task.builder().user(user).description("task " + i).build();
            user.getTasks().add(task);
        }
    }

}
