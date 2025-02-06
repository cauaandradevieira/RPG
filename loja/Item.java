package projeto_rpg.loja;


public class Item
{
    private String nome;
    private int quantidade;
    private DadosItens dadosItens;
    private boolean ativada;

    public Item(String nome, DadosItens dadosItens)
    {
        this.nome = nome;
        this.quantidade = 1;
        this.dadosItens = dadosItens;
    }

    public String textoSePocaoEstarAtivada()
    {
        if(this.ativada) return "[ EM USO ]";
        return "";
    }
    @Override
    public String toString() {
        return this.quantidade + "x " + this.nome + textoSePocaoEstarAtivada();
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

    public DadosItens getDadosItens() {
        return dadosItens;
    }

    public void setDadosItens(DadosItens dadosItens) {
        this.dadosItens = dadosItens;
    }

    public boolean getAtivada() {
        return ativada;
    }

    public void setAtivada(boolean ativada) {
        this.ativada = ativada;
    }
}

