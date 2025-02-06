package projeto_rpg;

import projeto_rpg.loja.Item;
import projeto_rpg.loja.Loja;
import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.monstro.DadosMonstros;
import projeto_rpg.personagem.monstro.Monstro;
import projeto_rpg.personagem.usuario.Usuario;

import java.util.Scanner;

public class Rpg
{
    private Personagem personagem;
    private Scanner scanner;
    private Loja loja;

    public Rpg()
    {
        scanner = new Scanner(System.in);
        this.loja = new Loja();
        this.criarPersonagem();
        this.Jogar();
    }

    public void exibirMenu()
    {
        System.out.println("[1] - BATALHA");
        System.out.println("[2] - LOJA");
        System.out.println("[3] - INVENTARIO");
        System.out.println("[4] - SAIR");
    }

    public int obterOpcao()
    {
        return Integer.parseInt(scanner.nextLine());
    }

    public void Jogar()
    {
        while (true)
        {
            if(!personagem.verificarVida())
            {
                System.out.println("GAMER OVER !!");
            }

            exibirMenu();
            switch (obterOpcao())
            {
                case 1:
                    batalha();
                    break;
                case 2:
                    menuLoja();
                    break;
                case 3:
                    menuInventario(personagem, scanner);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("escolha inválida.");
                    break;
            }
        }
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
        System.out.println("-=-=-=-=- BATALHA -=-=-=-=-=-");
        while(true)
        {
            personagem.atacar(monstro);

            monstro.atacar(personagem);

            System.out.println("-----------------------------------------------------------------");
            if(!monstro.verificarVida()) return;
            if(!personagem.verificarVida()) return;
        }
    }

    public void menuInventario(Personagem personagem, Scanner scanner)
    {
        if(personagem instanceof Usuario usuario) usuario.executarOpcao(personagem,scanner);
    }
    public void menuLoja()
    {
        loja.executarOpcao(personagem);
    }


    public void teste()
    {
        if(personagem instanceof  Usuario usuario)
        {
            for(Item item : usuario.getInventario())
            {
                System.out.println("item inventario" + item);
            }

            System.out.println("===========================================");

            System.out.println("MOEDA ATUAL: " + usuario.getMoeda());
        }
    }

    public Personagem getPersonagem() {
        return personagem;
    }
}
