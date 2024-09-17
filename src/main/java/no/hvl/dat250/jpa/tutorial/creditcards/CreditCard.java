package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer creditLimit;
    private Integer balance;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Bank bank;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Pincode pincode;


    public CreditCard(Integer number, Integer creditLimit, Integer balance){
        this.number = number;
        this.creditLimit = creditLimit;
        this.balance = balance;
    }

    public CreditCard(){}

    public Integer getNumber() {
        return this.number;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public Integer getCreditLimit() {
        return this.creditLimit;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public Pincode getPincode() {
        return this.pincode;
    }

    public Bank getOwningBank() {
        return this.bank;
    }
}
