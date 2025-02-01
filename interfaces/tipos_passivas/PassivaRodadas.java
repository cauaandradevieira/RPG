package projeto_rpg.interfaces.tipos_passivas;

import projeto_rpg.personagem.Personagem;

public interface PassivaRodadas
{
    String passivaRaiva = "RAIVA";

    void passivaRodadas(Personagem personagem);
    default void raiva() {}
}
