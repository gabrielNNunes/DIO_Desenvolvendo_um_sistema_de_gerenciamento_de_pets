package one.digitalinnovation.pet_registration.utils;

import one.digitalinnovation.pet_registration.dto.request.PetDTO;
import one.digitalinnovation.pet_registration.entity.Pet;

import java.time.LocalDate;
import java.util.Collections;

public class PetUtils {

    private static final String PETs_NAME = "Thomas Edson";
    private static final String PET_OWERs_NAME = "Gabriel Nascimento Nunes";
    private static final String PET_OWERs_CPF_NUMBER = "123.123.543-11";
    private static final long PET_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PetDTO createFakeDTO() {
        return PetDTO.builder()
                .petsName(PETs_NAME)
                .petOwnersName(PET_OWERs_NAME)
                .petOwnersCPF(PET_OWERs_CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Pet createFakeEntity() {
        return Pet.builder()
                .id(PET_ID)
                .petsName(PETs_NAME)
                .petOwnersName(PET_OWERs_NAME)
                .petOwnersCPF(PET_OWERs_CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
