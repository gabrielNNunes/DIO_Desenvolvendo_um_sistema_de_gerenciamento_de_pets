package one.digitalinnovation.pet_registration.repository;

import one.digitalinnovation.pet_registration.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
