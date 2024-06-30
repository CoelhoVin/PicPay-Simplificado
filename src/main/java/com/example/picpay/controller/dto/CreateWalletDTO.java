package com.example.picpay.controller.dto;

import com.example.picpay.entity.Wallet;
import com.example.picpay.entity.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDTO(
        @NotBlank String fullName,
        @NotBlank String cpfCnpj,
        @NotBlank String email,
        @NotBlank String password,
        @NotNull WalletType.Enum walletType) {

    public Wallet toWallet() {
        return Wallet.builder()
                .fullName(fullName)
                .cpfCnpj(cpfCnpj)
                .email(email)
                .password(password)
                .walletType(walletType.get())
                .build();
    }


}
