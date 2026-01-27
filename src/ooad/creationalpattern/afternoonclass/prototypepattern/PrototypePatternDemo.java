package ooad.creationalpattern.afternoonclass.prototypepattern;

import lombok.AllArgsConstructor;
import lombok.ToString;

interface MinionPrototype{
    MinionPrototype clone();
}

@ToString
@AllArgsConstructor
class Minion implements MinionPrototype{
    private Integer id;
    private String color;
    private Integer damage;
    private Double hp;
    private String type;
    private Double speed;
    private String weapon;
    public void setId(Integer id) {
        this.id = id;
    }
    public void setColor(String color) {
        this.color = color;
    }
    //
    @Override
    public MinionPrototype clone() {
        return new Minion(id, color, damage, hp, type, speed, weapon);
    }
}

public class PrototypePatternDemo {
    public static void main(String[] args) {
        Minion minion1 = new Minion(1,"RED",100,100.0,
                "Magic User",1000.0,"Arrow");
        Minion minion2 = (Minion) minion1.clone();
        minion2.setColor("BLUE");
        minion2.setId(2);
        System.out.println("Minion1: " + minion1);
        System.out.println("Minion2: " + minion2);

    }
}
