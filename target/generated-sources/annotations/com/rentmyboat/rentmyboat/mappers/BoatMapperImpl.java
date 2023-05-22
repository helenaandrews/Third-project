package com.rentmyboat.rentmyboat.mappers;

import com.rentmyboat.rentmyboat.dto.BoatCategoryDto;
import com.rentmyboat.rentmyboat.dto.BoatCategoryDto.BoatCategoryDtoBuilder;
import com.rentmyboat.rentmyboat.dto.BoatDto;
import com.rentmyboat.rentmyboat.dto.BoatDto.BoatDtoBuilder;
import com.rentmyboat.rentmyboat.dto.BoatTypeDto;
import com.rentmyboat.rentmyboat.dto.BoatTypeDto.BoatTypeDtoBuilder;
import com.rentmyboat.rentmyboat.model.Boat;
import com.rentmyboat.rentmyboat.model.Boat.BoatBuilder;
import com.rentmyboat.rentmyboat.model.Boat.WithCaptain;
import com.rentmyboat.rentmyboat.model.BoatCategory;
import com.rentmyboat.rentmyboat.model.BoatCategory.BoatCategoryBuilder;
import com.rentmyboat.rentmyboat.model.BoatType;
import com.rentmyboat.rentmyboat.model.BoatType.BoatTypeBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-19T17:31:00+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class BoatMapperImpl implements BoatMapper {

    @Override
    public BoatDto toDto(Boat boat) {
        if ( boat == null ) {
            return null;
        }

        BoatDtoBuilder boatDto = BoatDto.builder();

        boatDto.id( boat.getId() );
        boatDto.length( boat.getLength() );
        boatDto.cabins( boat.getCabins() );
        boatDto.beds( boat.getBeds() );
        boatDto.people( boat.getPeople() );
        boatDto.capacity( boat.getCapacity() );
        boatDto.enginePower( boat.getEnginePower() );
        boatDto.year( boat.getYear() );
        boatDto.manufacturer( boat.getManufacturer() );
        boatDto.model( boat.getModel() );
        boatDto.portAddress( boat.getPortAddress() );
        boatDto.weekPrice( boat.getWeekPrice() );
        boatDto.captainSalaryPerDay( boat.getCaptainSalaryPerDay() );
        if ( boat.getWithCaptain() != null ) {
            boatDto.withCaptain( boat.getWithCaptain().name() );
        }
        boatDto.hasEngine( boat.isHasEngine() );
        boatDto.hasSail( boat.isHasSail() );
        boatDto.photoLinks( boat.getPhotoLinks() );
        boatDto.requiredLicense( boat.getRequiredLicense() );

        return boatDto.build();
    }

    @Override
    public BoatTypeDto boatTypeToDto(BoatType boatType) {
        if ( boatType == null ) {
            return null;
        }

        BoatTypeDtoBuilder boatTypeDto = BoatTypeDto.builder();

        boatTypeDto.id( boatType.getId() );
        boatTypeDto.name( boatType.getName() );

        return boatTypeDto.build();
    }

    @Override
    public BoatCategoryDto boatCategoryToDto(BoatCategory boatCategory) {
        if ( boatCategory == null ) {
            return null;
        }

        BoatCategoryDtoBuilder boatCategoryDto = BoatCategoryDto.builder();

        boatCategoryDto.id( boatCategory.getId() );
        boatCategoryDto.name( boatCategory.getName() );

        return boatCategoryDto.build();
    }

    @Override
    public Boat toEntity(BoatDto boatDto) {
        if ( boatDto == null ) {
            return null;
        }

        BoatBuilder boat = Boat.builder();

        boat.id( boatDto.getId() );
        boat.length( boatDto.getLength() );
        boat.cabins( boatDto.getCabins() );
        boat.beds( boatDto.getBeds() );
        boat.people( boatDto.getPeople() );
        boat.capacity( boatDto.getCapacity() );
        boat.enginePower( boatDto.getEnginePower() );
        boat.year( boatDto.getYear() );
        boat.manufacturer( boatDto.getManufacturer() );
        boat.model( boatDto.getModel() );
        boat.portAddress( boatDto.getPortAddress() );
        boat.weekPrice( boatDto.getWeekPrice() );
        boat.captainSalaryPerDay( boatDto.getCaptainSalaryPerDay() );
        if ( boatDto.getWithCaptain() != null ) {
            boat.withCaptain( Enum.valueOf( WithCaptain.class, boatDto.getWithCaptain() ) );
        }
        boat.hasEngine( boatDto.isHasEngine() );
        boat.hasSail( boatDto.isHasSail() );
        boat.photoLinks( boatDto.getPhotoLinks() );
        boat.requiredLicense( boatDto.getRequiredLicense() );

        return boat.build();
    }

    @Override
    public BoatType boatTypeToEntity(BoatTypeDto boatTypeDto) {
        if ( boatTypeDto == null ) {
            return null;
        }

        BoatTypeBuilder boatType = BoatType.builder();

        boatType.id( boatTypeDto.getId() );
        boatType.name( boatTypeDto.getName() );

        return boatType.build();
    }

    @Override
    public BoatCategory boatCategoryToEntity(BoatCategoryDto boatCategoryDto) {
        if ( boatCategoryDto == null ) {
            return null;
        }

        BoatCategoryBuilder boatCategory = BoatCategory.builder();

        boatCategory.id( boatCategoryDto.getId() );
        boatCategory.name( boatCategoryDto.getName() );

        return boatCategory.build();
    }
}
