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
    private final BoardColumnRepository boardColumnRepository;

    public List<BoardColumn> getColumnsByBoard(Integer boardId) {
        return columnRepository.findByBoardId(boardId);
    }

    public BoardColumn createColumn(Integer boardId, BoardColumn column) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        column.setBoard(board);
        return columnRepository.save(column);
    }

    public BoardColumn updateColumn(Integer boardId, BoardColumn column) {
        BoardColumn existColumn = boardColumnRepository.findById(boardId).orElseThrow();
        existColumn.setTitle(column.getTitle());
        existColumn.setDescription(column.getDescription());
        return columnRepository.save(existColumn);
    }

    public void deleteColumn(Integer columnId) {
        boardColumnRepository.deleteById(columnId);
    }
}
