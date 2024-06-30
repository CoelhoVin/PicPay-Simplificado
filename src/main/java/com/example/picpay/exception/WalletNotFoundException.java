package com.example.picpay.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletNotFoundException extends PicPayException{

    private Long walletId;

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Wallet not found");
        problemDetail.setDetail("There is no wallet with id: " + walletId);
        return super.toProblemDetail();
    }
}
