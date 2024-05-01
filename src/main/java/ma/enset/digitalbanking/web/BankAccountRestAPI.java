package ma.enset.digitalbanking.web;

import lombok.AllArgsConstructor;
import ma.enset.digitalbanking.dtos.AccountHistoryDTO;
import ma.enset.digitalbanking.dtos.BankAccountDTO;
import ma.enset.digitalbanking.dtos.OperationDTO;
import ma.enset.digitalbanking.exceptions.BankAccountNotFoundException;
import ma.enset.digitalbanking.services.BankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class BankAccountRestAPI {
    private BankAccountService bankAccountService;

    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccont(@PathVariable String accountId) throws BankAccountNotFoundException {
        BankAccountDTO bankAccountDTO = bankAccountService.getBankAccount(accountId);
        return  bankAccountDTO;
    }
    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccount(){
        return bankAccountService.bankAccountList();

    }
    @GetMapping("/accounts/{accountId}/operations")
    public List<OperationDTO> history(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);

    }
    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(@PathVariable String accountId,
                                               @RequestParam(name = "page",defaultValue = "0") int page ,
                                               @RequestParam(name = "size",defaultValue = "5") int size ) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId, page,size);

    }
}
