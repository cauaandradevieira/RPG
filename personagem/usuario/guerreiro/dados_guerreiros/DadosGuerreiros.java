package projeto_rpg.personagem.usuario.guerreiro.dados_guerreiros;

import projeto_rpg.Rpg;
import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.usuario.guerreiro.Guerreiro;
import projeto_rpg.personagem.usuario.guerreiro.tipos.Espartano;
import projeto_rpg.personagem.usuario.guerreiro.tipos.Viking;

public enum DadosGuerreiros
{
    ESPARTANO(1,150, "Lança do Recruta", 10, 1, 2, "Escudo de Treinamento", 4, "ESPARTANO"){
        @Override
        public Personagem criarObj() {
            return new Espartano(ESPARTANO);
        }

        @Override
        public String getArmaNivel2() {return "Lança de Dorun";}

        @Override
        public String getArmaNivel3() {return "Machado do Destino";}

        @Override
        public String getArmaNivel4() {return "Machado de Hades";}

        @Override
        public String getEscudoNivel2() {return "Escudo do Antigo Rei";}

        @Override
        public String getEscudoNivel3() {return "Escudo de Hércules";}

        @Override
        public String getEscudoNivel4() {return "Escudo de Ares";}
    },

    VIKING(2,150, "Machado de madeira", 10, 1, 2, "Escudo de Treinamento", 2, "VIKING"){
        @Override
        public Personagem criarObj() {
            return new Viking(VIKING);
        }

        @Override
        public String getArmaNivel2() {
            return "";
        }

        @Override
        public String getArmaNivel3() {
            return "";
        }

        @Override
        public String getArmaNivel4() {
            return "";
        }

        @Override
        public String getEscudoNivel2() {
            return "";
        }

        @Override
        public String getEscudoNivel3() {
            return "";
        }

        @Override
        public String getEscudoNivel4() {
            return "";
        }
    };


    DadosGuerreiros( int numeroClasse,int vida, String arma, int dano, int miss, int critico, String escudo, int chanceEscudo, String nomeClasse) {
        this.numeroClasse = numeroClasse;
        this.vida = vida;
        this.arma = arma;
        this.dano = dano;
        this.miss = miss;
        this.critico = critico;
        this.escudo = escudo;
        this.chanceEscudo = chanceEscudo;
        this.nomeClasse = nomeClasse;
    }
    private final int numeroClasse;
    private final int vida;
    private final String arma;
    private final int dano;
    private final int miss;
    private final int critico;
    private final String escudo;
    private final int chanceEscudo;
    private final String nomeClasse;

    public abstract Personagem criarObj();
    public abstract String getArmaNivel2();
    public abstract String getArmaNivel3();
    public abstract String getArmaNivel4();

    public abstract String getEscudoNivel2();
    public abstract String getEscudoNivel3();
    public abstract String getEscudoNivel4();

    public int getNumeroClasse() {
        return numeroClasse;
    }

    public int getVida() {
        return vida;
    }

    public String getArma() {
        return arma;
    }

    public int getDano() {
        return dano;
    }

    public int getMiss() {
        return miss;
    }

    public int getCritico() {
        return critico;
    }

    public String getEscudo() {
        return escudo;
    }

    public int getChanceEscudo() {
        return chanceEscudo;
    }

    @Override
    public String toString() {
        return  "=-=-=-=INFO " + nomeClasse+ "=-=-=-=" + "\n"
                +"vida: " + vida + "\n"
                +"arma: " + arma + "\n"
                + "dano: " + dano + "\n"
                + "miss: " + miss + "\n"
                + "critico: " + critico + "\n"
                + "escudo: " + escudo + "\n"
                + "chanceEscudo: " + chanceEscudo;
    }
}
