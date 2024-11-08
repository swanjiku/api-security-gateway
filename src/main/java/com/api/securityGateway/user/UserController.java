package com.api.securityGateway.user;

import com.api.securityGateway.auth.AuthenticationService;
import com.api.securityGateway.util.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Users")
public class UserController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        ApiResponse<?> response = userService.getAllUsers();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(Principal principal) {
        ApiResponse<?> response = userService.getUserProfile(principal);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
