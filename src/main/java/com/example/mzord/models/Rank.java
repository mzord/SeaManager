package com.example.mzord.models;

public enum Rank {
    MOM("Moço de Máquinas"),
    MNM("Marinheiro de Máquinas"),
    CDM("Condutor de Máquinas"),
    SEGUNDO_OM("Segundo Oficial de Máquinas"),
    PRIMEIRO_OM("Primeiro Oficial de Máquinas"),
    OSM("Oficial Superior de Máquinas"),
    MOC("Moço de Convés"),
    MNC("Marinheiro de Convés"),
    MCB("Mestre de Cabotagem"),
    SEGUNDO_ON("Segundo Oficial de Náutica"),
    PRIMEIRO_ON("Primeiro Oficial de Náutica"),
    CCB("Capitão de Cabotagem"),
    CLC("Capitão de Longo Curso"),
    CZA("Cozinheiro"),
    TAA("Taifeiro");

    private final String displayValue;

    Rank(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
