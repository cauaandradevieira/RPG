package projeto_rpg.loja;


import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.usuario.Usuario;

public class Item
{
    private String nome;
    private int quantidade;
    private boolean ativada;
    private int contadorUsoPocao;
    private DadosItens dadosItens;

    public Item(String nome, DadosItens dadosItens)
    {
        this.nome = nome;
        this.quantidade = 1;
        this.dadosItens = dadosItens;
    }

    public static void adicionarItemInventario(Usuario usuario, DadosItens itemLoja)
    {
        if(verificarItemExistente(usuario,itemLoja))
        {
            return;
        }
        usuario.getInventario().add(new Item(itemLoja.name(), itemLoja));
    }

    public static boolean verificarItemExistente(Usuario usuario, DadosItens itemLoja)
    {

        for(Item item : usuario.getInventario())
        {
            if(item.nome.equals(itemLoja.name()))
            {
                item.setQuantidade( item.getQuantidade() + 1 );
                System.out.println("item existente acrescentamos +1" );
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.quantidade + "x " + this.nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean getAtivada() {
        return ativada;
    }

    public void setAtivada(boolean ativada) {
        this.ativada = ativada;
    }

    public int getContadorUsoPocao() {
        return contadorUsoPocao;
    }

    public void setContadorUsoPocao(int contadorUsoPocao) {
        this.contadorUsoPocao = contadorUsoPocao;
    }


    public DadosItens getDadosItens() {
        return dadosItens;
    }

    public void setDadosItens(DadosItens dadosItens) {
        this.dadosItens = dadosItens;
    }

}

