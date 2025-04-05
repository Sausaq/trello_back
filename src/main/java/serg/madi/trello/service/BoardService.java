package serg.madi.trello.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public void deleteBoard(Integer boardId) {
        boardRepository.deleteById(boardId);
    }

    public Board updateBoard(Integer boardId, Board updatedBoard) {
        Board existingBoard = getBoardById(boardId);
        existingBoard.setTitle(updatedBoard.getTitle());
        return boardRepository.save(existingBoard);
    }
}

