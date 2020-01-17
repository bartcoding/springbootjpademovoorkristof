package be.intecbrussel.springbootjpademo;

import be.intecbrussel.springbootjpademo.repository.BeerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootjpademoApplication {

    public static void main(String[] args) {
      ApplicationContext context = SpringApplication.run(SpringbootjpademoApplication.class, args);
         context.getBean("beerrepo", BeerRepository.class)
                .findById(4)
                .ifPresent(System.out::println);

    }

}
