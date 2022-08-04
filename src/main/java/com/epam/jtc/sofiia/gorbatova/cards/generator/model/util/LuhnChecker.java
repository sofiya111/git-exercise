package com.epam.jtc.sofiia.gorbatova.cards.generator.model.util;

import java.util.List;

public class LuhnChecker {

    public LuhnChecker() {
    }

    public int getLuhnAlgorithmSum(List<Integer> cardNumber) {
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = cardNumber.size(); i > 0; i--) {
            int digit = cardNumber.get(i - 1);
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
                sumEven += digit;
            } else {
                sumOdd += digit;
            }
        }
        int sum = sumEven + sumOdd;

        return sum;
    }
}
