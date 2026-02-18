package ooad.structuralpattern.afternoonclass.bridgepattern.practice;

import java.util.List;
import java.util.Scanner;

class User{}
class Product{}
// abstraction
abstract class Service<T>{
    // bridge
    private final Repository<T> repository;
    public Service(Repository<T> repository){
        this.repository = repository;
    }
    public abstract List<T> getAll();
    public abstract T findById(String  id);
    public abstract int delete(T o);
}
class UserService extends Service<User>{
    public UserService(Repository<User> repository) {
        super(repository);
    }
    @Override
    public List<User> getAll() {
        System.out.println("Find All users");
        return List.of();
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public int delete(User o) {
        return 0;
    }
}
class ProductService extends Service<Product>{
    public ProductService(Repository<Product> repository) {
        super(repository);
    }

    @Override
    public List<Product> getAll() {
        System.out.println("Find All Products");
        return List.of();
    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public int delete(Product o) {
        return 0;
    }
}
// implementation
interface Repository<T>{
    List<T> findAll();
    T save(T o);
}
// concrete implementor
class UserRepository implements Repository<User>{
    @Override
    public List<User> findAll() {
        return List.of();
    }
    @Override
    public User save(User o) {
        return null;
    }
}
class ProductRepository implements Repository<Product>{
    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product save(Product o) {
        return null;
    }
}
public class Clients {
    public static void main(String[] args) {
        Service service = null;
        while (true){
            System.out.print("[+] Click: ");
            int opt = new Scanner(System.in).nextInt();
            switch (opt){
                case 1->{service = new UserService(
                        new UserRepository()
                );
                    service.getAll();
                }
                case 2->{
                    service = new ProductService(
                            new ProductRepository()
                    );
                    service.getAll();
                }
            }
        }

    }
}
