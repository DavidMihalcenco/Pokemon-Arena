package items;

public class Items{
    private final String nume;
    private final Integer HP;
    private final Integer attack;
    private final Integer specialAttack;
    private final Integer defense;
    private final Integer specialDefense;

    private Items(Builder builder) {
       this.nume = builder.nume;
       this.HP = builder.HP;
       this.attack = builder.attack;
       this.specialAttack = builder.specialAttack;
       this.defense = builder.defense;
       this.specialDefense = builder.specialDefense;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Items{");
        sb.append("nume='").append(nume).append('\'');
        sb.append(", HP=").append(HP);
        sb.append(", attack=").append(attack);
        sb.append(", specialAttack=").append(specialAttack);
        sb.append(", defense=").append(defense);
        sb.append(", specialDefense=").append(specialDefense);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder{
        private final String nume;
        private Integer HP;
        private Integer attack;
        private Integer specialAttack;
        private Integer defense;
        private Integer specialDefense;

        public Builder (String nume){
            this.nume = nume;
        }

        public Builder HP(Integer HP){
            this.HP = HP;
            return this;
        }

        public Builder attack(Integer attack){
            this.attack = attack;
            return this;
        }

        public Builder specialAttack(Integer specialAttack){
            this.specialAttack = specialAttack;
            return this;
        }

        public Builder defense(Integer defense){
            this.defense = defense;
            return this;
        }

        public Builder specialDefense(Integer specialDefense){
            this.specialDefense = specialDefense;
            return this;
        }

        public Items build() {
            Items items = new Items(this);
            return items;
        }
    }
}
