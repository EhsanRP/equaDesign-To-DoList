package ir.equaDesign.equaDesignToDoList.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "To_DO")
    private String description;

    @Column(name = "Status")
    private boolean isDone;

    @Builder
    public ToDo(String description , boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

}
