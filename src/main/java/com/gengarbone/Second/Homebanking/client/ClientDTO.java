package com.gengarbone.Second.Homebanking.client;

import com.gengarbone.Second.Homebanking.account.AccountDTO;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ClientDTO {

    //PROPERTIES
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    Set<AccountDTO> accounts = new HashSet<>();


    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.accounts = client.getAccounts().stream().map(AccountDTO::new).collect(toSet());

    }

    public Set<AccountDTO> getAccounts() { //COLECCION DE CUENTAS
        return accounts;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }


}
