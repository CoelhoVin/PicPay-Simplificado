package com.example.picpay.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletDataAlreadyExistsException extends PicPayException{

    private String details;

    public WalletDataAlreadyExistsException(String details) {
        this.details = details;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Wallet Data Already Exists");
        problemDetail.setDetail(details);
        return problemDetail;
    }
}
