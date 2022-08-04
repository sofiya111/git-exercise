package com.epam.jtc.sofiia.gorbatova.cards.generator.controller;

import com.epam.jtc.sofiia.gorbatova.cards.generator.model.Card;
import com.epam.jtc.sofiia.gorbatova.cards.generator.model.CardGenerator;
import com.epam.jtc.sofiia.gorbatova.cards.generator.model.PaymentSystemType;
import com.epam.jtc.sofiia.gorbatova.cards.generator.model.util.CardValidator;
import com.epam.jtc.sofiia.gorbatova.cards.generator.view.ConsoleView;

public final class CardGeneratorRunner {

    private static final ConsoleView consoleView = new ConsoleView();

    private CardGeneratorRunner() {
    }

    public static void main(String[] paymentSystems) {
        new CardGeneratorRunner().generateCards(paymentSystems);
    }

    public void generateCards(String[] paymentSystems) {
        CardGenerator cardGenerator = new CardGenerator();
        CardValidator cardValidator = new CardValidator();
        for (String paymentSystem : paymentSystems) {
            if (cardValidator.isValidCard(paymentSystem)) {
                Card card = cardGenerator
                        .generateCard(PaymentSystemType.valueOf(paymentSystem));
                consoleView.printCard(card);
            } else {
                consoleView.printError();
            }
        }
    }
}
