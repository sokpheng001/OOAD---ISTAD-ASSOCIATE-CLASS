package ooad.creationalpattern.eveningclass.builderpattern;

import lombok.Setter;
import lombok.ToString;

// product
@Setter
@ToString
class Employee{
    private Integer id;
    private String name;
    private String email;
    private String profile;
    private String phoneNumber;
}
// builder
interface EmployeeBuilder{
    void initialize();
    void id(Integer id);
    void name(String name);
    void email(String email);
    void profile(String profile);
    void phoneNumber(String phoneNumber);
}
// concreteBuilder
class ConcreteEmployeeBuilder implements EmployeeBuilder{
    private  Employee result;
    // reset
    @Override
    public void initialize() {
        result = new Employee();
    }

    @Override
    public void id(Integer id) {
        result.setId(id);
    }

    @Override
    public void name(String name) {
        result.setName(name);
    }

    @Override
    public void email(String email) {
        result.setEmail(email);
    }

    @Override
    public void profile(String profile) {
        result.setProfile(profile);
    }

    @Override
    public void phoneNumber(String phoneNumber) {
        result.setPhoneNumber(phoneNumber);
    }
    // return object with its value
    public Employee getResult(){
        return this.result;
    }
}
// director
class EmployeeDirector{
    private EmployeeBuilder builder;
    public EmployeeDirector(EmployeeBuilder builder){
        this.builder = builder;
    }
    public void changeBuilder(EmployeeBuilder builder){
        this.builder = builder;
    }
    public void make(){
        builder.initialize();
        builder.id(1);
        builder.name("jame");
        builder.email("jame123@gmail.com");
        builder.profile("google.com/profile.exe");
        builder.phoneNumber("0999888222");
    }
}

public class BuilderPatternGOFStyle {
    public static void main(String[] args) {
        ConcreteEmployeeBuilder builder = new ConcreteEmployeeBuilder();
        builder.initialize();
        builder.id(1);
        builder.name("jame");
        builder.email("jame123@gmail.com");
        builder.profile("google");
        Employee employee = builder.getResult();
        System.out.println(employee);
    }
}
