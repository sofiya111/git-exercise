package com.epam.jtc.sofiia.gorbatova.cards.generator.model.util;

import java.security.SecureRandom;
import java.util.Random;

public class Range {
    private int min;
    private int max;

    public Range(int minNumber, int maxNumber) {
        this.min = minNumber;
        this.max = maxNumber;
    }

    public int generateIssuerIdentificationNumber(){
        Random number = new SecureRandom();
        return number.nextInt(max - min + 1) + min;
    }
}
