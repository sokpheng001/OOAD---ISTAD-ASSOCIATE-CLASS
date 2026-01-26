package oop.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Integer id;
    private String uuid;
    private String pName;
    private String pCode;
    private Boolean isDeleted;
}
