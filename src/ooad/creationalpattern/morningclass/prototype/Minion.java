package ooad.creationalpattern.morningclass.prototype;

public class Minion implements MinionPrototype{
    private Integer id;
    private Double hp;
    private Integer damage;
    private Integer skill;
    private Integer level;
    private String color;
    public void setId(Integer id){
        this.id = id;
    }
    public void setColor(String color){
        this.color = color;
    }
    public Minion(Integer id, Double hp, Integer damage, Integer skill, Integer level, String color) {
        this.id = id;
        this.hp = hp;
        this.damage = damage;
        this.skill = skill;
        this.level = level;
        this.color = color;
    }
    @Override
    public MinionPrototype clone() {
        return new Minion(id, hp, damage, skill, level,color);
    }
    @Override
    public String toString() {
        return "Minion{" +
                "id=" + id +
                ", hp=" + hp +
                ", damage=" + damage +
                ", skill=" + skill +
                ", level=" + level +
                ", color='" + color + '\'' +
                '}';
    }
}