package serg.madi.trello.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serg.madi.trello.dto.CardRequest;
import serg.madi.trello.entity.Card;
import serg.madi.trello.service.CardService;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping("/{cardId}")
    public Card getCard(@PathVariable Integer cardId) {
        return cardService.getCard(cardId);
    }

    @DeleteMapping("/{cardId}")
    public void deleteCard(@PathVariable Integer cardId) {
        cardService.deleteCard(cardId);
    }

    @PatchMapping("/{cardId}")
    public Card updateCard(@PathVariable Integer cardId, @RequestBody CardRequest updatedCard) {
        return cardService.updateCard(cardId, updatedCard);
    }

    @PatchMapping("/{cardId}/move/{newColumnId}")
    public void moveCard(@PathVariable Integer cardId, @PathVariable Integer newColumnId) {
        cardService.moveCard(cardId, newColumnId);
    }
}
