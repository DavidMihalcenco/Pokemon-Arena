package work;

import pokemons.*;

public class PokemonFactory {
    private static PokemonFactory unicInstance;

    private PokemonFactory(){
    }

    public static PokemonFactory Instance() {
        if(unicInstance == null)
            unicInstance = new PokemonFactory();
        return unicInstance;
    }
    /*Creez fiecare pokemon*/
    public Pokemon createPokemon(String pokemon){
        switch (pokemon){
            case "Bulbasaur" -> {
                return new Bulbasaur("Bulbasaur",42,0,5,3,1,
                        new Ability(6,false,false,4),
                        new Ability(5,false,false,3), false, 0,0,
                        0);
            }
            case "Charmander" -> {
                return new Charmander("Charmander",50,4,0,3,2,
                        new Ability(4,true,false,4),
                        new Ability(7,false,false,6), false,0,0,
                        0);
            }
            case "Eevee" -> {
                return new Eevee("Eevee",39,0,4,3,3,
                        new Ability(5,false,false,3),
                        new Ability(3,true,false,3), false,0,0,
                        0);
            }
            case "Jigglypuff" -> {
                return new Jigglypuff("Jigglypuff",34,4,0,2,3,
                        new Ability(4,true,false,4),
                        new Ability(3,true,false,4), false,0,0,
                        0);
            }
            case "Meowth" -> {
                return new Meowth("Meowth",41,3,0,4,2,
                        new Ability(5,false,true,4),
                        new Ability(1,false,true,3), false,0,0,
                        0);
            }
            case "Neutrel1" -> {
                return new Neutrel1("Neutrel1",10,3,0,1,1,
                        null,null, false,0,0,0);
            }
            case "Neutrel2" -> {
                return new Neutrel2("Neutrel2",20,4,0,1,1,
                        null,null, false,0,0,0);
            }
            case "Pikachu" -> {
                return new Pikachu("Pikachu",35,0,4,2,3,
                        new Ability(6,false,false,4),
                        new Ability(4,true,true,5), false,0,0,
                        0);
            }
            case "Psyduck" -> {
                return new Psyduck("Psyduck",43,3,0,3,3,
                        new Ability(2,false,false,4),
                        new Ability(2,true,false,5), false,0,0,
                        0);
            }
            case "Snorlax" -> {
                return new Snorlax("Snorlax",62,3,0,6,4,
                        new Ability(4,false,false,3),
                        new Ability(0,false,true,5), false,0,0,
                        0);
            }
            case "Squirtle" -> {
                return new Squirtle("Squirtle",60,0,3,5,5,
                        new Ability(4,false,false,3),
                        new Ability(2,true,false,2), false,0,0,
                        0);
            }
            case "Vulpix" -> {
                return new Vulpix("Vulpix",36,5,0,2,4,
                        new Ability(8,true,false,6),
                        new Ability(2,false,true,7), false,0,0,
                        0);
            }
        }
        throw new IllegalArgumentException("Pokemon : " + pokemon + " does not exist ");
    }
}
