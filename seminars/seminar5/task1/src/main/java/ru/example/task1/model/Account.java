package ru.example.task1.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

//@Data
public class Account {
    @Id
    private long id;

    private String name;
    private BigDecimal amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
