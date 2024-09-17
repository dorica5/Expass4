package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String pincode;
    Integer count;
    public Pincode(String pincode, Integer count){
        this.pincode = pincode;
        this.count = count;
    }
    public Pincode(){};

    public Long getId() {
        return id;
    }

    public String getCode() {
        // TODO: implement method!
        return this.pincode;
    }

    public Integer getCount() {
        // TODO: implement method!
        return this.count;
    }
}
