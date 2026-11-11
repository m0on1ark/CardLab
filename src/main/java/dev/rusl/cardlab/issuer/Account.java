package dev.rusl.cardlab.issuer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Locale;
import java.util.UUID;

@Entity
@Table(name = "accounts")
class Account {
    @Id
    private UUID id;
    private String holderName;
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 3)
    private String currency;
    private BigDecimal availableBalance;
    private Instant createdAt;

    Account(String holderName, String currency, BigDecimal initialBalance) {
        if (holderName == null || currency == null || initialBalance == null){
            throw new  IllegalArgumentException("Arguments cant be null");
        }
        if ( !currency.matches("[A-Z]{3}")){
            throw new IllegalArgumentException("currency must be 3 char");
        }
        if (initialBalance.compareTo(BigDecimal.ZERO) < 0  || initialBalance.scale() > 2){
            throw new IllegalArgumentException("Invalid money input");
        }
        id = UUID.randomUUID();
        this.holderName = holderName;
        this.currency = currency;
        this.availableBalance = initialBalance.setScale(2, RoundingMode.UNNECESSARY);
        createdAt = Instant.now();

    }

    protected Account() {

    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public String getHolderName() {
        return holderName;
    }

    public UUID getId() {
        return id;
    }

}
