package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    CustomerRepository repository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        // save a couple of customers
        repository.save(new Customer("Umang", "Lohia"));
        repository.save(new Customer("Thakur", "Thakur"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer by ID
        Customer customer = repository.findOne(1L);
        System.out.println("Customer found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(customer);
        System.out.println();

        // fetch customers by last name
        System.out.println("Customer found with findByLastName('Thakur'):");
        System.out.println("--------------------------------------------");
        for (Customer bauer : repository.findByLastName("Thakur")) {
            System.out.println(bauer);
        }
    }

}
