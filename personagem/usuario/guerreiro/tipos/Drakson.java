package projeto_rpg.personagem.usuario.guerreiro.tipos;

import projeto_rpg.interfaces.tipos_passivas.PassivaRodadas;
import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.usuario.guerreiro.Guerreiro;
import projeto_rpg.personagem.usuario.guerreiro.dados_guerreiros.DadosGuerreiros;

public class Espartano extends Guerreiro implements PassivaRodadas
{
    public Espartano(DadosGuerreiros dadosGuerreiros)
    {
        super(dadosGuerreiros);
    }

    @Override
    public void atacar(Personagem inimigo)
    {
        passivaRodadas(inimigo);
        super.atacar(inimigo);
    }

    @Override
    public void passivaRodadas(Personagem personagem) {
        furia();
    }

    @Override
    public void furia() {
        if(passivaAtiva.equals(passivaFuria) || passivaAtiva.isEmpty());
        {
            if(rodada >= 1)
            {
                this.rodada = 0;
                System.out.println("ACABOU O EFEITO DA PASSIVA " + this.passivaAtiva);
                System.out.println("critico de " + this.critico + " -> " + (this.critico-2));
                this.passivaAtiva = "";
                this.critico -= 2;
                return;
            }

            int numeroAleatorio = random.nextInt(1,3);

            if(numeroAleatorio == 2)
            {
                this.passivaAtiva = passivaFuria;
                this.critico += 2;
                this.rodada += 1;
                System.out.println("ATIVOU EFEITO PASSIVA " + this.passivaAtiva);
                System.out.println("critico de " + (this.critico-2) + " -> " + this.critico);
            }
        }
    }
}
