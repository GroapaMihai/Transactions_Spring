package com.bitwise.transactionsshowcase.service;

import com.bitwise.transactionsshowcase.entity.BankAccount;

public interface BankAccountService {

    BankAccount getById(Long id);

    BankAccount create(BankAccount bankAccount);

    BankAccount updateWithRequired(BankAccount bankAccount);

    BankAccount updateWithSupports(BankAccount bankAccount);

    BankAccount updateWithMandatory(BankAccount bankAccount);

    BankAccount updateWithNever(BankAccount bankAccount);

    BankAccount updateWithNotSupported(BankAccount bankAccount);

    BankAccount updateWithRequiresNew(BankAccount bankAccount);

    BankAccount updateWithNested(BankAccount bankAccount);
}
