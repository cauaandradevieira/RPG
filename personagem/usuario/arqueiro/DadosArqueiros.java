package projeto_rpg.personagem.usuario.arqueiro;

public enum DadosArqueiros
{
    CENTAURO(1,100, "Arco de madeira","arco de fecha","Arqueiro" ,25, 2, 1, 0f, 1) {

        @Override
        public String getArma2() {return "Arco do Caçador Venerado";}
        @Override
        public String getArma3() {return "Arco das Chamas Eternas";}
        @Override
        public String getArma4() {return "Arco Dourado de Apolo";}
    };

    DadosArqueiros(int numeroClasse,int vida, String arma, String escudo , String nome, int dano, int miss, int critico, float barraLevel, int nivel) {
        this.numeroClasse = numeroClasse;
        this.vida = vida;
        this.arma = arma;
        this.escudo = escudo;
        this.nome = nome;
        this.dano = dano;
        this.miss = miss;
        this.critico = critico;
        this.barraLevel = barraLevel;
        this.nivel = nivel;
    }

    private final int numeroClasse;
    private final int vida; //
    private final String arma;
    private final String escudo;// outro bagulho
    private final String nome; //
    private final int dano; //
    private final int miss; //
    private final int critico; //
    private final float barraLevel;
    private final int nivel;

    public abstract String getArma2();
    public abstract String getArma3();
    public abstract String getArma4();

    public int getVida() {
        return vida;
    }

    public String getArma() {
        return arma;
    }

    public String getNome() {
        return nome;
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

    public float getBarraLevel() {
        return barraLevel;
    }

    public String getEscudo() {
        return escudo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getNumeroClasse() {
        return numeroClasse;
    }
}
