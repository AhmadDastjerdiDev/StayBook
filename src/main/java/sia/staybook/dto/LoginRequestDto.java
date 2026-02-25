package sia.staybook.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequestDto {

    @Email
    @NotNull
    private String email;

    @NotNull
    @Size(min = 8, max = 24)
    private String password;

}
