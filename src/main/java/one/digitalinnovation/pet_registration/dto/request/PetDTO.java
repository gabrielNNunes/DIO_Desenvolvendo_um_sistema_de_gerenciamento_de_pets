package one.digitalinnovation.pet_registration.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String petsName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String petOwnersName;

    @NotEmpty
    @CPF
    private String petOwnersCPF;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;
}
