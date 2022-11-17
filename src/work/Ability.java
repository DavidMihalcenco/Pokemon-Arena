package work;

public class Ability {
    private Integer Damage;
    private Boolean Stun;
    private Boolean Dodge;
    private Integer Cooldown;

    public Ability(Integer damage, Boolean stun, Boolean dodge, Integer cooldown) {
        Damage = damage;
        Stun = stun;
        Dodge = dodge;
        Cooldown = cooldown;
    }

    public Integer getDamage() {
        return Damage;
    }

    public Boolean getStun() {
        return Stun;
    }

    public Boolean getDodge() {
        return Dodge;
    }

    public Integer getCooldown() {
        return Cooldown;
    }

    public void setDamage(Integer damage) {
        Damage = damage;
    }

    public void setStun(Boolean stun) {
        Stun = stun;
    }

    public void setDodge(Boolean dodge) {
        Dodge = dodge;
    }

    public void setCooldown(Integer cooldown) {
        Cooldown = cooldown;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ability{");
        sb.append("Damage=").append(Damage);
        sb.append(", Stun=").append(Stun);
        sb.append(", Dodge=").append(Dodge);
        sb.append(", Cooldown=").append(Cooldown);
        sb.append('}');
        return sb.toString();
    }
}
