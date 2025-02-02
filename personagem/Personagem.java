package projeto_rpg.personagem;

import projeto_rpg.interfaces.PersonagemInterface;

import java.util.Random;

public abstract class Personagem implements PersonagemInterface
{
    protected boolean permissaoAtacar;
    protected int vida;
    protected String arma;
    protected String nome;
    protected String passivaAtiva;
    protected int dano;
    protected int miss;
    protected int critico;
    protected int rodada;
    protected Random random;
    protected boolean houveCritico;
    protected boolean houveEsquiva;

    public Personagem()
    {
        random = new Random();
    }

    @Override
    public void causarDanoNo(Personagem personagem) {
        int danoTotal = golpeCritico();
        int novaVidaPersonagem = personagem.getVida() - danoTotal ;
        personagem.setVida(novaVidaPersonagem);
    }

    @Override
    public int golpeCritico()
    {
        int chanceCritar = random.nextInt(1, 6);

        if (this.houveCritico = (chanceCritar <= critico))
        {
            int danoTotal = this.dano * 2;
            System.out.println(this.nome + " causou: " + danoTotal + " de dano (CRITICO) com a " + this.arma);
            return danoTotal;
        }
        System.out.println(this.nome + " causou: " + this.dano + " de dano com a" + " com a " + this.arma);
        System.out.println(this.nome + houveCritico);
        return this.dano;
    }

    @Override
    public boolean esquivar()
    {
        int chanceEsquivar = random.nextInt(1,6);
        houveEsquiva = chanceEsquivar <= miss ;
        return houveEsquiva;
    }

    @Override
    public void atacar(Personagem personagem)
    {
        if(!this.getPermissaoAtacar())
        {
            System.out.println(this.nome + " PERMISSAO ATACAR FALSEEEEEE !!!!");
            return;
        }

        if(!personagem.esquivar())
        {
            this.causarDanoNo(personagem);
            return;
        }
        System.out.println(personagem.getNome() + " Esquivou...");
    }

    @Override
    public boolean verificarVida() {
        return this.getVida() > 0;
    }

    public boolean getHouveCritico() {
        return houveCritico;
    }

    public void setHouveCritico(boolean houveCritico) {
        this.houveCritico = houveCritico;
    }

    public boolean getHouveEsquiva() {
        return houveEsquiva;
    }

    public void setHouveEsquiva(boolean houveEsquiva) {
        this.houveEsquiva = houveEsquiva;
    }

    @Override
    public String toString() {
        return "Personagem{}";
    }

    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public String getArma() {
        return arma;
    }
    public void setArma(String arma) {
        this.arma = arma;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getDano() {
        return dano;
    }
    public void setDano(int dano) {
        this.dano = dano;
    }
    public int getMiss() {
        return miss;
    }
    public void setMiss(int miss) {
        this.miss = miss;
    }
    public int getCritico() {
        return critico;
    }
    public void setCritico(int critico) {
        this.critico = critico;
    }
    public boolean getPermissaoAtacar() {return permissaoAtacar;}
    public void setPermissaoAtacar(boolean permissaoAtacar) {this.permissaoAtacar = permissaoAtacar;}
}
