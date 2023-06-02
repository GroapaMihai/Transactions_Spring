package com.bitwise.transactionsshowcase.dao;

import com.bitwise.transactionsshowcase.entity.BankAccount;

public interface BankAccountDao {

    BankAccount getById(Long id);

    BankAccount create(BankAccount bankAccount);

    BankAccount update(BankAccount bankAccount);
}
