package serg.madi.trello.dto;

public record CardRequest(String title, String description, Integer columnId) {
}