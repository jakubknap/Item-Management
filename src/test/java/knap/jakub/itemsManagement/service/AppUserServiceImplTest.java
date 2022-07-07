package knap.jakub.itemsManagement.service;

import knap.jakub.itemsManagement.model.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AppUserServiceImplTest {
    @Autowired
    private AppUserService userService;

    @Test
    void shouldRegisterUser() {
        AppUser user = userService.registerUser(new AppUser(null, "testTo", "password"));
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("testTo");
    }

    @Test
    void shouldNotRegisterUser() {
        AppUser user = userService.registerUser(new AppUser(null, "test", "password"));
        assertThat(user).isNull();
    }

    @Test
    void shouldUserExist() {
        AppUser user = userService.registerUser(new AppUser(null, "testToTest", "password"));
        boolean userExist = userService.userExist(user.getUsername());
        assertThat(userExist).isTrue();
    }

    @Test
    void shouldUserDoesntExist() {
        boolean userExist = userService.userExist("testUser");
        assertThat(userExist).isFalse();
    }

}