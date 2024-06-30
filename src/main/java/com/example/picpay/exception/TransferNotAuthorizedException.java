package com.example.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAuthorizedException extends PicPayException{
    @Override
    public ProblemDetail toProblemDetail() {

        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Transfer Not Authorized");
        problemDetail.setDetail("Authorization Service did not authorize this transfer.");
        return problemDetail;
    }
}
