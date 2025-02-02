package projeto_rpg;

import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.usuario.arqueiro.DadosArqueiros;
import projeto_rpg.personagem.usuario.guerreiro.dados_guerreiros.DadosGuerreiros;

import java.util.Scanner;

public enum TodasClasses
{
    GUERREIRO(1) {
        @Override
        public Personagem exibirEscolherTipos(TodasClasses classeEscolhida, Scanner scanner) {

            for(DadosGuerreiros dadosGuerreiros : DadosGuerreiros.values())
            {
                System.out.println("["+ dadosGuerreiros.getNumeroClasse() +"]"+ dadosGuerreiros.name());
            }

            int escolher = Integer.parseInt(scanner.nextLine());

            DadosGuerreiros dadosGuerreiros = DadosGuerreiros.values()[escolher-1];

            return dadosGuerreiros.criarObj();
        }
    },

    ARQUEIRO(2) {
        @Override
        public Personagem exibirEscolherTipos(TodasClasses classeEscolhida, Scanner scanner) {

            for(DadosGuerreiros dadosGuerreiros : DadosGuerreiros.values())
            {
                System.out.println("["+ dadosGuerreiros.getNumeroClasse() +"]"+ dadosGuerreiros.name());
            }

            int escolher = Integer.parseInt(scanner.nextLine());

            DadosGuerreiros dadosGuerreiros = DadosGuerreiros.values()[escolher-1];

            return dadosGuerreiros.criarObj();

        }
    };

    TodasClasses(int numero) {
        this.numeroClasse = numero;
    }

    private final int numeroClasse;

    public int getNumeroClasse() {
        return numeroClasse;
    }

    public abstract Personagem exibirEscolherTipos(TodasClasses todasClasses, Scanner scanner);

    public static TodasClasses exibirEscolherClasse(Scanner scanner)
    {
        System.out.println("Escolha sua classe:");

        for(TodasClasses classes : TodasClasses.values())
        {
            System.out.println("["+ classes.getNumeroClasse()+"]"+classes);
        }

        int escolher = Integer.parseInt(scanner.nextLine());

        if(escolher > TodasClasses.values().length)
        {
            return null;
        }

        return TodasClasses.values()[escolher-1];
    }
}
