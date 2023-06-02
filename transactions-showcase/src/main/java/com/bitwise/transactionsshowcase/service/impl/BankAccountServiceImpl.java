package com.bitwise.transactionsshowcase.service.impl;

import com.bitwise.transactionsshowcase.service.BankAccountService;
import com.bitwise.transactionsshowcase.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    @Qualifier("bankAccountHelperServiceImpl")
    private BankAccountService bankAccountHelperService;

    @Override
    public BankAccount getById(Long id) {
        return bankAccountHelperService.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BankAccount create(BankAccount bankAccount) {
        return bankAccountHelperService.create(bankAccount);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BankAccount updateWithRequired(BankAccount bankAccount) {
        return bankAccountHelperService.updateWithRequired(bankAccount);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BankAccount updateWithSupports(BankAccount bankAccount) {
        return bankAccountHelperService.updateWithSupports(bankAccount);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BankAccount updateWithMandatory(BankAccount bankAccount) {
        return bankAccountHelperService.updateWithMandatory(bankAccount);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BankAccount updateWithNever(BankAccount bankAccount) {
        return bankAccountHelperService.updateWithNever(bankAccount);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BankAccount updateWithNotSupported(BankAccount bankAccount) {
        return bankAccountHelperService.updateWithNotSupported(bankAccount);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BankAccount updateWithRequiresNew(BankAccount bankAccount) {
        return bankAccountHelperService.updateWithRequiresNew(bankAccount);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BankAccount updateWithNested(BankAccount bankAccount) {
        return bankAccountHelperService.updateWithNested(bankAccount);
    }
}
