package com.epam.jtc.sofiia.gorbatova.cards.generator.model;

import java.util.List;

public class Card {
    private List<Integer> number;
    private int length;
    private final PaymentSystemType type;

    public Card(PaymentSystemType type) {
        this.type = type;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public PaymentSystemType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + " card\n" +
                "Payment card number: " + number;
    }
}
