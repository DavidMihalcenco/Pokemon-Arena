package work;

import java.lang.invoke.SwitchPoint;

public class Trainer {
    private String name;
    private Integer age;
    private Pokemon pokemon1;
    private String items1;
    private Pokemon pokemon2;
    private String items2;
    private Pokemon pokemon3;
    private String items3;

    public Trainer(String name, Integer age, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, String items1, String
                   items2, String items3) {
        this.name = name;
        this.age = age;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.items1 = items1;
        this.items2 = items2;
        this.items3 = items3;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public Pokemon getPokemon3() {
        return pokemon3;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public void setPokemon3(Pokemon pokemon3) {
        this.pokemon3 = pokemon3;
    }

    public String getItems1() {
        return items1;
    }

    public String getItems2() {
        return items2;
    }

    public String getItems3() {
        return items3;
    }

    public void setItems1(String items1) {
        this.items1 = items1;
    }

    public void setItems2(String items2) {
        this.items2 = items2;
    }

    public void setItems3(String items3) {
        this.items3 = items3;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trainer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", pokemon1='").append(pokemon1).append('\'');
        sb.append(", items1='").append(items1).append('\'');
        sb.append(", pokemon2='").append(pokemon2).append('\'');
        sb.append(", items2='").append(items2).append('\'');
        sb.append(", pokemon3='").append(pokemon3).append('\'');
        sb.append(", items3='").append(items3).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
