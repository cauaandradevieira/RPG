package projeto_rpg.main;

import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.monstro.DadosMonstros;
import projeto_rpg.personagem.monstro.Monstro;
import projeto_rpg.personagem.usuario.Usuario;
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

        while(true)
        {
            Usuario usuario = (Usuario) guerreiro;

            guerreiro.atacar(monstro);
            System.out.println("vida do monstro" + monstro.getVida());

            System.out.println(usuario.getDano());
            System.out.println(usuario.getVida());
            if(!monstro.verificarVida())
            {
                usuario.levelUp(monstro);
                return;
            }

            monstro.atacar(guerreiro);
            System.out.println("vida guerreiro" + guerreiro.getVida());
            if(!guerreiro.verificarVida()) return;
        }
    }
}
