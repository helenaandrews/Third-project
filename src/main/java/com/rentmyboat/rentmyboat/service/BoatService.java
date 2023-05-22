package com.rentmyboat.rentmyboat.service;
import com.rentmyboat.rentmyboat.dto.BoatCreateDto;
import com.rentmyboat.rentmyboat.dto.BoatDto;
import com.rentmyboat.rentmyboat.dto.BoatSearchDto;
import com.rentmyboat.rentmyboat.model.Boat;

import java.util.List;
public interface BoatService {
    List<BoatDto> getAllBoats();

    BoatDto getBoatById(Long id);

    List<BoatDto> searchBoat(BoatSearchDto boatSearchDto);

    BoatDto createBoat(BoatCreateDto boatCreateDto);

    void deleteBoat(Long id);

    BoatDto updateBoat(Long id, BoatCreateDto boatCreateDto);
}