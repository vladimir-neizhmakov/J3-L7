package ru.geekbrains.spring.university.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ProductError {
    private int status;
    private String message;
    private Date timestamp;

    public ProductError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
