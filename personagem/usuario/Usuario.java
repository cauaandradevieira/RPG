package projeto_rpg.personagem.usuario;

import projeto_rpg.loja.DadosItens;
import projeto_rpg.interfaces.VariaveisConst;
import projeto_rpg.loja.Item;
import projeto_rpg.personagem.Personagem;
import projeto_rpg.personagem.monstro.DadosMonstros;
import projeto_rpg.personagem.monstro.Monstro;

import java.util.ArrayList;

public abstract class Usuario extends Personagem implements VariaveisConst
{
    protected float barralevel;
    protected int nivel;
    protected ArrayList <Item> inventario;
    protected double moeda;

    public Usuario()
    {
        super();
        this.barralevel = BARRA_LEVEL_INICIAL;
        this.nivel = NIVEL_INICIAL;
        this.permissaoAtacar = PERMISSAO_ATACAR_INICIAL;
        this.passivaAtiva = "";
        this.inventario = new ArrayList<>();
        this.moeda = 100;
    }

    @Override
    public void atacar(Personagem personagem)
    {
        super.atacar(personagem);
        if(!personagem.verificarVida())
        {
            levelUp(personagem);
        }
    }

    @Override
    public boolean verificarVida()
    {
        return super.verificarVida();
    }

    public void levelUp(Personagem monstro)
    {
        DadosMonstros dadosMonstros = null;

        if(monstro == null)
        {
            System.out.println("nenhum monstro criado...");
            return;
        }

        if(monstro instanceof Monstro monstro1)
        {
            dadosMonstros = monstro1.getDadosMonstros();
        }

        if(dadosMonstros == null)
        {
            System.out.println("dados dos monstros nao criado");
        }


        float resultado = (float) (dadosMonstros.getVida() + dadosMonstros.getDano()) / 2; // TROCA PELO ENUM
        this.barralevel += resultado;

        if(this.barralevel >= BARRA_LEVEL_MAXIMO)
        {
            this.nivel += 1;
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("LEVEL UP !!");
            System.out.println("Aumento de dano de: " + this.dano + " -> " + (AUMENTO_DANO+this.dano));
            System.out.println("Aumento de vida de: " + this.vida + " -> " + (AUMENTO_VIDA+this.vida));
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");


            this.dano += AUMENTO_DANO;
            this.vida += AUMENTO_VIDA;
            this.barralevel = 0;
        }
    }

    public void exibirItens()
    {
        for (Item itens : inventario)
        {
            System.out.println(itens);
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public float getBarralevel() {
        return barralevel;
    }

    public void setBarralevel(float barralevel) {
        this.barralevel = barralevel;
    }

    public ArrayList<Item> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Item> inventario) {
        this.inventario = inventario;
    }

    public double getMoeda() {
        return moeda;
    }

    public void setMoeda(double moeda) {
        this.moeda = moeda;
    }
}
