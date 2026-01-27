package ooad.creationalpattern.afternoonclass.builderpattern;
import lombok.ToString;

@ToString
class House{
    private Integer id;
    private String houseNumber;
    private String houseLocation;
    private String houseStreet;
    //
    private House(Builder builder){
        id = builder.id;
        houseLocation = builder.houseLocation;
        houseNumber = builder.houseNumber;
        houseStreet = builder.houseStreet;
    }
    // Builder
    public static class Builder{
        private Integer id;
        private String houseNumber;
        private String houseLocation;
        private String houseStreet;
        public Builder(){}
        public Builder id(Integer id){
            this.id = id;
            return this; // new Builder();
        }
        public Builder houseNumber(String houseNumber){
            this.houseNumber = houseNumber;
            return this;
        }
        public Builder houseLocation(String houseLocation){
            this.houseLocation = houseLocation;
            return this;
        }
        public Builder houseStreet(String houseStreet){
            this.houseStreet = houseStreet;
            return this;
        }
        public House build(){
            return new House(this);
        }
    }
}

public class BuilderPatternFluentVersion {
    public static void main(String[] args) {
        House house = new House.Builder()
                .id(1)
                .houseNumber("234")// chain method
                .houseStreet("23#")// chain method
                .build();
        System.out.println(house);
    }
}
