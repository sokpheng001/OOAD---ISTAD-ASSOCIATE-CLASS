package ooad.creationalpattern.afternoonclass;

import lombok.AllArgsConstructor;
import lombok.ToString;

interface IPhonePrototype{
    IPhonePrototype clone();
}
@AllArgsConstructor
@ToString
class IPhone implements IPhonePrototype{
    private Integer id;
    private String model;
    private String camera;
    private String chip;
    private String battery;
    private String color;
    private Double storage;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStorage(Double storage) {
        this.storage = storage;
    }
    //
    @Override
    public IPhonePrototype clone() {
        return new IPhone(id, model, camera, chip,battery, color,storage);
    }
}

public class IPhonePrototypeDemo {
    public static void main(String[] args) {
        IPhone iPhone1 = new IPhone(1,"17 Pro Max","48MP","A19",
                "4800mAh","RED",256.0);
        IPhone iPhone2 =(IPhone) iPhone1.clone();
        iPhone2.setColor("BLUE");
        iPhone2.setStorage(1000.0);
        System.out.println(iPhone1);
        System.out.println(iPhone2);
    }
}
