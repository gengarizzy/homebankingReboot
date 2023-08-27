package com.gengarbone.Second.Homebanking.transaction;


import java.time.LocalDate;

public class TransactionDTO {

//VARIABLES

    private Long id;
    private TransactionType type;
    private Double amount;
    private String description;
    private LocalDate date;

    //CONSTRUCTOR
    public TransactionDTO(Transaction transaction){
        this.id = transaction.getId();
        this.type = transaction.getType();
        this.amount = transaction.getAmount();
        this.date = transaction.getDate();
        this.description = transaction.getDescription();
//EL CONSTRUCTOR QUE RECIBE A TRANSACTION BRINDA LOS GETTERS PARA PERMITIR ACCEDER A LA INFO

    }

    //GETTERS. UN DTO SOLO TIENE GETTERS
    public Long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }
}