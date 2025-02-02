package projeto_rpg.personagem.usuario.guerreiro.tipos;

import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.usuario.guerreiro.Guerreiro;
import projeto_rpg.personagem.usuario.guerreiro.dados_guerreiros.DadosGuerreiros;

public class Viking extends Guerreiro
{
    public Viking(DadosGuerreiros dadosGuerreiros) {
        super(dadosGuerreiros);
    }

    @Override
    public void atacar(Personagem inimigo) {
        super.atacar(inimigo);
    }

}
