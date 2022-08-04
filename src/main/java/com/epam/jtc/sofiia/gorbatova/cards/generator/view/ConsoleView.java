package com.epam.jtc.sofiia.gorbatova.cards.generator.view;

import com.epam.jtc.sofiia.gorbatova.cards.generator.model.Card;

import java.util.stream.Collectors;

public final class ConsoleView {
    private static final String TEMPLATE_CARD_MESSAGE = "%s card number: %s \n";
    private static final String INVALID_PAYMENT_SYSTEM_MESSAGE = "Invalid payment system";

    public ConsoleView() {
    }

    public void printCard(Card card) {
        System.out.printf(TEMPLATE_CARD_MESSAGE, card.getType(), card.getNumber().stream()
                .map(Object::toString)
                .collect(Collectors.joining()));
    }

    public void printError(){
        System.out.println(INVALID_PAYMENT_SYSTEM_MESSAGE);
    }
}
