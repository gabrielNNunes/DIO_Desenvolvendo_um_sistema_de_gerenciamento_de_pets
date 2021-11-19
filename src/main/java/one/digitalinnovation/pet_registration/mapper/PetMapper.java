package one.digitalinnovation.pet_registration.mapper;

import one.digitalinnovation.pet_registration.dto.request.PetDTO;
import one.digitalinnovation.pet_registration.entity.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PetMapper {

    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Pet toModel(PetDTO petDTO);

    PetDTO toDTO(Pet pet);
}
