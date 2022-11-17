package work;

public class Logger {
    public void display(int attack1, int attack2, Pokemon pokemon1, Pokemon pokemon2, int count){

        String damage1 = null;
        String damage2 = null;

        /* Aflu cu ce atack am atacat si am fost atacat */
        if(attack1 == 0){
            if(pokemon1.getAttack()>0){
                damage1 = "Normal Attack";
            }
            if(pokemon1.getSpecialAttack()>0){
                damage1 = "Special Attack";
            }
        }
        if(attack1 == 1){
            damage1 = "Ability 1 ; Dodge = [False]";
            if(pokemon1.getAbility2() != null) {
                if (pokemon1.getAbility1().getDodge() == true) {
                    damage1 = "Ability 1 ; Dodge = [True]";
                }
            }
        }
        if(attack1 == 2) {
            damage1 = "Ability 2 ; Dodge = [False]";
            if (pokemon1.getAbility2() != null){
                if (pokemon1.getAbility2().getDodge() == true) {
                    damage1 = "Ability 2 ; Dodge = [True]";
                }
            }
        }

        if(attack2 == 0){
            if(pokemon2.getAttack()>0){
                damage2 = "Normal Attack";
            }
            if(pokemon2.getSpecialAttack()>0){
                damage2 = "Special Attack";
            }
        }

        if(attack2 == 1){
            damage2 = "Ability 1 ; Dodge = [False]";
            if(pokemon2.getAbility1() != null) {
                if (pokemon2.getAbility1().getDodge() == true) {
                    damage2 = "Ability 1 ; Dodge = [True]";
                }
            }
        }

        if(attack2 == 2){
            damage2 = "Ability 2 ; Dodge = [False]";
            if(pokemon2.getAbility2() != null) {
                if (pokemon2.getAbility2().getDodge() == true) {
                    damage2 = "Ability 2 ; Dodge = [True]";
                }
            }
        }

        if(pokemon1.getNume()=="Neutrel1"){
            damage1 = "Normal Attack";
        }

        if(pokemon2.getNume()=="Neutrel2"){
            damage2 = "Normal Attack";
        }

        if(pokemon2.getNume()=="Neutrel1"){
            damage2 = "Normal Attack";
        }

        if(pokemon1.getNume()=="Neutrel2"){
            damage1 = "Normal Attack";
        }
        System.out.println();
        System.out.println("Round [" + count + "]");
        System.out.println("Pokemons in battle : " + pokemon1.getNume() + " vs " + pokemon2.getNume());
        System.out.println(pokemon1.getNume() + " attacked with : " + damage1 + "    HP left " + pokemon1.getHP() +
                "   Stun " + pokemon1.getStun());
        System.out.println("Cooldown for ability1 ["+pokemon1.getCdAbility1()+"] , Cooldown for ability2 ["
                +pokemon1.getCdAbility2()+"]");
        System.out.println(pokemon2.getNume() + " attacked with : " + damage2 + "    HP left " + pokemon2.getHP() +
                "   Stun " + pokemon2.getStun());
        System.out.println("Cooldown for ability1 ["+pokemon2.getCdAbility1()+"] , Cooldown for ability2 ["
                +pokemon2.getCdAbility2()+"]");

        if(pokemon1.getHP() <= 0 && pokemon2.getHP() <= 0 ){
            /*Cu ajutorul compareTo ma uit la ordinea lexicografica a numelui pokemonului*/
            if(pokemon1.getNume().compareTo(pokemon2.getNume()) < 0){
                System.out.println();
                System.out.println("()()()()()()()()WINER()()()()()()()()()()()()");
                System.out.println("()()()()()()()()()"+pokemon1.getNume()+"()()()()()()()()()");
                System.out.println("()()()()()()()()()()()()()()()()()()()()()()()");
                return;
            }
            System.out.println();
            System.out.println("()()()()()()()()WINER()()()()()()()()()()()()");
            System.out.println("()()()()()()()()()"+pokemon2.getNume()+"()()()()()()()()()");
            System.out.println("()()()()()()()()()()()()()()()()()()()()()()()");
            return;
        }

        if(pokemon1.getHP() <= 0){
            System.out.println();
            System.out.println("()()()()()()()()()WINER()()()()()()()()()()()");
            System.out.println("()()()()()()()()()"+pokemon2.getNume()+"()()()()()()()()()");
            System.out.println("()()()()()()()()()()()()()()()()()()()()()()()");
        }

        if(pokemon2.getHP() <= 0){
            System.out.println();
            System.out.println("()()()()()()()()WINER()()()()()()()()()()()()");
            System.out.println("()()()()()()()()()"+pokemon1.getNume()+"()()()()()()()()()");
            System.out.println("()()()()()()()()()()()()()()()()()()()()()()()");
        }

        System.out.println();
    }
}
