package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    // TODO: Create object world as shown in the README.md.
    Address address = new Address("Inndalsveien", 28);
    em.persist(address);

    Customer customer = new Customer("Max Mustermann");
    customer.getAddresses().add(address);
    address.getOwners().add(customer);

    Bank bank = new Bank("Pengebank");
    em.persist(bank);

    Pincode pincode = new Pincode("123", 1);
    em.persist(pincode);


    CreditCard creditCardOne = new CreditCard(12345, -10000, -5000);
    creditCardOne.setBank(bank);
    creditCardOne.setPincode(pincode);
    bank.getOwnedCards().add(creditCardOne);
    em.persist(creditCardOne);



    customer.getCreditCards().add(creditCardOne);


    CreditCard creditCardTwo = new CreditCard(123, 2000, 1);

    creditCardTwo.setPincode(pincode);
    creditCardTwo.setBank(bank);
    bank.getOwnedCards().add(creditCardTwo);
    em.persist(creditCardTwo);

    customer.getCreditCards().add(creditCardTwo);

    em.persist(customer);

  }
}
