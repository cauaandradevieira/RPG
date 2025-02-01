package projeto_rpg.main;

import projeto_rpg.Rpg;
import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.monstro.DadosMonstros;
import projeto_rpg.personagem.monstro.Monstro;
import projeto_rpg.personagem.usuario.guerreiro.dados_guerreiros.DadosGuerreiros;
import projeto_rpg.personagem.usuario.guerreiro.tipos.Espartano;

public class Main
{
    public static void main(String[] args)
    {
        Rpg rpg = new Rpg();
        rpg.escolherClasse();
    }
}
