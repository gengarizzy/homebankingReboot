package com.gengarbone.Second.Homebanking.client;

import com.gengarbone.Second.Homebanking.account.Account;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

//PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;



    //VINCULACIONES

    @OneToMany(mappedBy="client", fetch= FetchType.LAZY) //VINCULACION CON LA TABLA
    Set<Account> accounts = new HashSet<>(); // COLECCION PARA CONTENER LAS
    // CUENTAS QUE PERTENECEN A UN CLIENT



//CONSTRUCTORS
    public Client() {
    }

    public Client(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }







//GETTERS AND SETTERS
    public Long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //Getter de la coleccion de cuentas
    public Set<Account> getAccounts() {
        return accounts;
    } //GETTER DE LA COLECCION DE ACCOUNTS PERTENECIENTES AL CLIENT


    //Setter para agregar cuentas a clientes, guardandolas en la coleccion Account
    public void addAccount(Account account) {
        account.setClient(this);
        this.accounts.add(account);
    }





}
