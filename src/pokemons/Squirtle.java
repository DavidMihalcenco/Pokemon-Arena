package pokemons;

import work.Ability;
import work.Pokemon;

public class Squirtle extends Pokemon {
    public Squirtle(String nume, Integer HP, Integer attack, Integer specialAttack, Integer defense,
                    Integer specialDefense, Ability ability1, Ability ability2, Boolean stun, Integer cdAbility1,
                    Integer cdAbility2, Integer sumOfAtributes) {
        super(nume, HP, attack, specialAttack, defense, specialDefense, ability1, ability2, stun, cdAbility1, cdAbility2
                ,sumOfAtributes);
    }
}

