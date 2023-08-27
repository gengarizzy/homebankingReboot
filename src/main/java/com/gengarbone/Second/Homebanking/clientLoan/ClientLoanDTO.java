package com.gengarbone.Second.Homebanking.clientLoan;

public class ClientLoanDTO {
    private Long id;
    private Long loanId;
    private String name;
    private int payments;
    private Double amount;

    public ClientLoanDTO(){}

    public ClientLoanDTO(ClientLoan clientLoan){

        id = clientLoan.getId();

        loanId = clientLoan.getLoan().getId();

        name = clientLoan.getLoan().getName();

        amount = clientLoan.getAmount();

        payments = clientLoan.getPayments();

    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getAmount() {
        return amount;
    }
    public int getPayments() {
        return payments;
    }

    public Long getLoanId() {
        return loanId;
    }
}