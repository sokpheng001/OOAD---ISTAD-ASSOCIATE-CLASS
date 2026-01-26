package ooad.creationalpattern.morningclass;

import java.time.LocalDate;
import java.util.List;

class User_{
    private Integer id;
    private String userName;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String gender;
    private String role;
    private Boolean isActive;
    private LocalDate createdDate;
    private List<Account>accounts;
    private User_(Builder builder){
        id = builder.id;
        //...
    }
    public static class Builder{
        private Integer id;
        private String userName;
        private String fullName;
        private String phoneNumber;
        private String address;
        private String gender;
        private String role;
        private Boolean isActive;
        private LocalDate createdDate;
        private List<Account>accounts;
        public Builder(){};
        public Builder id(Integer id){
            this.id = id;
            return this;
        }
        //..
        public User_ build(){
            return new User_(this);
        }
    }
}
class Account{
    private Integer id;
    private String accountNumber;
    private String accountType;
    private LocalDate openAt;
    private Boolean active;
    private String cvv;
    private String accountName;
    private String qrCodeLink;
    private LocalDate expiredDate;
    private Double balance;
}

public class Practice {
    public static void main(String[] args) {
        User_ user = new User_.Builder()
                .id(1)
                .build();
    }
}
