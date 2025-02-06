package projeto_rpg.personagem.usuario;

import projeto_rpg.loja.DadosItens;
import projeto_rpg.interfaces.VariaveisConst;
import projeto_rpg.loja.Item;
import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.monstro.DadosMonstros;
import projeto_rpg.personagem.monstro.Monstro;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Usuario extends Personagem implements VariaveisConst
{
    protected float barralevel;
    protected int nivel;
    protected ArrayList <Item> inventario;
    protected double moeda;

    public Usuario()
    {
        super();
        this.barralevel = BARRA_LEVEL_INICIAL;
        this.nivel = NIVEL_INICIAL;
        this.permissaoAtacar = PERMISSAO_ATACAR_INICIAL;
        this.passivaAtiva = "";
        this.inventario = new ArrayList<>();
        this.moeda = 100;
    }

    @Override
    public void atacar(Personagem personagem)
    {
        super.atacar(personagem);
        if(!personagem.verificarVida())
        {
            levelUp(personagem);
        }
    }

    @Override
    public boolean verificarVida()
    {
        return super.verificarVida();
    }

    public void levelUp(Personagem monstro)
    {
        DadosMonstros dadosMonstros = null;

        if(monstro == null)
        {
            System.out.println("nenhum monstro criado...");
            return;
        }

        if(monstro instanceof Monstro monstro1)
        {
            dadosMonstros = monstro1.getDadosMonstros();
        }

        if(dadosMonstros == null)
        {
            System.out.println("dados dos monstros nao criado");
        }


        float resultado = (float) (dadosMonstros.getVida() + dadosMonstros.getDano()) / 2; // TROCA PELO ENUM
        this.barralevel += resultado;

        if(this.barralevel >= BARRA_LEVEL_MAXIMO)
        {
            this.nivel += 1;
            System.out.println("=-=-=-=-=-=-=-=-=- LEVEL UP -=-=-=-=-=-=-=-=-=-");
            System.out.println("Aumento de dano de: " + this.dano + " -> " + (AUMENTO_DANO+this.dano));
            System.out.println("Aumento de vida de: " + this.vida + " -> " + (AUMENTO_VIDA+this.vida));
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");


            this.dano += AUMENTO_DANO;
            this.vida += AUMENTO_VIDA;
            this.barralevel = 0;
        }
    }

    public void usarPocao(Personagem personagem, Scanner scanner)
    {
        this.exibirItens();
        Item item = obterItem(scanner);
        if(item == null) return;
        this.executarEfeitoPocao(personagem, item);
        this.verificacaoParaRemoverItem(item);
    }

    public void adicionarItemInventario(DadosItens itemLoja)
    {
        if(verificarItemExistente(itemLoja))
        {
            return;
        }
        this.inventario.add(new Item(itemLoja.name(), itemLoja));
    }

    public boolean verificarItemExistente(DadosItens itemLoja)
    {
        for(Item item : this.inventario)
        {
            if(item.getNome().equals(itemLoja.name()))
            {
                item.setQuantidade( item.getQuantidade() + 1 );
                System.out.println("item existente acrescentamos +1" );
                return true;
            }
        }
        return false;
    }


    public void verificacaoParaRemoverItem(Item item)
    {
        if(item.getQuantidade() == 0)
        {
            this.inventario.remove(item);
        }
    }

    public void exibirItens()
    {
        int cont = 0;
        for (Item itens : this.inventario)
        {
            cont++;
            System.out.println("[ " + cont + " ]" + " " +itens);
        }
    }

    public Item obterItem(Scanner scanner)
    {
        int escolha = obterOpcao(scanner);

        return this.inventario.get(escolha-1);
    }

    public void executarEfeitoPocao(Personagem personagem, Item item)
    {
        if (item.getAtivada())
        {
            System.out.println(item.getNome() + " estar em uso.");
            return;
        }

        Timer timer = new Timer();
        DadosItens dadosItens = item.getDadosItens();
        TimerTask timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                System.out.println("ACABOU A POCAO CRIA");
                dadosItens.refazerEfeitoPocao(personagem);
                item.setAtivada(false);
            }
        };
        timer.schedule(timerTask, dadosItens.getDuracaoEfeito());
        dadosItens.efeitoPocao(personagem);
        item.setQuantidade( item.getQuantidade() - 1);
        item.setAtivada(true);
    }

    public int obterOpcao(Scanner scanner)
    {
        return Integer.parseInt(scanner.nextLine());
    }

    public void menu()
    {
        System.out.println("[ 1 ] - USAR");
        System.out.println("[ 2 ] - EXIBIR");
    }

    public void executarOpcao(Personagem personagem, Scanner scanner)
    {
        menu();
        switch (obterOpcao(scanner))
        {
            case 1:
                usarPocao(personagem, scanner);
                break;
            case 2:
                exibirItens();
                break;
        }
    }
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public float getBarralevel() {
        return barralevel;
    }

    public void setBarralevel(float barralevel) {
        this.barralevel = barralevel;
    }

    public ArrayList<Item> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Item> inventario) {
        this.inventario = inventario;
    }

    public double getMoeda() {
        return moeda;
    }

    public void setMoeda(double moeda) {
        this.moeda = moeda;
    }
}
