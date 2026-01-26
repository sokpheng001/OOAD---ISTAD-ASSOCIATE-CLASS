package dto_dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@ToString
@Getter
class User{
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String profile;
    private String cover;
    private Boolean isDeleted;
    private Boolean isVerified;
}
record UserCreateDto(
        String name,
        String email,
        String password,
        String phoneNumber
){}
record UserResponseDto(
        Integer id,
          String name ,
          String email ,
          String phoneNumber ,
          String profile ,
          String cover ,
          Boolean isDeleted ,
          Boolean isVerified
){}
// convert from DTO to Original Object
// mapper
class UserMapper{
    public static User mapFromUserCreateDtoToUser(UserCreateDto createDto){
        return new User(new Random().nextInt(9999999),
                createDto.name(),
                createDto.email(),
                createDto.password(),
                createDto.phoneNumber(),
                null,
                null,
                false, true);
    }
    public static UserResponseDto mapFromUserToUserResponseDto(User user){
        return new UserResponseDto(user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getProfile(),
                user.getCover(),
                user.getIsDeleted(),
                user.getIsVerified());
    }
}
// DAO - Data Access Object
class UserRepository{
    private List<User> users = new ArrayList<>();
    // create or save
    public User save(User user){
        this.users.add(user);
        return user;
    }
    //
    public List<User> findAll(){
        return this.users;
    }
    public int delete(User user){
        this.users.remove(user);
        return 1;
    }
    //
}

public class ApplicationDemo {
    public static void main(String[] args) {
        UserCreateDto userCreateDto = new UserCreateDto(
                "koko",
                "koko123@gmail.com",
                "@#%$6",
                "097777777"
        );
        User user = UserMapper.mapFromUserCreateDtoToUser(userCreateDto);
        //
        UserRepository userRepository = new UserRepository();
        // userRepository is a DAO - Data Access Object
        User user1 = userRepository.save(user);
        UserResponseDto userResponseDto =
                UserMapper.mapFromUserToUserResponseDto(user1);
        System.out.println(userResponseDto);
    }
}
