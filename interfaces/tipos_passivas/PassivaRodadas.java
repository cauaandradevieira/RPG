package projeto_rpg.interfaces.tipos_passivas;

import projeto_rpg.personagem.Personagem;

public interface PassivaRodadas
{
    String passivaFuria = "FURIA";
    String passivaGritoFenhir = "GRITO_FENHIR";
    void passivaRodadas(Personagem personagem);
    default void furia() {}
    default void gritoFenhir(){}
}
