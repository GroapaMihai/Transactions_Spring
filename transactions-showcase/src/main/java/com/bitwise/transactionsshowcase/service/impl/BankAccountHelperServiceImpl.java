package com.bitwise.transactionsshowcase.service.impl;

import com.bitwise.transactionsshowcase.dao.BankAccountDao;
import com.bitwise.transactionsshowcase.entity.BankAccount;
import com.bitwise.transactionsshowcase.service.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BankAccountHelperServiceImpl implements BankAccountService {

    private BankAccountDao bankAccountDao;

    @Override
    public BankAccount getById(Long id) {
        return bankAccountDao.getById(id);
    }

    /**
     * This method requires @Transactional, otherwise throws javax.persistence.TransactionRequiredException:
     * No EntityManager with actual transaction available for current thread - cannot reliably process 'persist' call.
     *
     * @param bankAccount bank account to create
     * @return created bank account
     */
    @Override
    public BankAccount create(BankAccount bankAccount) {
        return bankAccountDao.create(bankAccount);
    }

    /**
     * This method requires @Transactional, otherwise throws javax.persistence.TransactionRequiredException:
     * No EntityManager with actual transaction available for current thread - cannot reliably process 'merge' call.
     *
     * 1. REQUIRED is the default propagation. Spring checks if there is an active transaction, and if nothing exists, it creates a new one.
     * Otherwise, the business logic appends to the currently active transaction.
     *
     * @param bankAccount bank account to update
     * @return updated bank account
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BankAccount updateWithRequired(BankAccount bankAccount) {
        return bankAccountDao.update(bankAccount);
    }

    /**
     * 2. For SUPPORTS, Spring first checks if an active transaction exists. If a transaction exists, then the existing
     * transaction will be used. If there isn't a transaction, it is executed non-transactional.
     *
     * @param bankAccount bank account to update
     * @return updated bank account
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public BankAccount updateWithSupports(BankAccount bankAccount) {
        return bankAccountDao.update(bankAccount);
    }

    /**
     * 3. When the propagation is MANDATORY, if there is an active transaction, then it will be used.
     * If there isn't an active transaction, then Spring throws an exception.
     * IllegalTransactionStateException: No existing transaction found for transaction marked with propagation 'mandatory'
     *
     * @param bankAccount bank account to update
     * @return updated bank account
     */
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public BankAccount updateWithMandatory(BankAccount bankAccount) {
        return bankAccountDao.update(bankAccount);
    }

    /**
     * 4. For transactional logic with NEVER propagation, Spring throws an exception if there's an active transaction.
     * IllegalTransactionStateException: Existing transaction found for transaction marked with propagation 'never'
     *
     * @param bankAccount bank account to update
     * @return updated bank account
     */
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public BankAccount updateWithNever(BankAccount bankAccount) {
        return bankAccountDao.update(bankAccount);
    }

    /**
     * 5. If a current transaction exists, first Spring suspends it, and then the business logic is executed without a transaction.
     *
     * @param bankAccount bank account to update
     * @return updated bank account
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public BankAccount updateWithNotSupported(BankAccount bankAccount) {
        return bankAccountDao.update(bankAccount);
    }

    /**
     * 6. When the propagation is REQUIRES_NEW, Spring suspends the current transaction if it exists, and then creates a new one.
     *
     * @param bankAccount bank account to update
     * @return updated bank account
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BankAccount updateWithRequiresNew(BankAccount bankAccount) {
        return bankAccountDao.update(bankAccount);
    }

    /**
     * 7. For NESTED propagation, Spring checks if a transaction exists, and if so, it marks a save point.
     * This means that if our business logic execution throws an exception, then the transaction rollbacks to this save point.
     * If there's no active transaction, it works like REQUIRED.
     *
     * @param bankAccount bank account to update
     * @return updated bank account
     */
    @Override
    @Transactional(propagation = Propagation.NESTED)
    public BankAccount updateWithNested(BankAccount bankAccount) {
        return bankAccountDao.update(bankAccount);
    }
}
