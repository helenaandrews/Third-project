package com.rentmyboat.rentmyboat.service;

import com.rentmyboat.rentmyboat.dto.BoatCreateDto;
import com.rentmyboat.rentmyboat.dto.BoatDto;
import com.rentmyboat.rentmyboat.dto.BoatSearchDto;
import com.rentmyboat.rentmyboat.mappers.BoatMapper;
import com.rentmyboat.rentmyboat.mappers.BoatMapperImpl;
import com.rentmyboat.rentmyboat.model.Boat;
import com.rentmyboat.rentmyboat.model.BoatCategory;
import com.rentmyboat.rentmyboat.repository.BoatRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BoatServiceImpl implements BoatService {

    private final BoatRepository boatRepository;
    private final BoatMapper boatMapper;

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public BoatServiceImpl(BoatRepository boatRepository, EntityManagerFactory entityManagerFactory) {
        this.boatRepository = boatRepository;
        this.entityManagerFactory = entityManagerFactory;
        this.boatMapper = new BoatMapperImpl();
    }

    @Override
    public List<BoatDto> getAllBoats() {
        log.info("Get all boats");
        List<Boat> boats = boatRepository.findAll();

        log.info("found {} boats", boats.size());
        return boatMapper.toDto(boats);
    }

    @Override
    public BoatDto getBoatById(Long id) {
        Optional<Boat> boat = boatRepository.findById(id);
        if (boat.isPresent()) {
            log.info("Boat: {}" + boat);
            return boatMapper.toDto(boat.get());
        } else {
            log.info("Can't find boat");
            throw new NoSuchElementException("No value present.");
        }
    }

    @Override
    public List<BoatDto> searchBoat(BoatSearchDto boatSearchDto) {
        log.info("Find boat by parameters: {}", boatSearchDto.toString());

        EntityManager em = entityManagerFactory.createEntityManager();

        CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();
        CriteriaQuery<Boat> cq = cb.createQuery(Boat.class);
        Root<Boat> boat = cq.from(Boat.class);
        Join<Boat, BoatCategory> boatCategory = boat.join("boatCategory");
        List<Predicate> predicateList = new ArrayList<>();
        if (boatSearchDto.getCategoryId() != null) {
            predicateList.add(cb.equal(boatCategory.get("id"), boatSearchDto.getCategoryId()));
        }
        if (boatSearchDto.getCapacityMin() != null) {
            predicateList.add(cb.greaterThan(boat.get("capacity"), boatSearchDto.getCapacityMin()));
        }
        if (boatSearchDto.getCapacityMax() != null) {
            predicateList.add(cb.lessThan(boat.get("capacity"), boatSearchDto.getCapacityMax()));
        }
        if (boatSearchDto.getCabinsMin() != null) {
            predicateList.add(cb.greaterThan(boat.get("cabins"), boatSearchDto.getCabinsMin()));
        }
        if (boatSearchDto.getCabinsMax() != null) {
            predicateList.add(cb.lessThan(boat.get("cabins"), boatSearchDto.getCabinsMax()));
        }
        if (boatSearchDto.getBedsMin() != null) {
            predicateList.add(cb.greaterThan(boat.get("beds"), boatSearchDto.getBedsMin()));
        }
        if (boatSearchDto.getBedsMax() != null) {
            predicateList.add(cb.lessThan(boat.get("beds"), boatSearchDto.getBedsMax()));
        }
        if (boatSearchDto.getLengthMin() != null) {
            predicateList.add(cb.greaterThan(boat.get("length"), boatSearchDto.getLengthMin()));
        }
        if (boatSearchDto.getLengthMax() != null) {
            predicateList.add(cb.lessThan(boat.get("length"), boatSearchDto.getLengthMax()));
        }
        if (boatSearchDto.getWeekPriceMin() != null) {
            predicateList.add(cb.greaterThan(boat.get("week_price"), boatSearchDto.getWeekPriceMin()));
        }
        if (boatSearchDto.getWeekPriceMax() != null) {
            predicateList.add(cb.lessThan(boat.get("week_price"), boatSearchDto.getWeekPriceMax()));
        }
        if (boatSearchDto.getCaptainSalaryPerDayMin() != null) {
            predicateList.add(cb.greaterThan(boat.get("captain_salary_per_day"), boatSearchDto.getCaptainSalaryPerDayMin()));
        }
        if (boatSearchDto.getCaptainSalaryPerDayMax() != null) {
            predicateList.add(cb.lessThan(boat.get("captain_salary_per_day"), boatSearchDto.getCaptainSalaryPerDayMax()));
        }
        if (boatSearchDto.getYearMin() != null) {
            predicateList.add(cb.greaterThan(boat.get("year"), boatSearchDto.getYearMin()));
        }
        if (boatSearchDto.getYearMax() != null) {
            predicateList.add(cb.lessThan(boat.get("year"), boatSearchDto.getYearMin()));
        }
        if (boatSearchDto.getManufacturer() != null) {
            predicateList.add(cb.equal(boat.get("manufacturer"), boatSearchDto.getManufacturer()));
        }
        if (boatSearchDto.getModel() != null) {
            predicateList.add(cb.equal(boat.get("model"), boatSearchDto.getModel()));
        }
        if (boatSearchDto.getEnginePowerMin() != null) {
            predicateList.add(cb.greaterThan(boat.get("engine_power"), boatSearchDto.getEnginePowerMin()));
        }
        if (boatSearchDto.getEnginePowerMax() != null) {
            predicateList.add(cb.lessThan(boat.get("engine_power"), boatSearchDto.getEnginePowerMax()));
        }
        cq.where(predicateList.toArray(new Predicate[0]));
        List<Boat> boats = em.createQuery(cq).getResultList();

        log.info("Found boats: {}, ids {}", boats.size(), boats.stream().map(Boat::getId).collect(Collectors.toList()));

        return boatMapper.toDto(boats);
    }

    @Override
    public BoatDto createBoat(BoatCreateDto boatCreateDto) {
        Boat boat = boatMapper.toEntity(boatCreateDto);
        log.info("Add new boat {}", boatCreateDto);
        Boat savedBoat = boatRepository.save(boat);
        log.info("Boat saved successfully");
        return boatMapper.toDto(savedBoat);
    }

    @Override
    public void deleteBoat(Long id) {
        log.info("Try to delete boat with id {}", id);
        boatRepository.deleteById(id);
    }

    @Override
    public BoatDto updateBoat(Long id, BoatCreateDto boatCreateDto) {
        log.info("STart to update boat");
        Optional<Boat> boatToUpdate = boatRepository.findById(id);
        if (boatToUpdate.isPresent()) {
            log.info("Boat with id {} found", id);
            Boat savedBoat = boatRepository.save(boatMapper.toEntity(boatCreateDto));
            log.info("Boat updated");
            return boatMapper.toDto(savedBoat);
        } else {
            throw new NoSuchElementException("Boat ia not found");
        }
    }
}
