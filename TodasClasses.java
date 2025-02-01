package projeto_rpg;

import projeto_rpg.personagem.usuario.arqueiro.DadosArqueiros;
import projeto_rpg.personagem.usuario.guerreiro.dados_guerreiros.DadosGuerreiros;

import java.util.Scanner;

public enum TodasClasses
{
    GUERREIRO(1) {
        @Override
        public void mostrarTipos(int classeEscolhida) {
            if(classeEscolhida != getNumeroClasse())
            {
                return;
            }
            for(DadosGuerreiros dadosGuerreiros : DadosGuerreiros.values())
            {
                System.out.println("["+ dadosGuerreiros.getNumeroClasse() +"]"+ dadosGuerreiros.name());
            }
        }
    },

    ARQUEIRO(2) {
        @Override
        public void mostrarTipos(int classeEscolhida) {
            if(classeEscolhida != getNumeroClasse())
            {
                return;
            }
            for(DadosArqueiros dadosArqueiros : DadosArqueiros.values())
            {
                System.out.println("["+ dadosArqueiros.getNumeroClasse() +"]"+ dadosArqueiros.name());
            }

        }
    };

    TodasClasses(int numero) {
        this.numeroClasse = numero;
    }

    private final int numeroClasse;

    public int getNumeroClasse() {
        return numeroClasse;
    }

    public static int EscolherClasse(Scanner scanner)
    {
        System.out.println("Escolha sua classe:");

        for(TodasClasses classes : TodasClasses.values())
        {
            System.out.println("["+ classes.getNumeroClasse()+"]"+classes);
        }
        return Integer.parseInt(scanner.nextLine());
    }

    public abstract void mostrarTipos(int classeEscolhida);

    public static void escolherTipo(int numeroTipo)
    {
        for(TodasClasses todasClasses : TodasClasses.values())
        {
            todasClasses.mostrarTipos(numeroTipo);
        }
    }

}
