package projeto_rpg.personagem;

public interface PersonagemInterface
{
    void atacar(Personagem personagem);
    boolean esquivar();
    int golpeCritico();
    void causarDanoNo(Personagem personagem);
    boolean verificarVida();
}
