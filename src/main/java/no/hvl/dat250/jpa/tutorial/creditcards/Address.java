package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> owners;
    private String street;
    private Integer number;


    public Address(String street, Integer number){
        this.street = street;
        this.number = number;
        this.owners = new HashSet<>();
    }
    public Address() {}

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }



    public Collection<Customer> getOwners() {
        return owners;
    }
}
