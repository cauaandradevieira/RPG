package projeto_rpg.personagem.monstro;

public enum DadosMonstros
{
    MINOTAURO(100,5);


    DadosMonstros(int vida, int dano)
    {
        this.vida = vida;
        this.dano = dano;
    }

    private final int vida ;
    private final int dano;


    public int getVida() {
        return vida;
    }

    public int getDano() {
        return dano;
    }
}
