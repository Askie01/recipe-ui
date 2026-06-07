package org.askiesolutions.recipeuiservice;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RecipeUiServiceApplication {
    static void main(String[] args) {
        SpringApplication.run(RecipeUiServiceApplication.class, args);
    }
}
