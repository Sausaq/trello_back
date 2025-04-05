package serg.madi.trello.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serg.madi.trello.entity.Card;
import serg.madi.trello.service.CardService;

import java.util.List;

@RestController
@RequestMapping("/api/columns/{columnId}/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public List<Card> getCards(@PathVariable Integer columnId) {
        return cardService.getCardsByColumn(columnId);
    }

    @PostMapping
    public Card createCard(@PathVariable Integer columnId, @RequestBody Card card) {
        return cardService.createCard(columnId, card);
    }

    @PutMapping("/{cardId}/move/{newColumnId}")
    public void moveCard(@PathVariable Integer cardId, @PathVariable Integer newColumnId) {
        cardService.moveCard(cardId, newColumnId);
    }
}
