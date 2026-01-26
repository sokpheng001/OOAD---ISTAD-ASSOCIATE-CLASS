package ooad.creationalpattern.morningclass;


class Customer{
    private Integer id;
    private String userName;
    private String email;
    private String password;
    private String profile;
    private Customer(Builder builder) {
        id = builder.id;
        userName = builder.userName;
        email = builder.email;
        password = builder.password;
        profile = builder.profile;
    }
    public static class Builder{
        private Integer id;
        private String userName;
        private String email;
        private String password;
        private String profile;
        public Builder id(Integer id){
            this.id = id;
            return this;
        }
        public Builder userName(String userName){
            this.userName = userName;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public Builder profile(String profile){
            this.profile = profile;
            return this;
        }
        public  Customer build(){
            return new Customer(this);
        }
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Customer customer = new Customer.Builder()
                .id(1)
                .build();
        System.out.println(customer);
    }
}
