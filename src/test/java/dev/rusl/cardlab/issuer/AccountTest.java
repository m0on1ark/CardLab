package dev.rusl.cardlab.issuer;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void rejectsAmountWithMoreThanTwoDecimals() {
        BigDecimal amount = new BigDecimal("10.005");

        assertThrows(IllegalArgumentException.class,
                () -> new Account("Ruslan", "PLN", amount));
    }
    @Test
    void createsAccountWithValidData() {
        Account test = new Account("Ruslan", "PLN", new BigDecimal("100.00"));
        assertEquals("Ruslan", test.getHolderName());
        assertEquals("PLN", test.getCurrency());
        assertEquals(new BigDecimal("100.00"), test.getAvailableBalance());
        assertNotNull(test.getCreatedAt());
    }

    @Test
    void rejectsCurrencyLongerThanThreeLetters() {

        assertThrows(IllegalArgumentException.class,
        () -> new Account("Ruslan", "EURO", new BigDecimal("100.00")));

    }
    @Test
    void rejectsLowercaseCurrency() {
        assertThrows(IllegalArgumentException.class,
                () -> new Account("Ruslan", "pln", new BigDecimal("100.00")));

    }
    @Test
    void rejectsNegativeBalance() {
        assertThrows(IllegalArgumentException.class,
                () -> new Account("Ruslan", "PLN", new BigDecimal("-1.00")));

    }
    @Test
    void normalizeBalanceToTwoDecimals() {
        Account test = new Account("Ruslan", "PLN", new BigDecimal("10"));
        assertEquals(new BigDecimal("10.00"), test.getAvailableBalance());

    }

}