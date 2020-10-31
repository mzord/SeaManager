package com.example.mzord.models;

public enum Function {
    MOC(5),
    MNC(5),
    CTR(13),
    MCB(4),
    OQN(3),
    PRIMEIRO_ON(3),
    SEGUNDO_ON(4),
    IMT(2),
    CMT(1),
    CFM(6),
    MOM(10),
    MNM(9),
    CDM(8),
    SFM(7),
    CZA(11),
    TAA(12);


    private final int ordinalValue;

    private Function(int ordinalValue) {
        this.ordinalValue = ordinalValue;
    }

    public int getOrdinalValue() {
        return this.ordinalValue;
    }
}
