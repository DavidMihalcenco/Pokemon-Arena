package work;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Battle implements Runnable{
    Pokemon pokemon1 ;
    Pokemon pokemon2 ;
    int count = 0;

    public Battle(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    Logger logger = new Logger();
    @Override
    public void run() {

        Pokemon pok1 = null;
        Pokemon pok2 = null;

        try {
            pok1 = (Pokemon) pokemon1.clone();
            pok2 = (Pokemon) pokemon2.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        do{
            count++;
            int atackPokemon1 = (int) (Math.random() * 3);
            int fatackPokemon1 = pokemon1.attackTrue(atackPokemon1);
            int atackPokemon2 = (int) (Math.random() * 3);
            int fatackPokemon2 = pokemon2.attackTrue(atackPokemon2);

            ExecutorService executorService = Executors.newFixedThreadPool(2);
            executorService.execute(() -> pokemon1.decreasesHP(fatackPokemon1,fatackPokemon2,pokemon2));
            executorService.execute(() -> pokemon2.decreasesHP(fatackPokemon2,fatackPokemon1,pokemon1));
            executorService.shutdown();

            try{
                executorService.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            logger.display(fatackPokemon1,fatackPokemon2,pokemon1,pokemon2,count);

        }while (pokemon1.getHP() > 0 && pokemon2.getHP() > 0);

        count = 0;
        int finalHP1 = pokemon1.getHP();
        int finalHP2 = pokemon2.getHP();
        /*Setez hp-ul la cel care era inainte*/
        pokemon1.setHP(pok1.getHP());
        pokemon2.setHP(pok2.getHP());

        /*Setez cd-ul abilitatilor la 0*/
        pokemon1.setCdAbility1(0);
        pokemon1.setCdAbility2(0);
        pokemon2.setCdAbility2(0);
        pokemon2.setCdAbility1(0);

        /* Controlez care a castigat */
        if(finalHP1 <= 0){
            pokemon2.addStats1();
        }
        if(finalHP2 <= 0){
            pokemon1.addStats1();
        }

    }
}
