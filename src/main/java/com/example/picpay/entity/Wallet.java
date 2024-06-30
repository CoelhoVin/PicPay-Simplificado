package com.example.picpay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_wallet")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "cpf_cpnj", unique = true)
    private String cpfCnpj;

    @Column(name ="email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "wallet_type_id")
    private WalletType walletType;


    @PrePersist
    @PreUpdate
    private void setDefault(){
        if (this.balance == null){
            this.balance = BigDecimal.ZERO;
        }
    }

    public boolean isTransferAllowedForWalletType() {
        return this.walletType.equals(WalletType.Enum.USER.get());
    }

    public boolean isBalanceEqualOrGreaterThan(BigDecimal value) {
        return this.balance.doubleValue() > value.doubleValue();
    }

    public void debit(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }

    public void credit(BigDecimal value) {
        this.balance = this.balance.add(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && Objects.equals(fullName, wallet.fullName) && Objects.equals(cpfCnpj, wallet.cpfCnpj) && Objects.equals(email, wallet.email) && Objects.equals(password, wallet.password) && Objects.equals(balance, wallet.balance) && Objects.equals(walletType, wallet.walletType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, cpfCnpj, email, password, balance, walletType);
    }

}
