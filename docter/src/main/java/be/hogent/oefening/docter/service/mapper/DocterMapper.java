package be.hogent.oefening.docter.service.mapper;

import be.hogent.oefening.docter.business.DocterEntity;
import be.hogent.oefening.docter.service.dto.Docter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DocterMapper {

    @Mappings({
            @Mapping(target = "appointementDate", dateFormat = "dd/MM/yyyy")
    })
    DocterEntity toEntity(Docter docter);

    @Mappings({
            @Mapping(target = "appointementDate", dateFormat = "dd/MM/yyyy")
    })
    Docter toDTO(DocterEntity docterEntity);

}
