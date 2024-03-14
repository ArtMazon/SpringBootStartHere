package com.springpractice.chapter14exercise.services;

import com.springpractice.chapter14exercise.model.Account;
import com.springpractice.chapter14exercise.model.AccountNotFoundException;
import com.springpractice.chapter14exercise.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(
            long idSender,
            long idReceiver,
            BigDecimal amount

    ){
        Account accountSender = accountRepository
                .findById(idSender)
                .orElseThrow(()-> new AccountNotFoundException());

        Account accountReceiver = accountRepository
                .findById(idReceiver)
                .orElseThrow(()-> new AccountNotFoundException());

        BigDecimal senderNewAmount = accountSender.getAmount().subtract(amount);

        BigDecimal receiverNewAmount = accountReceiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender,senderNewAmount);
        accountRepository.changeAmount(idReceiver,receiverNewAmount);
        


    }

    public List<Account> findAccountByName(String name){
        return accountRepository.findAccountsByName(name);
    }


    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();

    }
}
