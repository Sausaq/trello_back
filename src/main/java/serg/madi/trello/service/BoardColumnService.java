package serg.madi.trello.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import serg.madi.trello.dto.BoardColumnRequest;
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
        return columnRepository.findByBoardIdOrderByOrderNumberAsc(boardId);
    }

    public BoardColumn createColumn(BoardColumnRequest column) {
        Board board = boardRepository.findById(column.boardId()).orElseThrow();
        BoardColumn newColumn = new BoardColumn();
        newColumn.setTitle(column.title());
        newColumn.setDescription(column.description());
        newColumn.setBoard(board);
        return columnRepository.save(newColumn);
    }

    public BoardColumn updateColumn(Integer boardId, BoardColumnRequest column) {
        BoardColumn existColumn = boardColumnRepository.findById(boardId).orElseThrow();
        existColumn.setTitle(column.title());
        existColumn.setDescription(column.description());
        return columnRepository.save(existColumn);
    }

    public void deleteColumn(Integer columnId) {
        boardColumnRepository.deleteById(columnId);
    }

    public void moveColumn(Integer columnId, Integer newOrder) {
        BoardColumn column = columnRepository.findById(columnId).orElseThrow();
        column.setOrderNumber(newOrder);
        columnRepository.save(column);
    }
}
