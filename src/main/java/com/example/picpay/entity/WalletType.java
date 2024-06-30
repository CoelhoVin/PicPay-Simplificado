package com.example.picpay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_wallet_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;


    @Getter
    @AllArgsConstructor
    public enum Enum {
        USER(1L, "user"),
        MERCHANT(2L, "merchant");

        private Long id;
        private String description;

        public WalletType get(){
            return new WalletType(id, description);
        }
    }
}
