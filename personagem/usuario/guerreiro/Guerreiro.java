package projeto_rpg.personagem.usuario.guerreiro;

import projeto_rpg.personagem.usuario.Usuario;
import projeto_rpg.personagem.usuario.guerreiro.dados_guerreiros.DadosGuerreiros;

public class Guerreiro extends Usuario
{
    protected String escudo;
    protected int chanceDefender;
    protected DadosGuerreiros dadosGuerreiros;

    public Guerreiro(String nick, DadosGuerreiros dadosGuerreiros)
    {
        super(nick);
        this.vida = dadosGuerreiros.getVida();
        this.nome = dadosGuerreiros.name() + "(GUERREIRO)";
        this.arma = dadosGuerreiros.getArma();
        this.dano = dadosGuerreiros.getDano();;
        this.miss = dadosGuerreiros.getMiss();
        this.critico = dadosGuerreiros.getCritico();
        this.escudo = dadosGuerreiros.getEscudo();
        this.dadosGuerreiros = dadosGuerreiros;
        this.chanceDefender = dadosGuerreiros.getChanceEscudo();
        this.escudo = dadosGuerreiros.getEscudo();
    }

    public void defender()
    {

    }
}
