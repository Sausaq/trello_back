package serg.madi.trello.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import serg.madi.trello.entity.Card;
import serg.madi.trello.entity.BoardColumn;
import serg.madi.trello.repository.CardRepository;
import serg.madi.trello.repository.BoardColumnRepository;

import java.util.List;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final BoardColumnRepository columnRepository;

    public List<Card> getCardsByColumn(Integer columnId) {
        return cardRepository.findByColumnId(columnId);
    }

    public Card createCard(Integer columnId, Card card) {
        BoardColumn column = columnRepository.findById(columnId).orElseThrow();
        card.setColumn(column);
        return cardRepository.save(card);
    }

    public void moveCard(Integer cardId, Integer newColumnId) {
        Card card = cardRepository.findById(cardId).orElseThrow();
        BoardColumn newColumn = columnRepository.findById(newColumnId).orElseThrow();
        card.setColumn(newColumn);
        cardRepository.save(card);
    }
}

