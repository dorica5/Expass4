package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Address> addresses;
    @ManyToMany
    private Set<CreditCard> creditCards;
    public Customer(String name){
        this.name = name;
        this.addresses = new ArrayList<>();
        this.creditCards = new HashSet<>();
    }

    public Customer() {

    }

    public String getName() {

        return this.name;
    }

    public Collection<Address> getAddresses() {
        return this.addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        return this.creditCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
