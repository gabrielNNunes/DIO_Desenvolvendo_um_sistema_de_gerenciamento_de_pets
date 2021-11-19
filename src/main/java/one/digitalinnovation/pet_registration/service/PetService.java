package one.digitalinnovation.pet_registration.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.pet_registration.dto.request.PetDTO;
import one.digitalinnovation.pet_registration.dto.response.MessageResponseDTO;
import one.digitalinnovation.pet_registration.entity.Pet;
import one.digitalinnovation.pet_registration.exception.PetNotFoundException;
import one.digitalinnovation.pet_registration.mapper.PetMapper;
import one.digitalinnovation.pet_registration.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetService {

    private PetRepository petRepository;

    private final PetMapper petMapper = PetMapper.INSTANCE;

    public MessageResponseDTO createPet(PetDTO petDTO) {
        Pet petToSave = petMapper.toModel(petDTO);

        Pet savedPet = petRepository.save(petToSave);
        return createMessageResponse(savedPet.getId(), "Created pet with ID ");
    }

    public List<PetDTO> listAll() {
        List<Pet> allPeople = petRepository.findAll();
        return allPeople.stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PetDTO findById(Long id) throws PetNotFoundException {
        Pet pet = verifyIfExists(id);

        return petMapper.toDTO(pet);
    }

    public void delete(Long id) throws PetNotFoundException {
        verifyIfExists(id);
        petRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PetDTO petDTO) throws PetNotFoundException {
        verifyIfExists(id);

        Pet petToUpdate = petMapper.toModel(petDTO);

        Pet updatedPet = petRepository.save(petToUpdate);
        return createMessageResponse(updatedPet.getId(), "Updated pet with ID ");
    }

    private Pet verifyIfExists(Long id) throws PetNotFoundException {
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
