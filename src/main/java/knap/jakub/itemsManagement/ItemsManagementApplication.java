package knap.jakub.itemsManagement;

import knap.jakub.itemsManagement.model.AppUser;
import knap.jakub.itemsManagement.repository.AppUserRepository;
import knap.jakub.itemsManagement.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ItemsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemsManagementApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(AppUserService userService, AppUserRepository userRepository) {
        return args -> {
            userService.registerUser(new AppUser(null, "test", "test"));
        };
    }

}
