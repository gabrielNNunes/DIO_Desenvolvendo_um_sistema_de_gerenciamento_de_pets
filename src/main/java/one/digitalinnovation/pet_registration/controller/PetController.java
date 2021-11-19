package one.digitalinnovation.pet_registration.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.pet_registration.dto.request.PetDTO;
import one.digitalinnovation.pet_registration.dto.response.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import one.digitalinnovation.pet_registration.service.PetService;
import one.digitalinnovation.pet_registration.exception.PetNotFoundException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pet")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetController {

    private final PetService petService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPet(@RequestBody @Valid PetDTO petDTO) {
        return petService.createPet(petDTO);
    }

    @GetMapping
    public List<PetDTO> listAll() {
        return petService.listAll();
    }

    @GetMapping("/{id}")
    public PetDTO findById(@PathVariable Long id) throws PetNotFoundException {
        return petService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PetDTO petDTO) throws PetNotFoundException {
        return petService.updateById(id, petDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PetNotFoundException {
        petService.delete(id);
    }
}
