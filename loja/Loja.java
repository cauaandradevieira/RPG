package projeto_rpg.loja;

import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.usuario.Usuario;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;


public class Loja
{
    private final ArrayList<DadosItens> loja;
    private Scanner scanner;
    public Loja()
    {
        this.loja = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        colocarItemNaLoja();
    }

    public void comprarItem(Personagem personagem)
    {
        if(personagem instanceof Usuario usuario)
        {
            System.out.println("Moeda Atual: " + usuario.getMoeda());

            exibirItensLoja();

            DadosItens itemLoja = obterItemLoja();

            ehNull(itemLoja);

            if(!verificacaoMoeda(usuario,itemLoja)) return;

            finalizarCompra(usuario,itemLoja);

            usuario.adicionarItemInventario(itemLoja);
        }
    }

    public DadosItens obterItemLoja()
    {
        int escolha = obterOpcao();

        return loja.get(escolha-1);
    }

    public void colocarItemNaLoja()
    {
        Collections.addAll(loja, DadosItens.values());
    }

    public void exibirItensLoja()
    {
        for (DadosItens dadosItens : loja)
        {
            System.out.println(dadosItens);
        }
    }

    public void ehNull(DadosItens itemLoja)
    {
        if(itemLoja == null)
        {
            System.out.println("Escolha invalida");
            System.exit(1);
        }
    }

    public boolean verificacaoMoeda(Usuario usuario, DadosItens itemLoja)
    {
        if(usuario.getMoeda() < itemLoja.getValor())
        {
            System.out.println("Saldo insuficiente... Moeda Atual: " + usuario.getMoeda() + " | " + "Valor item " + itemLoja.getValor());
            return false;
        }
        return true;
    }

    public void finalizarCompra(Usuario usuario, DadosItens itemLoja)
    {
        usuario.setMoeda( usuario.getMoeda() - itemLoja.getValor());
        System.out.println("Compra sucedida !!");
    }

    public static void menu()
    {
        System.out.println("[1] - COMPRAR");
        System.out.println("[2] - EXIBIR");
    }

    public void executarOpcao(Personagem personagem)
    {
        menu();
        switch (obterOpcao())
        {
            case 1:
                comprarItem(personagem);
                break;
            case 2:
                exibirItensLoja();
                break;
        }
    }

    public int obterOpcao()
    {
        return Integer.parseInt(scanner.nextLine());
    }
}
