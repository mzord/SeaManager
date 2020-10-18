package com.example.mzord.models;

public enum Function {
    MOC {
      @Override
      public String toString() {
        return "Moço de convés";
      }
    },
    MNC {
        @Override
        public String toString() {
            return "Marinheiro de Convés";
        }
    },
    CTR {
        @Override
        public String toString() {
            return "Contra Mestre";
        }
    },
    MCB {
        @Override
        public String toString() {
            return "Mestre de Cabotagem";
        }
    },
    OQN {
        @Override
        public String toString() {
            return "Oficial de Quarto de Náutica";
        }
    },
    PRIMEIRO_ON {
        @Override
        public String toString() {
            return "1˚ Oficial de Náutica";
        }
    },
    SEGUNDO_ON {
        @Override
        public String toString() {
            return "2˚ Oficial de Náutica";
        }
    },
    IMT {
        @Override
        public String toString() {
            return "Imediato";
        }
    },
    CMT {
        @Override
        public String toString() {
            return "Comandante";
        }
    },
    MOM {
        @Override
        public String toString() {
            return "Moço de Máquinas";
        }
    },
    MNM {
        @Override
        public String toString() {
            return "Marinheiro de Máquinas";
        }
    },
    CDM {
        @Override
        public String toString() {
            return "Condutor de Máquinas";
        }
    },
    SFM {
        @Override
        public String toString() {
            return "Subchefe de Máquinas";
        }
    },
    CZA {
        @Override
        public String toString() {
            return "Cozinheiro";
        }
    },
    TAA {
        @Override
        public String toString() {
            return "Taifeiro";
        }
    };

    public abstract String toString();
}
