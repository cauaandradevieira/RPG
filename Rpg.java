package projeto_rpg;

import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.monstro.DadosMonstros;
import projeto_rpg.personagem.monstro.Monstro;
import projeto_rpg.personagem.usuario.guerreiro.Guerreiro;
import projeto_rpg.personagem.usuario.guerreiro.dados_guerreiros.DadosGuerreiros;
import projeto_rpg.personagem.usuario.guerreiro.tipos.Espartano;

import java.util.Scanner;

public class Rpg
{
    String nomeJogador;
    private Personagem personagem;
    private Personagem monstro;
    private Scanner scanner;

    public Rpg()
    {
        scanner = new Scanner(System.in);
    }

    public void escolherNome(Personagem personagem)
    {
        System.out.println("Digite seu nick: ");
        nomeJogador = scanner.nextLine();
    }

    public void escolherClasse()
    {

        int escolhaClasse = TodasClasses.EscolherClasse(scanner);

        TodasClasses.escolherTipo(escolhaClasse);

        System.out.println("-----------------------------------------------------");
        switch (escolhaClasse)
        {
            case 1:
                personagem = new Espartano("nick" , DadosGuerreiros.ESPARTANO);
                break;
            case 2:
                personagem = new Guerreiro("nick" , DadosGuerreiros.VIKING);
                break;
        }

        System.out.println("Voce escolheu:" + personagem.getNome());
    }

    public void batalha()
    {
        Personagem guerreiro = new Espartano("pretochiq", DadosGuerreiros.ESPARTANO);
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
