package oop.exceptionhandling;

import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args){
        ProductRepository productRepository = new ProductRepository();
        productRepository.findAll();
        System.out.print("[+] Insert Product uuid: ");
        String uuid = new Scanner(System.in).nextLine();
        try {
            productRepository.deleteProductByUuid(uuid);
        }catch (ProductException exception){
            System.out.println(exception.getMessage());
        }
        productRepository.findAll();
    }
}
