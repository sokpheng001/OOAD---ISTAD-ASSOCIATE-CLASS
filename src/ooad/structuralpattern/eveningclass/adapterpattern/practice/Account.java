package ooad.structuralpattern.eveningclass.adapterpattern.practice;
import lombok.Data;

import java.util.Date;

@Data
public class Account {
    private Integer id;
    private String accountNumber;
    private String accountName;
    private Date createdDate;
    private Double balance;
}
