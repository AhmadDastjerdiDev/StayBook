package sia.staybook.web.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sia.staybook.dto.RegistrationRequestDto;
import sia.staybook.service.AuthService;

@RestController
@RequestMapping("api/auth")
public class RegistrationController {

    private AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegistrationRequestDto dto){
        authService.register(dto);
    }
}
