package sia.staybook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sia.staybook.data.entity.User;
import sia.staybook.data.repository.UserRepository;
import sia.staybook.dto.LoginRequestDto;
import sia.staybook.dto.RegistrationRequestDto;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public void register(RegistrationRequestDto registrationRequestDto) {

        if (userRepo.existsByEmail(registrationRequestDto.getEmail())) {
            throw new RuntimeException("Email is repetitive!");
        }
        User user = new User(
                registrationRequestDto.getEmail(),
                passwordEncoder.encode(registrationRequestDto.getPassword()),
                registrationRequestDto.getFullName(),
                registrationRequestDto.getPhone(),
                User.Role.USER
        );
        userRepo.save(user);
    }
}
