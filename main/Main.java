package projeto_rpg.main;

import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.monstro.DadosMonstros;
import projeto_rpg.personagem.monstro.Monstro;
import projeto_rpg.personagem.usuario.guerreiro.Guerreiro;
import projeto_rpg.personagem.usuario.guerreiro.dados_guerreiros.DadosGuerreiros;

public class Main
{
    public static void main(String[] args)
    {
        Personagem guerreiro = new Guerreiro("pretochiq", DadosGuerreiros.ESPARTANO);
        System.out.println(DadosGuerreiros.ESPARTANO);
        DadosMonstros dadosMonstros = DadosMonstros.MINOTAURO;
        Personagem monstro = new Monstro(dadosMonstros);
        int i = 0;

        while(i < 4)
        {
            System.out.println("-=-=-=-=- BATALHA -=-=-=-=-=-");

            guerreiro.atacar(monstro);

            monstro.atacar(guerreiro);
            
            System.out.println("-----------------------------------------------------------------");
            if(!monstro.verificarVida()) return;
            if(!guerreiro.verificarVida()) return;
            i++;
        }
    }
}
