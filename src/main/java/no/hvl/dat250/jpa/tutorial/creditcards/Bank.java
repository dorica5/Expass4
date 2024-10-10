package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.*;

@Entity

public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "bank")
    private Set<CreditCard> creditCards;
    public Bank(String name){
        this.name = name;
        this.creditCards = new HashSet<>();
    }
    public Bank(){}


    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public Collection<CreditCard> getOwnedCards() {
        return this.creditCards;
    }
}
