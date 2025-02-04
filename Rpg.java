package projeto_rpg;

import projeto_rpg.loja.DadosItens;
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
    }

    public void MenuLoja()
    {
        loja.executarOpcao(personagem);
    }

    public static void teste(Personagem personagem)
    {
        if(personagem instanceof  Usuario usuario)
        {
            for(Item item : usuario.getInventario())
            {
                System.out.println("item inventario" + item);
            }

            System.out.println("===========================================");

            for(Item item : usuario.getInventario())
            {
                System.out.println(item + " " + item.getDadosItens().name());
            }

            System.out.println(usuario.getMoeda());
        }
    }

    public Personagem getPersonagem() {
        return personagem;
    }
}
