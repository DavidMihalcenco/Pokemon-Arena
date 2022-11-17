package work;

public abstract class Pokemon implements Cloneable{
    private String nume;
    private Integer HP;
    private Integer attack;
    private Integer specialAttack;
    private Integer defense;
    private Integer specialDefense;
    private Ability ability1;
    private Ability ability2;
    private Boolean stun;
    private Integer cdAbility1;
    private Integer cdAbility2;
    private Integer sumOfAtributes;


    public Pokemon(String nume, Integer HP, Integer attack, Integer specialAttack, Integer defense, Integer specialDefense,
                   Ability ability1, Ability ability2, Boolean stun, Integer cdAbility1 , Integer cdAbility2 , Integer
                   sumOfAtributes) {
        this.nume = nume;
        this.HP = HP;
        this.attack = attack;
        this.specialAttack = specialAttack;
        this.defense = defense;
        this.specialDefense = specialDefense;
        this.ability1 = ability1;
        this.ability2 = ability2;
        this.stun = stun;
        this.cdAbility1 = cdAbility1;
        this.cdAbility2 = cdAbility2;
        this.sumOfAtributes = sumOfAtributes;
    }

    public String getNume() {
        return nume;
    }

    public Integer getHP() {
        return HP;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getSpecialAttack() {
        return specialAttack;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getSpecialDefense() {
        return specialDefense;
    }

    public Ability getAbility1() {
        return ability1;
    }

    public Ability getAbility2() {
        return ability2;
    }

    public Boolean getStun() { return stun; }

    public Integer getCdAbility1() {
        return cdAbility1;
    }

    public void setCdAbility1(Integer cdAbility1) {
        this.cdAbility1 = cdAbility1;
    }

    public Integer getCdAbility2() {
        return cdAbility2;
    }

    public void setCdAbility2(Integer cdAbility2) {
        this.cdAbility2 = cdAbility2;
    }

    public void setSumOfAtributes(Integer sumOfAtributes) {
        this.sumOfAtributes = sumOfAtributes;
    }

    public Integer getSumOfAtributes() {
        return sumOfAtributes;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public void setSpecialAttack(Integer specialAttack) {
        this.specialAttack = specialAttack;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public void setSpecialDefense(Integer specialDefense) {
        this.specialDefense = specialDefense;
    }

    public void setAbility1(Ability ability1) {
        this.ability1 = ability1;
    }

    public void setAbility2(Ability ability2) {
        this.ability2 = ability2;
    }

    /*Metoda care raspunde de adunarea tuturor caracteristicilor*/
    public void sumOfAll(){
        /*Fac suma la toate caracteristicile unui pokemon*/
        int sum = this.getHP()+this.getAttack()+this.getSpecialAttack()+this.getDefense()+this.getSpecialAttack();

        this.setSumOfAtributes(sum);
    }

    public void setStun(Boolean stun) { this.stun = stun; }

    /*Metoda care raspunde de adaugarea cu 1 la toate caracteristicile unui pokemon*/
    public void addStats1(){
        /*Controlez daca pokemonul are special atack*/
        if(this.getSpecialAttack() >0){
            this.setSpecialAttack(this.getSpecialAttack()+1);
        }
        /*Controlez daca pokemonul are atack*/
        if(this.getAttack() >0){
            this.setAttack(this.getAttack()+1);
        }
        /*Adaug la toate caracteristicile 1 */
        this.setHP(this.getHP()+1);
        this.setDefense(this.getDefense()+1);
        this.setSpecialDefense(this.getSpecialDefense()+1);
    }

    /*Metoda care imi intoarce cu ce tip de atack pot sa atac, care este disponibil*/
    public int attackTrue(int attack1){
        if(attack1 == 0){
            return 0;
        }

        if(attack1 == 1 && this.getCdAbility1() == 0){
            return 1;
        }

        if(attack1 == 2 && this.getCdAbility2() == 0){
            return 2;
        }

        if(this.getCdAbility1() == 0){
            return 1;
        }
        if(this.getCdAbility2() == 0){
            return 2;
        }
        return 0;
    }

    /*Metoda care raspunde de logica scaderii a HP*/
    public void decreasesHP(int attack1 , int attack2 , Pokemon pokemon){

        /*Controlez daca Abilitatea mai are cd daca are scad cu 1 */
        if(this.getCdAbility1()>0){
            this.setCdAbility1(this.getCdAbility1()-1);
        }

        if(this.getCdAbility2()>0){
            this.setCdAbility2(this.getCdAbility2()-1);
        }

        /*Daca am folosit abilitatea 1 sau 2 setez la caracteristica ajutatoare cd la abilitate pentru a sti cand pot
        sa o mai folosesc, aceasta caracteristica se v-a scadea la in fiecare runda
         */
        if(attack1 == 1 ){
            if(this.getAbility1()!=null)
                this.setCdAbility1(this.getAbility1().getCooldown());
        }

        if(attack1 == 2 ){
            if(this.getAbility2()!=null)
                this.setCdAbility2(this.getAbility2().getCooldown());
        }

        /*Controlez daca este neutrel in acest caz am doar atac fara abilitati*/
        if(pokemon.getNume()=="Neutrel1"){
            if(this.defense < pokemon.getAttack())
                this.setHP((this.getHP()-pokemon.getAttack())+this.defense);
            return;
        }

        if(pokemon.getNume()=="Neutrel2"){
            if(this.defense < pokemon.getAttack())
                this.setHP((this.getHP()-pokemon.getAttack())+this.defense);
            return;
        }

        /*Daca pokemonul este in stun se scoate din stun dar nu mai face nimic runda asta*/
        if(pokemon.getStun()==true){
            pokemon.setStun(false);
            return;
        }

        /*Daca abilitatea 1 sau 2 are dodge atunci in runda asta pokemonul nu v-a primi nici un damage*/
        if(attack1 == 1){
            if(this.getAbility1()!=null) {
                if (this.getAbility1().getDodge() == true) {
                    return;
                }
            }
        }

        if(attack1 == 2){
            if(this.getAbility2()!=null) {
                if (this.getAbility2().getDodge() == true) {
                    return;
                }
            }
        }
        /* Controlez cu ce m-a atacat cu attack sau special attack */
        if(attack2 == 0 ){
            /* Daca am mai mult defense decat el poate sa ma atace pokemonul nu v-a primi damage*/
            if(this.getDefense() > pokemon.getAttack()){
                if(pokemon.getAttack() > 0) {
                    this.setHP(getHP() - 0);
                    return;
                }
            }

            if(this.getSpecialDefense() > pokemon.getSpecialAttack()){
                if(pokemon.getSpecialAttack() > 0) {
                    this.setHP(getHP() - 0);
                    return;
                }
            }

            if(pokemon.getAttack() > 0) {
                this.setHP((getHP() - pokemon.getAttack())+this.getDefense());
                return;
            }

            if(pokemon.getSpecialDefense() > 0){
                this.setHP((getHP()-pokemon.getSpecialAttack())+this.getSpecialDefense());
                return;
            }

        }
        /*Cu ce abilitate ma ataca*/
        if(attack2 == 1){
            if(pokemon.getAbility1()!=null)
                this.setHP(this.getHP()-pokemon.getAbility1().getDamage());
            if(pokemon.getAbility1()!=null && pokemon.getAbility1().getStun()==true){
                this.setStun(true);
            }
            return;
        }

        if(attack2 == 2){
            if(pokemon.getAbility2()!=null)
                this.setHP(this.getHP()-pokemon.getAbility2().getDamage());
            if(pokemon.getAbility2()!=null && pokemon.getAbility2().getStun()==true){
                this.setStun(true);
            }
            return;
        }

    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pokemon{");
        sb.append("nume='").append(nume).append('\'');
        sb.append(", HP=").append(HP);
        sb.append(", attack=").append(attack);
        sb.append(", specialAttack=").append(specialAttack);
        sb.append(", defense=").append(defense);
        sb.append(", specialDefense=").append(specialDefense);
        sb.append(", ability1=").append(ability1);
        sb.append(", ability2=").append(ability2);
        sb.append(", stun=").append(stun);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
