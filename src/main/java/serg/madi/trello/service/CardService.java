package serg.madi.trello.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import serg.madi.trello.dto.CardRequest;
import serg.madi.trello.entity.Card;
import serg.madi.trello.entity.BoardColumn;
import serg.madi.trello.repository.CardRepository;
import serg.madi.trello.repository.BoardColumnRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final BoardColumnRepository columnRepository;

    public List<Card> getCardsByColumn(Integer columnId) {
        return cardRepository.findByColumnIdOrderByIdAsc(columnId);
    }

    public Card createCard(CardRequest card) {
        BoardColumn column = columnRepository.findById(card.columnId()).orElseThrow(() -> new RuntimeException("Column not found"));
        Card newCard = new Card();
        newCard.setTitle(card.title());
        newCard.setDescription(card.description());
        newCard.setColumn(column);
        return cardRepository.save(newCard);
    }

    public Card getCard(Integer cardId) {
        return cardRepository.findById(cardId).orElseThrow(() -> new RuntimeException("Card not found"));
    }

    public void deleteCard(Integer cardId) {
        cardRepository.deleteById(cardId);
    }

    public Card updateCard(Integer cardId, CardRequest updatedCard) {
        Card card = cardRepository.findById(cardId).orElseThrow(() -> new RuntimeException("Card not found"));
        card.setTitle(updatedCard.title());
        card.setDescription(updatedCard.description());
        return cardRepository.save(card);
    }

    public void moveCard(Integer cardId, Integer newColumnId) {
        Card card = cardRepository.findById(cardId).orElseThrow();
        BoardColumn newColumn = columnRepository.findById(newColumnId).orElseThrow();
        card.setColumn(newColumn);
        cardRepository.save(card);
    }
}

