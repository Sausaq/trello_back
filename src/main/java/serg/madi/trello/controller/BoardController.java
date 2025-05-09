package serg.madi.trello.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serg.madi.trello.dto.BoardColumnRequest;
import serg.madi.trello.dto.BoardRequest;
import serg.madi.trello.entity.Board;
import serg.madi.trello.entity.BoardColumn;
import serg.madi.trello.service.BoardColumnService;
import serg.madi.trello.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final BoardColumnService columnService;



    @GetMapping("/{id}")
    public Board getBoard(@PathVariable Integer id) {
        return boardService.getBoardById(id);
    }

    @GetMapping
    public List<Board> getBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping("/userId")
    public List<Board> getBoardsByUserId(@RequestParam Integer userId) {
        return boardService.getAllBoardsByUserId(userId);
    }

    @PostMapping
    public Board createBoard(@RequestBody BoardRequest board) {
        return boardService.createBoard(board);
    }

    @PatchMapping("/{id}")
    public Board updateBoard(@PathVariable Integer id, @RequestBody BoardRequest board) {
        return boardService.updateBoard(id, board);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Integer id) {
        boardService.deleteBoard(id);
    }

    @GetMapping("/{boardId}/columns")
    public List<BoardColumn> getColumns(@PathVariable Integer boardId) {
        return columnService.getColumnsByBoard(boardId);
    }

    @PostMapping("/{boardId}/columns")
    public BoardColumn createColumn(@RequestBody BoardColumnRequest column) {
        return columnService.createColumn(column);
    }

}
