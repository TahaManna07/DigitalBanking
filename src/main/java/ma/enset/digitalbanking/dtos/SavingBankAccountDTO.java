package ma.enset.digitalbanking.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.digitalbanking.entities.Customer;
import ma.enset.digitalbanking.entities.Operation;
import ma.enset.digitalbanking.enums.AccountStatus;

import java.util.Date;
import java.util.List;


@Data


public  class SavingBankAccountDTO extends  BankAccountDTO{
    private String id;
    private Date createdAt;
    private double balance;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;
}
