package com.epam.jtc.sofiia.gorbatova.cards.generator.model;

import com.epam.jtc.sofiia.gorbatova.cards.generator.model.util.Range;

import java.util.List;

public enum PaymentSystemType {
    MASTERCARD(List.of(new Range(16,16)),
            List.of(new Range(2221,2720),
                    new Range(51,55))),
    MAESTRO(List.of(new Range(12, 12),
            new Range(19, 19)),
            List.of(new Range(6759, 6759),
                    new Range(676_770, 676_770),
                    new Range(676_774, 676_774),
                    new Range(5018, 5018),
                    new Range(5020, 5020),
                    new Range(5038, 5038),
                    new Range(5893, 5893),
                    new Range(6304, 6304),
                    new Range(6759, 6759),
                    new Range(6761, 6761),
                    new Range(6762, 6762),
                    new Range(6763, 6763))),
    MASTERCARD_ELECTRONIC(MASTERCARD),
    VISA_ELECTRON(List.of(new Range(16, 16)),
            List.of(new Range(4026, 4026),
                    new Range(417_500, 417_500),
                    new Range(4508, 4508),
                    new Range(4844, 4844),
                    new Range(4913, 4913),
                    new Range(4917, 4917))),
    VISA_CLASSIC(List.of(new Range(13, 13),
            new Range(16, 16)),
            List.of(new Range(4, 4))),
    VISA_GOLD(VISA_CLASSIC),
    MIR_CLASSIC(List.of(new Range(16, 19)), List.of(new Range(2200, 2204))),
    MIR_PREMIUM(MIR_CLASSIC),
    MIR_DEBIT(MIR_CLASSIC);

    private List<Range> digitsNumber;
    private List<Range> issuerIdentificationNumber;

    PaymentSystemType(PaymentSystemType paymentSystemType) {
        this.digitsNumber = paymentSystemType.digitsNumber;
        this.issuerIdentificationNumber = paymentSystemType
                .issuerIdentificationNumber;
    }

    PaymentSystemType(List<Range> digitsNumber,
                      List<Range> issuerIdentificationNumber) {
        this.digitsNumber = digitsNumber;
        this.issuerIdentificationNumber = issuerIdentificationNumber;
    }

    public List<Range> getDigitsNumber() {
        return digitsNumber;
    }

    public List<Range> getIssuerIdentificationNumber() {
        return issuerIdentificationNumber;
    }
}
