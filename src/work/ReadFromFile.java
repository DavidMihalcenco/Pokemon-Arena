package work;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    public Trainer[] readTrainer(String pathToFile) throws FileNotFoundException{
        Trainer[] trainers = new Trainer[2];
        FileReader file = new FileReader(pathToFile);
        PokemonFactory pokemonFactory = PokemonFactory.Instance();
        try (BufferedReader br = new BufferedReader(file)) {
            int i =0;
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] lineS = line.split("###");

                trainers[i] = new Trainer(lineS[0],Integer.parseInt(lineS[1]),pokemonFactory.createPokemon(lineS[2]),
                        pokemonFactory.createPokemon(lineS[4])
                        ,pokemonFactory.createPokemon(lineS[6]),lineS[3],lineS[5],
                        lineS[7]);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return trainers;

    }
}
