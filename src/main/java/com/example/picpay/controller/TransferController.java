package com.example.picpay.controller;

import com.example.picpay.controller.dto.TransferDTO;
import com.example.picpay.entity.Transfer;
import com.example.picpay.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDTO transferDTO){
        var response = transferService.transfer(transferDTO);
        return ResponseEntity.ok(response);
    }

}
