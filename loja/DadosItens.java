package projeto_rpg.loja;

import projeto_rpg.personagem.Personagem;


public enum DadosItens
{
    POCAO_CURA(1,20,"de cura",10000, 20) {
        @Override
        public void efeitoPocao(Personagem personagem)
        {
            personagem.setVida( personagem.getVida() + getValorEfeitoPocao() );
        }

        @Override
        public void refazerEfeitoPocao(Personagem personagem)
        {
            personagem.setVida( personagem.getVida() - getValorEfeitoPocao() );
        }
    },
    POCAO_DANO(2,2,"de dano",10000,30) {
        @Override
        public void efeitoPocao(Personagem personagem)
        {
            personagem.setDano( personagem.getDano() + getValorEfeitoPocao() );
        }

        @Override
        public void refazerEfeitoPocao(Personagem personagem)
        {
            personagem.setDano( personagem.getDano() - getValorEfeitoPocao() );
        }
    },

    POCAO_CRITICO(3,1,"de critico",10000, 60) {
        @Override
        public void efeitoPocao(Personagem personagem)
        {
            personagem.setCritico( personagem.getCritico() + getValorEfeitoPocao() );
        }

        @Override
        public void refazerEfeitoPocao(Personagem personagem)
        {
            personagem.setCritico( personagem.getCritico() - getValorEfeitoPocao() );
        }
    };

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

    public abstract void efeitoPocao(Personagem personagem);
    public abstract void refazerEfeitoPocao(Personagem personagem);

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
