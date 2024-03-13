package com.springpractice.exercisechapter13.services;

import com.springpractice.exercisechapter13.models.Account;
import com.springpractice.exercisechapter13.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    public void transferMoney(long idSender,
                              long idReceiver,
                              BigDecimal amount){
        Account sender = accountRepository.findAccountById(idSender);

        Account receiver = accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);

        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idReceiver,receiverNewAmount);
        accountRepository.changeAmount(idSender,senderNewAmount);

        throw new RuntimeException("Testing runtime exception rollback");




    }

    public List<Account> findAll(){

        return accountRepository.findAll();

    }


}
