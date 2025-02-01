package projeto_rpg.interfaces;

import projeto_rpg.personagem.Personagem;

public interface PersonagemInterface
{
    boolean PERMISSAO_ATACAR_INICIAL = true;

    void atacar(Personagem personagem);
    boolean esquivar();
    int golpeCritico();
    void causarDanoNo(Personagem personagem);
    boolean verificarVida();
}
