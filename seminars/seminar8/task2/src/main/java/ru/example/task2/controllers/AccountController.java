package ru.example.task2.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.example.task2.dto.TransferRequest;
import ru.example.task2.model.Account;
import ru.example.task2.services.TransferService;

import java.util.List;

@AllArgsConstructor
@RestController
public class AccountController {

    private final TransferService transferService;

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request){
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountID(),
                request.getAmount()
        );
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return transferService.getAllAccounts();
    }
}
