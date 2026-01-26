package collectionframework;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data // generate setter, getter and toString methods
@AllArgsConstructor // generate a constructor with parameter
class Product{
    private Integer id;
    private String uuid;
    private String pName;
    private LocalDate expireDate;
}

public class ListDemo {
    public static void main(String[] args) {
        // list of Objects
        List<Product> products = new ArrayList<>();
        Product product1 =new Product(1, UUID.randomUUID().toString(),
                "coca",LocalDate.of(2027,7,7));
        Product product2 =new Product(2, UUID.randomUUID().toString(),
                "pepsi",LocalDate.of(2027,7,7));
        products.add(product1);
        products.add(product2);
        // delete object from list
        products.removeIf(p->p.getId().equals(1));
        // printing all elements in
        for(Product p: products){
            System.out.println("ID: " + p.getId());
            System.out.println("UUID: " + p.getUuid());
            System.out.println("PRODUCT NAME: " + p.getPName());
            System.out.println("EXPIRE DATE: " + p.getExpireDate());
        }
    }
}
