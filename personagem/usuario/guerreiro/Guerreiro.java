package projeto_rpg.personagem.usuario.guerreiro;

import projeto_rpg.personagem.Personagem;
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
        this.chanceDefender = 4;
        this.escudo = dadosGuerreiros.getEscudo();
    }

    public void defender(Personagem inimigo)
    {
        inimigo.setPermissaoAtacar(true);
        int numeroAleatorio = random.nextInt(1,6);

        if(numeroAleatorio <= chanceDefender)
        {
            System.out.println("DEFENDEU");

            System.out.println("VIDA DO PERSONAGEM: " + this.vida);
            int danoinimigoAntesAlterar = inimigo.getDano();
            System.out.println("DANO INIMIGO SEM ALTERAR: " + danoinimigoAntesAlterar);
            inimigo.setDano( danoinimigoAntesAlterar / 2);
            System.out.println("DANO INIMIGO ALTERANDO O VALOR: " + inimigo.getDano());
            inimigo.atacar(this);
            System.out.println("VIDA DO PERSONAGEM: " + this.vida);
            inimigo.setDano(danoinimigoAntesAlterar);
            System.out.println("DANO DO INIMIGO ALTERADO COMO ANTES: " + inimigo.getDano());

            System.out.println(inimigo.getPermissaoAtacar());
            inimigo.setPermissaoAtacar(false);
            System.out.println(inimigo.getPermissaoAtacar());
        }
    }

    @Override
    public void atacar(Personagem monstro) {
        super.atacar(monstro);
        defender(monstro);
    }
}
