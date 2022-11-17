package work;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Arena {
    private static Arena unicInstance;

    private Arena(){

    }

    public static Arena Instance() {
        if(unicInstance == null)
            unicInstance = new Arena();
        return unicInstance;
    }

    public void randomOpponent(String pathToFile) throws FileNotFoundException {

        int count = 0 ;

        PokemonFactory pf = PokemonFactory.Instance();

        Pokemon neutrel1 = pf.createPokemon("Neutrel1");
        Pokemon neutrel2 = pf.createPokemon("Neutrel2");

        ReadFromFile r = new ReadFromFile();
        Trainer[] trainers = r.readTrainer(pathToFile);

        Pokemon[] pokemonsTrainer1 = new Pokemon[3];
        pokemonsTrainer1[0] = trainers[0].getPokemon1();
        pokemonsTrainer1[1] = trainers[0].getPokemon2();
        pokemonsTrainer1[2] = trainers[0].getPokemon3();

        PokemonBuff.createPokemonWithBuff(pokemonsTrainer1[0],trainers[0].getItems1());
        PokemonBuff.createPokemonWithBuff(pokemonsTrainer1[1],trainers[0].getItems2());
        PokemonBuff.createPokemonWithBuff(pokemonsTrainer1[2],trainers[0].getItems3());

        Pokemon[] pokemonsTrainer2 = new Pokemon[3];
        pokemonsTrainer2[0] = trainers[1].getPokemon1();
        pokemonsTrainer2[1] = trainers[1].getPokemon2();
        pokemonsTrainer2[2] = trainers[1].getPokemon3();

        PokemonBuff.createPokemonWithBuff(pokemonsTrainer2[0],trainers[1].getItems1());
        PokemonBuff.createPokemonWithBuff(pokemonsTrainer2[1],trainers[1].getItems2());
        PokemonBuff.createPokemonWithBuff(pokemonsTrainer2[2],trainers[1].getItems3());

        int number;

        do{
            number = (int) (Math.random() * 3);
            if(count == 3){
                count = 0;
            }
            switch (number){
                case(0) -> {
                    Battle battle = new Battle(pokemonsTrainer1[count] , neutrel1);
                    Battle battle1 = new Battle(pokemonsTrainer2[count] , neutrel1);
                    battle.run();
                    battle1.run();
                    count++;
                }
                case(1) ->{
                    Battle battle = new Battle(pokemonsTrainer1[count], neutrel2);
                    Battle battle1 = new Battle(pokemonsTrainer2[count], neutrel2);
                    battle.run();
                    battle1.run();
                    count++;
                }
                case(2) -> {
                    for(int i=0 ; i<3;i++) {
                        Battle battle = new Battle(pokemonsTrainer1[i], pokemonsTrainer2[i]);
                        battle.run();
                    }
                }
            }
        }while(number != 2);

        /*Fac suma atributelor a tuturor pokemonilor*/
        pokemonsTrainer1[0].sumOfAll();
        pokemonsTrainer1[1].sumOfAll();
        pokemonsTrainer1[2].sumOfAll();

        int i = 0;
        int j = 0;
        if(pokemonsTrainer1[2].getSumOfAtributes()>pokemonsTrainer1[1].getSumOfAtributes() &&
                pokemonsTrainer1[2].getSumOfAtributes()>pokemonsTrainer1[0].getSumOfAtributes()){
            i = 2;
        }
        if(pokemonsTrainer1[1].getSumOfAtributes()>pokemonsTrainer1[0].getSumOfAtributes() &&
                pokemonsTrainer1[1].getSumOfAtributes()>pokemonsTrainer1[2].getSumOfAtributes()){
            i = 1;
        }
        if(pokemonsTrainer1[0].getSumOfAtributes()>pokemonsTrainer1[2].getSumOfAtributes() &&
                pokemonsTrainer1[0].getSumOfAtributes()>pokemonsTrainer1[1].getSumOfAtributes()){
            i = 0 ;
        }
        /*Fac suma atributelor a tuturor pokemonilor*/
        pokemonsTrainer2[0].sumOfAll();
        pokemonsTrainer2[1].sumOfAll();
        pokemonsTrainer2[2].sumOfAll();

        if(pokemonsTrainer2[2].getSumOfAtributes()>pokemonsTrainer2[1].getSumOfAtributes() &&
                pokemonsTrainer2[2].getSumOfAtributes()>pokemonsTrainer2[0].getSumOfAtributes()){
            j = 2;
        }
        if(pokemonsTrainer2[1].getSumOfAtributes()>pokemonsTrainer2[0].getSumOfAtributes() &&
                pokemonsTrainer2[1].getSumOfAtributes()>pokemonsTrainer2[2].getSumOfAtributes()){
            j = 1;
        }
        if(pokemonsTrainer2[0].getSumOfAtributes()>pokemonsTrainer2[2].getSumOfAtributes() &&
                pokemonsTrainer2[0].getSumOfAtributes()>pokemonsTrainer2[1].getSumOfAtributes()){
            j = 0 ;
        }
        int HP = pokemonsTrainer1[i].getHP();
        int HP1 = pokemonsTrainer2[j].getHP();

        Battle battle = new Battle(pokemonsTrainer1[i],pokemonsTrainer2[j]);
        System.out.println("()()()()()()()()()()()()()()()()()()()()()()");
        System.out.println("()()()()()()()()()FINAL BATTLE()()()()()()()()()");
        System.out.println("()()()()()()()()()()()()()()()()()()()()()()()");
        battle.run();

        /* Ma uit cine a castigat in lupta finala */
        if(HP < pokemonsTrainer1[i].getHP()){
            System.out.println(" TRAINER :" + trainers[0].getName() + " Win Adventure ");
        }

        if(HP1 < pokemonsTrainer2[j].getHP()){
            System.out.println(" TRAINER :  " + trainers[1].getName() + " Win Adventure ");
        }
    }
}
