package ma.enset.digitalbanking.mappers;

import ma.enset.digitalbanking.dtos.CurrentBankAccountDTO;
import ma.enset.digitalbanking.dtos.CustomerDTO;
import ma.enset.digitalbanking.dtos.OperationDTO;
import ma.enset.digitalbanking.dtos.SavingBankAccountDTO;
import ma.enset.digitalbanking.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
// Map Struct comme une deuxieme solution pour le mapping
@Service
public class BankAccountMapperImpl {
    public CustomerDTO fromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    public Customer fromCustomer(CustomerDTO customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        return customer;
    }

    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount) {
        SavingBankAccountDTO savingBankAccountDTO = new SavingBankAccountDTO();
        BeanUtils.copyProperties(savingAccount, savingBankAccountDTO);
        savingBankAccountDTO.setCustomerDTO(fromCustomer(savingAccount.getCustomer()));
        savingBankAccountDTO.setType(savingAccount.getClass().getSimpleName());
        return savingBankAccountDTO;
    }
    public SavingAccount fromBankAccount(SavingBankAccountDTO savingBankAccountDTO) {
        SavingAccount account = new SavingAccount();
        BeanUtils.copyProperties(savingBankAccountDTO, account);
        account.setCustomer(fromCustomer(savingBankAccountDTO.getCustomerDTO()));
         return account;

    }

    public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount){
        CurrentBankAccountDTO currentBankAccountDTO = new CurrentBankAccountDTO();
        BeanUtils.copyProperties(currentAccount, currentBankAccountDTO);
        currentBankAccountDTO.setCustomerDTO(fromCustomer(currentAccount.getCustomer()));
        currentBankAccountDTO.setType(currentAccount.getClass().getSimpleName());

        return currentBankAccountDTO;

    }
    public CurrentAccount fromBankAccount(CurrentBankAccountDTO currentBankAccountDTO){
        CurrentAccount currentAccount = new CurrentAccount();
        BeanUtils.copyProperties(currentBankAccountDTO,currentAccount);
        currentAccount.setCustomer(fromCustomer(currentBankAccountDTO.getCustomerDTO()));
        return currentAccount;
    }
    public OperationDTO fromOperation(Operation operation){
        OperationDTO operationDTO = new OperationDTO();
        BeanUtils.copyProperties(operation,operationDTO);

        return operationDTO;
    }
    public Operation fromOperation(OperationDTO operationDTO){
        Operation operation = new Operation();
        BeanUtils.copyProperties(operationDTO,operation);
        return operation;
    }
}

