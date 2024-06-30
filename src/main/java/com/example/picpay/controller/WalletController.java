package com.example.picpay.controller;

import com.example.picpay.controller.dto.CreateWalletDTO;
import com.example.picpay.entity.Wallet;
import com.example.picpay.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDTO createWalletDTO){

        var wallet = walletService.createWallet(createWalletDTO);
        return ResponseEntity.ok(wallet);
    }

}
