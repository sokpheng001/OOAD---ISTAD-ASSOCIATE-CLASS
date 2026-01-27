package ooad.creationalpattern.afternoonclass.builderpattern;

import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

// product
@Setter
@ToString
class Product{
    private Integer id;
    private String name;
    private String code;
    private String description;
    private LocalDate expireDate;
    private Boolean isDeleted;
}
// Builder
interface Builder{
    void reset();
    void buildId(Integer id);
    void buildName(String name);
    void buildCode(String code);
    void buildDescription(String des);
    void buildExpireDate(LocalDate expireDate);
    void buildIsDeleted(Boolean isDeleted);
}
// concreteBuilder
class ConcreteBuilder implements Builder{
    private Product result;
    @Override
    public void reset() {
        result = new Product();
    }

    @Override
    public void buildId(Integer id) {
        result.setId(id);
    }

    @Override
    public void buildName(String name) {
        result.setName(name);
    }

    @Override
    public void buildCode(String code) {
        result.setCode(code);
    }

    @Override
    public void buildDescription(String description) {
        result.setDescription(description);
    }

    @Override
    public void buildExpireDate(LocalDate expireDate) {
        result.setExpireDate(expireDate);
    }

    @Override
    public void buildIsDeleted(Boolean isDeleted) {
        result.setIsDeleted(isDeleted);
    }
    public Product getResult(){
        return result;
    }
}

enum Role{
    ADMIN,
    USER
}
@Setter
@ToString
class User{
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String profile;
    private String cover;
    private String bio;
    private String phoneNumber;
    private List<String> socialUrls;// website, linked, github
    private List<Role> roles;
}
interface UserBuilder{
    void reset();
    void buildId(Integer id);
    void buildName(String name);
    void buildEmail(String email);
    void buildPassword(String password);
    void buildProfile(String profile);
    void buildCover(String cover);
    void buildBio(String bio);
    void buildPhoneNumber(String phoneNumber);
    void buildSocialUrls(List<String> socialUrls);
    void buildRoles(List<Role> roles);
    //....
}
class ConcreteUserBuilder implements UserBuilder{

    private User user;

    @Override
    public void reset() {
        user = new User();
    }

    @Override
    public void buildId(Integer id) {
        user.setId(id);
    }

    @Override
    public void buildName(String name) {
        user.setName(name);
    }

    @Override
    public void buildEmail(String email) {
        user.setEmail(email);
    }

    @Override
    public void buildPassword(String password) {
        user.setPassword(password);
    }

    @Override
    public void buildProfile(String profile) {
        user.setProfile(profile);
    }

    @Override
    public void buildCover(String cover) {
        user.setCover(cover);
    }

    @Override
    public void buildBio(String bio) {
        user.setBio(bio);
    }

    @Override
    public void buildPhoneNumber(String phoneNumber) {
        user.setPhoneNumber(phoneNumber);
    }

    @Override
    public void buildSocialUrls(List<String> socialUrls) {
        user.setSocialUrls(socialUrls);
    }

    @Override
    public void buildRoles(List<Role> roles) {
        user.setRoles(roles);
    }
    //
    public User getUser(){
        return this.user;
    }
}

//client
public class BuilderPatternGOFVersion {
    public static void main(String[] args) {
        ConcreteUserBuilder concreteUserBuilder
                 = new ConcreteUserBuilder();
        concreteUserBuilder.reset();
        concreteUserBuilder.buildId(12);
        concreteUserBuilder.buildName("Jame");
        concreteUserBuilder.buildRoles(
                List.of(Role.ADMIN, Role.USER)
        );
        User user = concreteUserBuilder.getUser();
        System.out.println(user);
    }
}
