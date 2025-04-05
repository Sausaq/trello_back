package serg.madi.trello.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "board_columns")
public class BoardColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;
}
