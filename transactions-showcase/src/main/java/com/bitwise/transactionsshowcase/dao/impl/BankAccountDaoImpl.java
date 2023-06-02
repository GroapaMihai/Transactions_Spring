package com.bitwise.transactionsshowcase.dao.impl;

import com.bitwise.transactionsshowcase.dao.BankAccountDao;
import com.bitwise.transactionsshowcase.entity.BankAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@AllArgsConstructor
@Repository
public class BankAccountDaoImpl implements BankAccountDao {

    private EntityManager entityManager;

    @Override
    public BankAccount getById(Long id) {
        return entityManager.find(BankAccount.class, id);
    }

    @Override
    public BankAccount create(BankAccount bankAccount) {
        entityManager.persist(bankAccount);

        return bankAccount;
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        BankAccount existingBankAccount = entityManager.find(BankAccount.class, bankAccount.getId());

        existingBankAccount.setBalance(bankAccount.getBalance());

        return entityManager.merge(existingBankAccount);
    }
}
