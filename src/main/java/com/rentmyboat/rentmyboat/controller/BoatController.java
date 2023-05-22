package com.rentmyboat.rentmyboat.controller;

import com.rentmyboat.rentmyboat.dto.BoatCreateDto;
import com.rentmyboat.rentmyboat.dto.BoatDto;
import com.rentmyboat.rentmyboat.dto.BoatSearchDto;
import com.rentmyboat.rentmyboat.service.BoatService;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boat")
@RequiredArgsConstructor
@Tag(name = "Boat", description = "Boat API")
public class BoatController {

    private final BoatService boatService;

    @GetMapping
    @Operation(summary = "Получение всех лодок, которые есть в БД")
    List<BoatDto> getAllBoats() {
        return boatService.getAllBoats();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение лодки по ее id")
    BoatDto getBoatById(@PathVariable("id") Long id) {
        return boatService.getBoatById(id);
    }

    @PostMapping("/search")
    @Operation(summary = "Поиск лодки по параметрам")
    List<BoatDto> searchBoat(@RequestBody @Valid BoatSearchDto boatSearchDto) {
        return boatService.searchBoat(boatSearchDto);
    }

    @PostMapping
    @Operation(summary = "Добавление новой лодки в БД")
    BoatDto createBoat(@RequestBody @Valid BoatCreateDto boatCreateDto) {
        return boatService.createBoat(boatCreateDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменение существующей ложки")
    BoatDto createBoat(@PathVariable("id") Long id, @RequestBody @Valid BoatCreateDto boatCreateDto) {
        return boatService.updateBoat(id, boatCreateDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление лодки из БД")
    void deleteBoat(@PathVariable("id") Long id) {
        boatService.deleteBoat(id);
    }
}
