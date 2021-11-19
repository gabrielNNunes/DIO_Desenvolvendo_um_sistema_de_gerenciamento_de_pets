package one.digitalinnovation.pet_registration.service;

import one.digitalinnovation.pet_registration.dto.request.PetDTO;
import one.digitalinnovation.pet_registration.dto.response.MessageResponseDTO;
import one.digitalinnovation.pet_registration.entity.Pet;
import one.digitalinnovation.pet_registration.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.pet_registration.utils.PetUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetService petService;

    @Test
    void testGivenPetDTOThenReturnSavedMessage() {
        PetDTO petDTO = createFakeDTO();
        Pet expectedSavedPet = createFakeEntity();

        when(petRepository.save(any(Pet.class))).thenReturn(expectedSavedPet);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPet.getId());
        MessageResponseDTO succesMessage = petService.createPet(petDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created pet with ID " + id)
                .build();
    }
}
