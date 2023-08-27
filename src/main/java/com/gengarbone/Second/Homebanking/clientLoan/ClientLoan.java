package com.gengarbone.Second.Homebanking.clientLoan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gengarbone.Second.Homebanking.client.Client;
import com.gengarbone.Second.Homebanking.loan.Loan;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ClientLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private Double amount;
    private int payments; //La cantidad de cuotas. ESTOY TENIENDO PROBLEMAS PARA VISUALIZARLO.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loan_id")
    private Loan loan;

    public ClientLoan(){}

    public ClientLoan(Double amount, int payments, Client client, Loan loan) {
        this.amount = amount;
        this.payments = payments;
        this.client = client;
        this.loan = loan;
    }

    public Long getId() {
        return id;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double mount) {
        this.amount = mount;
    }
    public int getPayments() {
        return payments;
    }
    public void setPayments(int payments) {
        this.payments = payments;
    }

    @JsonIgnore
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @JsonIgnore
    public Loan getLoan() {return loan;}
    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}