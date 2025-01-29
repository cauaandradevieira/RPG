package projeto_rpg.personagem.monstro;

import projeto_rpg.personagem.Personagem;

public class Monstro extends Personagem
{
    private DadosMonstros dadosMonstros;

    public Monstro(DadosMonstros dadosMonstros)
    {
        this.dano = dadosMonstros.getDano();
        this.vida = dadosMonstros.getVida();
        this.critico = 2;
        this.miss = 1;
        this.nome = dadosMonstros.name();
        this.dadosMonstros = dadosMonstros;
    }

    @Override
    public void atacar(Personagem personagem) {
        super.atacar(personagem);
    }

    @Override
    public boolean verificarVida() {
        return super.verificarVida();
    }

    public DadosMonstros getDadosMonstros() {
        return dadosMonstros;
    }
}
