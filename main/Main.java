package projeto_rpg.main;

import projeto_rpg.Rpg;
import projeto_rpg.loja.DadosItens;
import projeto_rpg.loja.Item;
import projeto_rpg.loja.Loja;
import projeto_rpg.personagem.Personagem;


public class Main
{
    public static void main(String[] args)
    {
        Rpg rpg = new Rpg();
        rpg.criarPersonagem();

        int i = 0;

        Rpg.teste(rpg.getPersonagem());

        while (i < 3)
        {
            rpg.MenuLoja();
            i++;
        }

        Rpg.teste(rpg.getPersonagem());
    }
}
