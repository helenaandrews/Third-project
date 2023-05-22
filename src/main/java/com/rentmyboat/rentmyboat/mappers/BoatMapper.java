package com.rentmyboat.rentmyboat.mappers;

import com.rentmyboat.rentmyboat.dto.BoatCategoryDto;
import com.rentmyboat.rentmyboat.dto.BoatCreateDto;
import com.rentmyboat.rentmyboat.dto.BoatDto;
import com.rentmyboat.rentmyboat.dto.BoatTypeDto;
import com.rentmyboat.rentmyboat.dto.BoatUpdateDto;
import com.rentmyboat.rentmyboat.dto.WithCaptainDto;
import com.rentmyboat.rentmyboat.model.Boat;
import com.rentmyboat.rentmyboat.model.BoatCategory;
import com.rentmyboat.rentmyboat.model.BoatType;
import com.rentmyboat.rentmyboat.model.WithCaptain;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BoatMapper {

    BoatMapper INSTANCE = Mappers.getMapper(BoatMapper.class);

    @Mapping(source = "boatCategory.id", target = "boatCategoryId")
    @Mapping(source = "boatType.id", target = "boatTypeId")
    @Mapping(source = "withCaptain.id", target = "withCaptain")
    @Mapping(source = "user.id", target = "userId")
    BoatDto toDto(Boat boat);

    @Mapping(source = "boatCategory.id", target = "boatCategoryId")
    @Mapping(source = "boatType.id", target = "boatTypeId")
    @Mapping(source = "withCaptain.id", target = "withCaptain")
    @Mapping(source = "user.id", target = "userId")
    List<BoatDto> toDto(List<Boat> boat);

    BoatTypeDto boatTypeToDto(BoatType boatType);
    BoatCategoryDto boatCategoryToDto(BoatCategory boatCategory);
    WithCaptainDto withCaptainToDto(WithCaptain withCaptain);

    @Mapping(source = "boatCategoryId", target = "boatCategory.id")
    @Mapping(source = "boatTypeId", target = "boatType.id")
    @Mapping(source = "withCaptain", target = "withCaptain.id")
    @Mapping(source = "userId", target = "user.id")
    Boat toEntity(BoatDto boatDto);

    @Mapping(source = "boatCategoryId", target = "boatCategory.id")
    @Mapping(source = "boatTypeId", target = "boatType.id")
    @Mapping(source = "withCaptain", target = "withCaptain.id")
    @Mapping(source = "userId", target = "user.id")
    Boat toEntity(BoatCreateDto boatCreateDto);

    @Mapping(source = "boatCategoryId", target = "boatCategory.id")
    @Mapping(source = "boatTypeId", target = "boatType.id")
    @Mapping(source = "withCaptain", target = "withCaptain.id")
    @Mapping(source = "userId", target = "user.id")
    Boat toEntity(BoatUpdateDto boatUpdateDto);

    @Mapping(source = "boatCategoryId", target = "boatCategory.id")
    @Mapping(source = "boatTypeId", target = "boatType.id")
    @Mapping(source = "withCaptain", target = "withCaptain.id")
    @Mapping(source = "userId", target = "user.id")
    List<Boat> toEntity(List<BoatDto> boatDto);

    BoatType boatTypeToEntity(BoatTypeDto boatTypeDto);
    BoatCategory boatCategoryToEntity(BoatCategoryDto boatCategoryDto);
    WithCaptain withCaptainToEntity(WithCaptainDto withCaptainDto);
}
