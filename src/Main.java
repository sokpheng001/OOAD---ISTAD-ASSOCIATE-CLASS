import java.util.List;

interface Repository<T,U>{
    List<T> findAll();
    T save(T o);
}
class Product{}
class ProductRepo implements Repository<Product, Integer>{
    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product save(Product o) {
        return null;
    }
}
class User{}
class UserRepo implements Repository<User, Integer>{
    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User save(User o) {
        return null;
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
