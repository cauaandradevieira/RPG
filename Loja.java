package projeto_rpg;

import projeto_rpg.personagem.Personagem;

import java.util.Scanner;

public enum Loja
{
    POCAO_CURA(1,20) {
        @Override
        public void efeitoPocao(Personagem personagem)
        {
            personagem.setVida( personagem.getVida() + this.getValorEfeitoPocao());
        }
    },
    POCAO_DANO(2,5) {
        @Override
        public void efeitoPocao(Personagem personagem)
        {
            personagem.setDano( personagem.getDano() + this.getValorEfeitoPocao());
        }
    };

    Loja(int num, int valorEfeitoPocao) {
        this.num = num;
        this.valorEfeitoPocao = valorEfeitoPocao;
    }

    private final int num;
    private final int valorEfeitoPocao;

    public abstract void efeitoPocao(Personagem personagem);

    public static void exibirPocoes()
    {
        for(Loja item : Loja.values())
        {
            System.out.println("[ " + item.num + " ] " + item);
        }
    }

    public static void executarOpcao(Scanner scanner, Personagem personagem)
    {
        exibirPocoes();

        int pocaoEscolhida = Integer.parseInt(scanner.nextLine());

        for(Loja item : Loja.values())
        {
            if(pocaoEscolhida == item.getNum())
            {
                item.efeitoPocao(personagem);
            }
        }
    }

    public int getValorEfeitoPocao() {
        return valorEfeitoPocao;
    }

    public int getNum() {
        return num;
    }
}
