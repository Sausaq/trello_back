package serg.madi.trello.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serg.madi.trello.dto.BoardColumnRequest;
import serg.madi.trello.entity.BoardColumn;
import serg.madi.trello.service.BoardColumnService;

import java.util.List;

@RestController
@RequestMapping("/api/boards/{boardId}/columns")
@RequiredArgsConstructor
public class BoardColumnController {
    private final BoardColumnService columnService;

    @GetMapping
    public List<BoardColumn> getColumns(@PathVariable Integer boardId) {
        return columnService.getColumnsByBoard(boardId);
    }

    @PostMapping
    public BoardColumn createColumn(@RequestBody BoardColumnRequest column) {
        return columnService.createColumn(column);
    }

    @PatchMapping("/{columnId}")
    public BoardColumn updateColumn(@PathVariable Integer columnId, @RequestBody BoardColumnRequest column) {
        return columnService.updateColumn(columnId, column);
    }

    @DeleteMapping("/{columnId}")
    public void deleteColumn(@PathVariable Integer columnId) {
        columnService.deleteColumn(columnId);
    }

}

