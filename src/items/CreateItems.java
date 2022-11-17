package items;

import work.PokemonFactory;

public class CreateItems {
    /* Metoda pentru a creea Itemele folosind Builder Pattern */
    public static Items CreateItems(String type) {
        Items object;
        switch (type){
            case "scut": {
                object = new Items.Builder("Scut")
                    .defense(2)
                    .specialDefense(2)
                    .build();
                break;
            }

            case "vesta": {
                object = new Items.Builder("Vesta")
                        .HP(10)
                        .build();
                break;
            }

            case "sabiuta": {
                object = new Items.Builder("Sabiuta")
                        .attack(3)
                        .build();
                break;
            }

            case "bagetaMagica": {
                object = new Items.Builder("Bagheta Magica")
                        .specialAttack(3)
                        .build();
                break;
            }

            case "vitamine": {
                object = new Items.Builder("Vitamine")
                        .HP(2)
                        .attack(2)
                        .specialAttack(2)
                        .build();
                break;
            }

            case "bradDeCraciun" :{
                object = new Items.Builder("Brad de Craciun")
                        .attack(3)
                        .defense(1)
                        .build();
                break;
            }

            case "pelerina" : {
                object = new Items.Builder("Pelerina")
                        .specialDefense(3)
                        .build();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return object;
    }

}
