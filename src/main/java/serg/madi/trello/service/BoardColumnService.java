package serg.madi.trello.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import serg.madi.trello.entity.Board;
import serg.madi.trello.entity.BoardColumn;
import serg.madi.trello.repository.BoardColumnRepository;
import serg.madi.trello.repository.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardColumnService {
    private final BoardColumnRepository columnRepository;
    private final BoardRepository boardRepository;

    public List<BoardColumn> getColumnsByBoard(Integer boardId) {
        return columnRepository.findByBoardId(boardId);
    }

    public BoardColumn createColumn(Integer boardId, BoardColumn column) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        column.setBoard(board);
        return columnRepository.save(column);
    }
}
