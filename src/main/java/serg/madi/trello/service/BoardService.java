package serg.madi.trello.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import serg.madi.trello.dto.BoardRequest;
import serg.madi.trello.entity.Board;
import serg.madi.trello.repository.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board getBoardById(Integer boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board createBoard(BoardRequest board) {
        Board newBoard = new Board();
        newBoard.setTitle(board.title());
        return boardRepository.save(newBoard);
    }

    public void deleteBoard(Integer boardId) {
        boardRepository.deleteById(boardId);
    }

    public Board updateBoard(Integer boardId, BoardRequest updatedBoard) {
        Board existingBoard = getBoardById(boardId);
        existingBoard.setTitle(updatedBoard.title());
        return boardRepository.save(existingBoard);
    }
}

