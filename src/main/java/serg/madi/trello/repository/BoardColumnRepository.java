package serg.madi.trello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serg.madi.trello.entity.BoardColumn;

import java.util.List;

@Repository
public interface BoardColumnRepository extends JpaRepository<BoardColumn, Integer> {
    List<BoardColumn> findByBoardIdOrderByIdAsc(Integer boardId);

}
