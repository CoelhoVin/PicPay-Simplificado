package com.example.picpay.service;

import com.example.picpay.client.AuthorizationClient;
import com.example.picpay.controller.dto.TransferDTO;
import com.example.picpay.entity.Transfer;
import com.example.picpay.exception.PicPayException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService {
    private final AuthorizationClient authorizationClient;

    public boolean isAuthorized(TransferDTO transferDTO) {

        var response = authorizationClient.isAuthorized();
        if (response.getStatusCode().isError()){
            throw new PicPayException();
        }
        return response.getBody().authorized();
    }
}
