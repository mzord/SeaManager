package com.example.mzord.models;

public enum Function {
    MOC("Moço de Convés"),
    MNC("Marinheiro de Convés"),
    CTR("Contra Mestre"),
    MCB("Mestre de Cabotagem"),
    OQN("Oficial de Quarto de Náutica"),
    PRIMEIRO_ON("Primeiro Oficial de Náutica"),
    SEGUNDO_ON("Segundo Oficial de Náutica"),
    IMT("Imediato"),
    CMT("Comandante"),
    MOM("Moço de Máquinas"),
    MNM("Marinheiro de Máquinas"),
    CDM("Condutor de Máquinas"),
    SFM("Subchefe de máquinas"),
    CZA("Cozinheiro"),
    TAA("Taifeiro");


    private final String displayValue;

    private Function(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }
}
