package com.bitwise.transactionsshowcase.controller;

import com.bitwise.transactionsshowcase.entity.BankAccount;
import com.bitwise.transactionsshowcase.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Propagation;

@RestController
@RequestMapping("/api/bank-accounts")
public class BankAccountController {

    @Autowired
    @Qualifier("bankAccountServiceImpl")
    private BankAccountService bankAccountService;

    @GetMapping("{id}")
    public BankAccount getById(@PathVariable Long id) {
        return bankAccountService.getById(id);
    }

    @PostMapping
    public BankAccount create(@RequestBody BankAccount bankAccount) {
        return bankAccountService.create(bankAccount);
    }

    @PutMapping("{propagation}")
    public BankAccount update(@PathVariable("propagation") Propagation propagation, @RequestBody BankAccount bankAccount) {
        switch (propagation) {
            case REQUIRED:
                return bankAccountService.updateWithRequired(bankAccount);
            case SUPPORTS:
                return bankAccountService.updateWithSupports(bankAccount);
            case MANDATORY:
                return bankAccountService.updateWithMandatory(bankAccount);
            case NEVER:
                return bankAccountService.updateWithNever(bankAccount);
            case NOT_SUPPORTED:
                return bankAccountService.updateWithNotSupported(bankAccount);
            case REQUIRES_NEW:
                return bankAccountService.updateWithRequiresNew(bankAccount);
            case NESTED:
                return bankAccountService.updateWithNested(bankAccount);
            default:
                return null;
        }
    }
}
