package com.rentmyboat.rentmyboat.services;

import com.rentmyboat.rentmyboat.dto.BoatDto;
import com.rentmyboat.rentmyboat.mappers.BoatMapper;
import com.rentmyboat.rentmyboat.model.Boat;
import com.rentmyboat.rentmyboat.model.BoatCategory;
import com.rentmyboat.rentmyboat.model.BoatType;
import com.rentmyboat.rentmyboat.model.Gender;
import com.rentmyboat.rentmyboat.model.Users;
import com.rentmyboat.rentmyboat.model.WithCaptain;
import com.rentmyboat.rentmyboat.repository.BoatRepository;
import com.rentmyboat.rentmyboat.service.BoatServiceImpl;
import liquibase.ui.UIService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BoatServiceTest {

    @Mock
    private BoatRepository boatRepository;

    @InjectMocks
    private BoatServiceImpl boatService;

    private Boat boat;

    @BeforeEach
    public void setBoat() {
        Users user = Users.builder()
                .id(1L)
                .isActive(true)
                .firstName("First")
                .lastName("Last")
                .gender(new Gender(1L, "male"))
                .email("Test@test.test")
                .phoneNumber("+123456789")
                .photoLink("123")
                .birthDate(new Timestamp(2000382088))
                .postalCode("1111")
                .country("Russia")
                .city("Moscow")
                .resume(null)
                .bookings(null)
                .build();

        boat = Boat.builder()
                .id(1L)
                .user(user)
                .boatType(new BoatType(1L, "boatType1"))
                .boatCategory(new BoatCategory(1L, "boatCategory1"))
                .length(123.0)
                .cabins(2)
                .beds(4)
                .people(6)
                .capacity(1000L)
                .enginePower(1000L)
                .manufacturer("Manufacturer")
                .year(1970)
                .model("New model")
                .portAddress("address")
                .weekPrice(156.0)
                .dayPrice(12.3)
                .captainSalaryPerDay(null)
                .withCaptain(new WithCaptain(1L, "yes"))
                .hasEngine(true)
                .hasSail(false)
                .requiredLicense("license")
                .build();
    }

    @Test
    public void testGetBoatById() {
        when(boatRepository.findById(boat.getId())).thenReturn(Optional.of(boat));

        BoatDto boatDto = boatService.getBoatById(boat.getId());

        verify(boatRepository).findById(boat.getId());

        Assertions.assertEquals(BoatMapper.INSTANCE.toDto(boat), boatDto);
    }

}
