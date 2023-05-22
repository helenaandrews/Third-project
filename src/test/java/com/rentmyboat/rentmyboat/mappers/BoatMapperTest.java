package com.rentmyboat.rentmyboat.mappers;

import com.rentmyboat.rentmyboat.dto.BoatCategoryDto;
import com.rentmyboat.rentmyboat.dto.BoatDto;
import com.rentmyboat.rentmyboat.dto.BoatTypeDto;
import com.rentmyboat.rentmyboat.model.Boat;
import com.rentmyboat.rentmyboat.model.BoatCategory;
import com.rentmyboat.rentmyboat.model.BoatType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BoatMapperTest {

    @Test
    @DisplayName("Convert from Entity to Dto")
    public void mapperToDto() {

        //given
        Boat boat = new Boat();
        boat.setCabins(2);
        boat.setModel("model");

        //when
        BoatDto boatDto = BoatMapper.INSTANCE.toDto(boat);

        //then
        assertNotNull(boat);
        assertEquals(2, boatDto.getCabins());
        assertEquals("model", boatDto.getModel());

    }

    @Test
    @DisplayName("Convert from Dto to Entity")
    public void mapperToEntity() {

        //given
        BoatDto boatDto = new BoatDto();
        boatDto.setEnginePower(60L);
        boatDto.setPeople(6);

        //when
        Boat boat = BoatMapper.INSTANCE.toEntity(boatDto);

        //then
        assertNotNull(boat);
        assertEquals(60L, boat.getEnginePower());
        assertEquals(6, boat.getPeople());
    }
}