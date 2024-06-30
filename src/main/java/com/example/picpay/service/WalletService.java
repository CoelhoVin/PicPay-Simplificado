package com.example.picpay.service;

import com.example.picpay.controller.dto.CreateWalletDTO;
import com.example.picpay.entity.Wallet;
import com.example.picpay.exception.WalletDataAlreadyExistsException;
import com.example.picpay.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;


    public Wallet createWallet(CreateWalletDTO createWalletDTO) {

        var wallet = walletRepository.findByCpfCnpjOrEmail(createWalletDTO.cpfCnpj(), createWalletDTO.email());
        if (wallet.isPresent()){
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email Already Exists");
        }

        return walletRepository.save(createWalletDTO.toWallet());
    }
}
