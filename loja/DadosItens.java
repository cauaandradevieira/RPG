package projeto_rpg.loja;

public enum DadosItens
{
    POCAO_CURA(1,20,"de cura",10000, 20) ,
    FORJAR_ARMA(2,2,"de dano",10000,30) ;

    DadosItens(int num, int valorEfeitoPocao,String textoEfeitoItem , int duracaoEfeito, double valor) {
        this.num = num;
        this.valorEfeitoPocao = valorEfeitoPocao;
        this.textoEfeitoItem = textoEfeitoItem;
        this.duracaoEfeito = duracaoEfeito;
        this.valor = valor;
    }

    private final int num;
    private final String textoEfeitoItem;
    private final int valorEfeitoPocao;
    private final double valor;
    private final long duracaoEfeito;

    public String calculoMinSeg()
    {
        String texto = "";
        long minutos = duracaoEfeito / 60000;
        long milissegundosRestantes;
        long segundos;
        if(minutos >= 1)
        {
            texto += minutos + " minuto(s) ";
            milissegundosRestantes = duracaoEfeito - (minutos * 60000);
            segundos = milissegundosRestantes / 1000;
            texto += segundos + "segundo(s)";
        }
        else
        {
            segundos = duracaoEfeito / 1000;
            texto += segundos + "segundo(s)";
        }

        return texto;
    }

    public void teste()
    {
        System.out.println("[" + this.getNum() + "]" + this.name());
    }
    @Override
    public String toString() {
        return "[" + this.getNum() + "]"+ this.name() + " - " + "R$ " + this.valor + " | Efeito +" + this.valorEfeitoPocao + " " +textoEfeitoItem + " | Duração " + this.calculoMinSeg();
    }

    public int getValorEfeitoPocao() {
        return valorEfeitoPocao;
    }

    public int getNum() {
        return num;
    }

    public double getValor() {
        return valor;
    }

    public long getDuracaoEfeito() {
        return duracaoEfeito;
    }
}
