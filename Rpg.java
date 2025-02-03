package projeto_rpg;

import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.monstro.DadosMonstros;
import projeto_rpg.personagem.monstro.Monstro;

import java.util.Scanner;

public class Rpg
{
    private Personagem personagem;
    private Scanner scanner;

    public Rpg()
    {
        scanner = new Scanner(System.in);
    }

    public void criarPersonagem()
    {
        TodasClasses classeEscolhida = TodasClasses.exibirEscolherClasse(scanner);

        if(classeEscolhida == null)
        {
            System.out.println("Enum do tipo TodasClasses e null");
            return;
        }

        personagem = classeEscolhida.exibirEscolherTipos(classeEscolhida,scanner);
    }

    public void batalha()
    {
        Personagem monstro = new Monstro(DadosMonstros.MINOTAURO);

        int i = 0;

        while(i < 4)
        {
            System.out.println("-=-=-=-=- BATALHA -=-=-=-=-=-");

            personagem.atacar(monstro);

            monstro.atacar(personagem);

            System.out.println("-----------------------------------------------------------------");
            if(!monstro.verificarVida()) return;
            if(!personagem.verificarVida()) return;
            i++;
        }
        System.out.println(this.personagem.getVida());
        System.out.println(this.personagem.getDano());
        Loja.executarOpcao(scanner, personagem);
        System.out.println(this.personagem.getVida());
        System.out.println(this.personagem.getDano());
    }
}
