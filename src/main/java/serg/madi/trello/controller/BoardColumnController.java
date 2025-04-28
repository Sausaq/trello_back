package serg.madi.trello.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serg.madi.trello.dto.BoardColumnRequest;
import serg.madi.trello.dto.CardRequest;
import serg.madi.trello.entity.BoardColumn;
import serg.madi.trello.entity.Card;
import serg.madi.trello.service.BoardColumnService;
import serg.madi.trello.service.CardService;

import java.util.List;

@RestController
@RequestMapping("/api/columns")
@RequiredArgsConstructor
public class BoardColumnController {
    private final BoardColumnService columnService;
    private final CardService cardService;


    @PatchMapping("/{columnId}")
    public BoardColumn updateColumn(@PathVariable Integer columnId, @RequestBody BoardColumnRequest column) {
        return columnService.updateColumn(columnId, column);
    }

    @DeleteMapping("/{columnId}")
    public void deleteColumn(@PathVariable Integer columnId) {
        columnService.deleteColumn(columnId);
    }

    @GetMapping("/{columnId}/cards")
    public List<Card> getCards(@PathVariable Integer columnId) {
        return cardService.getCardsByColumn(columnId);
    }

    @PostMapping("/{columnId}/cards")
    public Card createCard(@RequestBody CardRequest card) {
        return cardService.createCard(card);
    }

    @PatchMapping("/{columnId}/move/{newOrder}")
    public void moveColumn(@PathVariable Integer columnId, @PathVariable Integer newOrder){
        columnService.moveColumn(columnId, newOrder);
    }
}

