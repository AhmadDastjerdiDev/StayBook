package sia.staybook.service;

import sia.staybook.dto.RegistrationRequestDto;

public interface AuthService {
    public void register(RegistrationRequestDto registrationRequestDto);
}
