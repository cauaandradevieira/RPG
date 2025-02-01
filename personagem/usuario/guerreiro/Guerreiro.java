package projeto_rpg.personagem.usuario.guerreiro;

import projeto_rpg.interfaces.tipos_passivas.PassivaRodadaCongelada;
import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.usuario.Usuario;
import projeto_rpg.personagem.usuario.guerreiro.dados_guerreiros.DadosGuerreiros;

public class Guerreiro extends Usuario implements PassivaRodadaCongelada
{
    protected String escudo;
    protected int chanceDefender;
    protected int danoEscudoProtege;
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
        this.chanceDefender = 1;
        this.escudo = dadosGuerreiros.getEscudo();
        this.danoEscudoProtege = 2;
    }

    public void defender(Personagem inimigo)
    {
        int numeroAleatorio = random.nextInt(1,6);

        if(numeroAleatorio <= chanceDefender)
        {
            inimigo.atacar(this);

            verificarSeHouveEsquiva(inimigo);

            inimigo.setPermissaoAtacar(false);
        }
    }

    public void verificarSeHouveEsquiva(Personagem inimigo)
    {
        if(this.houveEsquiva || !inimigo.getPermissaoAtacar())
        {
            return;
        }

        System.out.print(this.nome + " DEFENDEU o ataque com o " + this.escudo);

        this.setVida( this.getVida() + this.danoEscudoProtege );

        int danoCriticoRecebido = inimigo.getDano() * 2;

        if(!inimigo.getHouveCritico())
        {
            System.out.println(" inves de receber " + inimigo.getDano() + " de dano " + "recebeu " + (inimigo.getDano() - danoEscudoProtege) + " de dano");
            return;
        }

        System.out.println(" inves de receber " + ( danoCriticoRecebido ) + " de dano " + "recebeu " + ( danoCriticoRecebido - danoEscudoProtege) + " de dano");
    }

    @Override
    public void atacar(Personagem inimigo) {
        super.atacar(inimigo);
        passivaRodadaCongelada(inimigo);
    }

    @Override
    public void passivaRodadaCongelada(Personagem inimigo)
    {
        inimigo.setPermissaoAtacar(true);
        defender(inimigo);
    }
}
