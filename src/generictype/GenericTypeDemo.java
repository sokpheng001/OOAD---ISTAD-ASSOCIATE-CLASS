package generictype;

import java.util.ArrayList;
import java.util.List;

class User{}
class Product{}
// interface
interface Repository<T, U>{
    T save(T object);
    List<T> findAll();
    U delete(T object);

}
class UserRepository implements Repository<User, Integer>{
    private List<User> users = new ArrayList<>();
    @Override
    public User save(User object) {
        users.add(object);
        return object;
    }
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Integer delete(User object) {
        return 0;
    }
}
class ProductRepository<T, U> implements Repository<T, U>{

    @Override
    public T save(T object) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return List.of();
    }

    @Override
    public U delete(T object) {
        return null;
    }
}

public class GenericTypeDemo {
    // generic method with bounded type
    public static <T extends Number> T get(List<T> data){
        ProductRepository<T, Integer> productRepository
                = new ProductRepository<>();
        for(T d:data){
            productRepository.save(d);
        }
        return data.getFirst();
    }
    public static void main(String[] args) {
        Integer data = GenericTypeDemo.<Integer>get(List.of(1,2,3));
        System.out.println(data);
    }
}
