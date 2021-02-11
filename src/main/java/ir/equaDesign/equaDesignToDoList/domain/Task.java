package ir.equaDesign.equaDesignToDoList.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = {"user"})
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Task")
    private String description;

    @Column
    private boolean isDone;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User user;

    @Builder
    public Task(String description , boolean isDone, User user) {
        this.description = description;
        this.isDone = isDone;
        this.user = user;
    }
}
