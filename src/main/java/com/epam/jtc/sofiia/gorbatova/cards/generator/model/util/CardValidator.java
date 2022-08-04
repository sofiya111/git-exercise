package com.epam.jtc.sofiia.gorbatova.cards.generator.model.util;

import com.epam.jtc.sofiia.gorbatova.cards.generator.model.PaymentSystemType;

public final class CardValidator {

    public CardValidator() {
    }

    public boolean isValidCard(String paymentSystem) {
        boolean isValid = true;
        try{
            PaymentSystemType.valueOf(paymentSystem);
        }
        catch (IllegalArgumentException e){
            isValid = false;
        }

        return isValid;
    }
}
