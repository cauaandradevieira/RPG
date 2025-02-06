package projeto_rpg.personagem.usuario.guerreiro.tipos;

import projeto_rpg.interfaces.tipos_passivas.PassivaRodadas;
import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.usuario.guerreiro.Guerreiro;
import projeto_rpg.personagem.usuario.guerreiro.dados_guerreiros.DadosGuerreiros;

public class Viking extends Guerreiro implements PassivaRodadas
{
    public Viking(DadosGuerreiros dadosGuerreiros)
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
        gritoFenhir();
    }

    @Override
    public void gritoFenhir() {
        if(passivaAtiva.equals(passivaGritoFenhir) || passivaAtiva.isEmpty())
        {
            if(rodada == 1)
            {
                this.rodada += 1;
                return;
            }

            if(rodada >= 2)
            {
                this.rodada = 0;
                System.out.println("ACABOU O EFEITO DA PASSIVA " + this.passivaAtiva);
                System.out.println("dano de " + this.dano + " -> " + (this.dano-10));
                this.passivaAtiva = "";
                this.dano -= 10;
                return;
            }


            int numeroAleatorio = random.nextInt(1,3);

            if(numeroAleatorio == 2)
            {
                this.passivaAtiva = passivaGritoFenhir;
                this.rodada += 1;
                this.dano += 10;
                System.out.println("ATIVOU A PASSIVA DE " + this.passivaAtiva);
                System.out.println("dano de " + (this.dano-10) + " -> " + this.dano);
            }
        }
    }
}
