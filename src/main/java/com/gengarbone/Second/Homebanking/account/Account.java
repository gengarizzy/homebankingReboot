package com.gengarbone.Second.Homebanking.account;

import com.gengarbone.Second.Homebanking.client.Client;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Account {

    //PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String accountNumber;
    private LocalDate date;
    private double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id")
    private Client client;
    //VINCULO UN ACCOUNT A LA TABLA DE CLIENT MEDIANTE JOINCOLUMN Y LA RELACION MUCHOS A UNO.
    //La relacion entre accounts y clientes es de muchos a uno. Muchas accounts a un solo client



    //CONSTRUCTORS


    public Account() {
    }


    //Uso un constructor que solo tome la fecha y el balanze
    //Ya que pretendo generar automaticamente el numero de cuenta y asignar manualmente el cliente
    public Account(LocalDate date, double balance) {
        this.date = date;
        this.balance = balance;
    }





    //GETTERS AND SETTERS


    public Long getId() {
        return id;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
