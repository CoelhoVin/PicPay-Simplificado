package com.example.picpay.service;

import com.example.picpay.controller.dto.TransferDTO;
import com.example.picpay.entity.Transfer;
import com.example.picpay.entity.Wallet;
import com.example.picpay.exception.InsufficientBalanceException;
import com.example.picpay.exception.TransferNotAllowedForWalletTypeException;
import com.example.picpay.exception.TransferNotAuthorizedException;
import com.example.picpay.exception.WalletNotFoundException;
import com.example.picpay.repository.TransferRepository;
import com.example.picpay.repository.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;

    private final WalletRepository walletRepository;

    private final AuthorizationService authorizationService;

    private final NotificationService notificationService;

    @Transactional
    public Transfer transfer(TransferDTO transferDTO){

        var sender = walletRepository.findById(transferDTO.payer()).orElseThrow(() -> new WalletNotFoundException(transferDTO.payer()));
        var receiver = walletRepository.findById(transferDTO.payee()).orElseThrow(() -> new WalletNotFoundException(transferDTO.payee()));

        validateTransfer(transferDTO, sender);

        sender.debit(transferDTO.value());
        receiver.credit(transferDTO.value());

        var transfer = Transfer.builder()
                .sender(sender)
                .receiver(receiver)
                .value(transferDTO.value())
                .build();

        walletRepository.save(sender);
        walletRepository.save(receiver);
        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));

        return transferResult;
    }

    private void validateTransfer(TransferDTO transferDTO, Wallet sender) {

        if (!sender.isTransferAllowedForWalletType()){
            throw new TransferNotAllowedForWalletTypeException();
        }

        if (!sender.isBalanceEqualOrGreaterThan(transferDTO.value())){
            throw new InsufficientBalanceException();
        }

        if (!authorizationService.isAuthorized(transferDTO)){
            throw new TransferNotAuthorizedException();
        }

    }
}
