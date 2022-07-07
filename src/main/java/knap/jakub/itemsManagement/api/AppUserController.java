package knap.jakub.itemsManagement.api;

import knap.jakub.itemsManagement.model.AppUser;
import knap.jakub.itemsManagement.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AppUser user) {
        if(!userService.userExist(user.getUsername())) {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/register").toUriString());
            return ResponseEntity
                    .created(uri)
                    .body(userService.registerUser(user));
        }
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("A user with this username already exists");
    }

    //Only for tests
    @GetMapping("/secured")
    public String securedTest(){
        return "secured";
    }

}
