package com.epam.jtc.sofiia.gorbatova.cards.generator.model;

import com.epam.jtc.sofiia.gorbatova.cards.generator.model.util.LuhnChecker;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardGenerator {
    private static final int RANGE_SIZE = 10;
    private static final int CALCULATE_VAR = 10;
    private static final LuhnChecker luhnChecker = new LuhnChecker();
    private Random randomGenerator = new SecureRandom();

    public Card generateCard(PaymentSystemType type) {
        Card card = new Card(type);
        List<Integer> cardNumber;
        int issuerIdentificationNumber = getIssuerIdentificationNumber(card);
        int lengthCard = getLengthCard(card);
        cardNumber = getDigitsList(issuerIdentificationNumber);
        for (int i = 0; i < lengthCard -
                String.valueOf(issuerIdentificationNumber).length() - 1; i++) {
            int n = randomGenerator.nextInt(RANGE_SIZE);
            cardNumber.add(n);
        }
        int lastNumber = luhnChecker.getLuhnAlgorithmSum(cardNumber) % 10;
        cardNumber.add(10 - lastNumber);
        card.setNumber(cardNumber);

        return card;
    }

    private int getIssuerIdentificationNumber(Card card) {
        int sizeIssuerIdentificationNumber =
                card.getType().getIssuerIdentificationNumber().size();
        int randomIssuerIdentificationNumber =
                randomGenerator.nextInt(sizeIssuerIdentificationNumber);

        return card.getType().getIssuerIdentificationNumber()
                .get(randomIssuerIdentificationNumber)
                .generateIssuerIdentificationNumber();
    }

    private int getLengthCard(Card card) {
        int sizeDigitsNumber =
                card.getType().getDigitsNumber().size();
        int randomDigitsNumber =
                randomGenerator.nextInt(sizeDigitsNumber);

        return card.getType().getDigitsNumber()
                .get(randomDigitsNumber)
                .generateIssuerIdentificationNumber();
    }

    private List<Integer> getDigitsList(int number) {
        List<Integer> numberList = new ArrayList<>();
        while (number != 0) {
            numberList.add(number % CALCULATE_VAR);
            number = number / CALCULATE_VAR;
        }
        Collections.reverse(numberList);

        return numberList;
    }


}
