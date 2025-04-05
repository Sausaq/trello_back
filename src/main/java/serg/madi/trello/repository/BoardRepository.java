package serg.madi.trello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serg.madi.trello.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
}