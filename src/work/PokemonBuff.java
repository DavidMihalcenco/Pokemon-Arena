package work;

import items.CreateItems;
import items.Items;

public class PokemonBuff {
    /*Primeste o lista de iteme atribuite unui pokemon si le creaza , fiecarui pokemon punand atributele itemelor*/
    public static void createPokemonWithBuff(Pokemon pokemon , String items){
        String[] strgs = items.split(";");

        for (String item : strgs){

            if(item.equals("Scut")){
                Items scut = CreateItems.CreateItems("scut");

                pokemon.setSpecialDefense(pokemon.getSpecialDefense() + scut.getSpecialDefense());
                pokemon.setDefense(pokemon.getDefense() + scut.getDefense());

            }

            if(item.equals("Vesta")){
                Items vesta = CreateItems.CreateItems("vesta");
                pokemon.setHP(pokemon.getHP()+vesta.getHP());
            }

            if(item.equals("Sabiuta")){
                Items sabiuta = CreateItems.CreateItems("sabiuta");
                if(pokemon.getAttack()>0){
                    pokemon.setAttack(pokemon.getAttack()+sabiuta.getAttack());
                }
            }

            if(item.equals("Bageta Magica")){
                Items bagetaMagica = CreateItems.CreateItems("bagetaMagica");

                pokemon.setSpecialDefense(pokemon.getSpecialAttack()+bagetaMagica.getSpecialAttack());

            }

            if(item.equals("Vitamine")){
                Items vitamine = CreateItems.CreateItems("vitamine");
                pokemon.setHP(pokemon.getHP()+vitamine.getHP());
                if(pokemon.getAttack()>0){
                    pokemon.setAttack(pokemon.getAttack()+vitamine.getAttack());
                }
                if(pokemon.getSpecialAttack()>0){
                    pokemon.setSpecialAttack(pokemon.getSpecialAttack()+vitamine.getSpecialAttack());
                }
            }

            if(item.equals("Brad De Craciun")){
                Items bradDeCraciun = CreateItems.CreateItems("bradDeCraciun");

                if(pokemon.getAttack()>0){
                    pokemon.setAttack(pokemon.getAttack()+bradDeCraciun.getAttack());
                }

                pokemon.setDefense(pokemon.getDefense() + bradDeCraciun.getDefense());

            }

            if(item.equals("Pelerina")){
                Items pelerina = CreateItems.CreateItems("pelerina");

                pokemon.setSpecialDefense(pokemon.getSpecialDefense()+pelerina.getSpecialDefense());

            }
        }
    }
}
