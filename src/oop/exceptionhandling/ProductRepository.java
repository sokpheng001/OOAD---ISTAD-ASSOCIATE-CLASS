package oop.exceptionhandling;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductRepository {
    private List<Product> products
             = new ArrayList<>(
                     List.of(new Product(1, UUID.randomUUID().toString(),
                             "Coca","45",false),
                             new Product(2, UUID.randomUUID().toString(),
                                     "Pepsi","3567",false))
    );
    public void findAll(){
        System.out.println(products);
    }
    public void deleteProductByUuid(String uuid) throws ProductException{
        Product product = null;
        for (Product value : products) {
            if (value.getUuid().equals(uuid)) {
                product = value;
                break;
            }
        }
        if(product==null){
            throw new ProductException("Product is not found");
        }
        products.remove(product);
        System.out.println("Product has been deleted");
    }
}
