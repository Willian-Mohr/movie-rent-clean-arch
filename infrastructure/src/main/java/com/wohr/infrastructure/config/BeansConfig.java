package com.wohr.infrastructure.config;

import com.wohr.application.services.CustomerServiceImpl;
import com.wohr.application.services.MovieServiceImpl;
import com.wohr.application.services.RentalServiceImpl;
import com.wohr.application.usecases.CustomerService;
import com.wohr.application.usecases.MovieService;
import com.wohr.application.usecases.RentalService;
import com.wohr.domain.repositories.CustomerRepository;
import com.wohr.domain.repositories.MovieRepository;
import com.wohr.domain.repositories.RentalRepository;
import com.wohr.infrastructure.persistence.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    // Repositórios (camada de infraestrutura)
    @Bean
    public MovieRepository movieRepository(MovieJpaRepository jpaRepository) {
        return new MovieRepositoryImpl(jpaRepository);
    }

    @Bean
    public CustomerRepository customerRepository(CustomerJpaRepository jpaRepository) {
        return new CustomerRepositoryImpl(jpaRepository);
    }

    @Bean
    public RentalRepository rentalRepository(RentalJpaRepository jpaRepository) {
        return new RentalRepositoryImpl(jpaRepository);
    }

    // Serviços (camada de aplicação)
    @Bean
    public MovieService movieService(MovieRepository movieRepository) {
        return new MovieServiceImpl(movieRepository);
    }

    @Bean
    public CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }

    @Bean
    public RentalService rentalService(
            RentalRepository rentalRepository,
            CustomerRepository customerRepository,
            MovieRepository movieRepository
    ) {
        return new RentalServiceImpl(rentalRepository, customerRepository, movieRepository);
    }
}
