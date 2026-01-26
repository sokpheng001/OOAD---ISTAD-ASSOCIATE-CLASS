package model;

public record UserCreate(
                String userName,
        String email,
        String password
) {
   public String getName(){
       return userName;
   }
}
