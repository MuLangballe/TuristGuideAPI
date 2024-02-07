package com.example.turistguideapi.controller;

import com.example.turistguideapi.model.TouristAttraction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.turistguideapi.repository.TouristRepository;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    TouristRepository touristRepository;

    public TouristController(){
        touristRepository = new TouristRepository();
    }


    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getTouristAttractions(){
        List touristAttractionsList = touristRepository.getListOfAttractions();
        return new ResponseEntity<> (touristAttractionsList, HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<TouristAttraction> searchAttractionsByName(@PathVariable String name){
        TouristAttraction touristAttraction = touristRepository.getTouristAttractionByName(name);
        if (touristAttraction == null){
            return new ResponseEntity<> (touristAttraction, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttractions(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction newTouristAttraction = touristRepository.addTouristAttraction(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttractions(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction returnTouristAttraction = touristRepository.updateTouristAttraction(touristAttraction);
        return new ResponseEntity<>(returnTouristAttraction, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name){
        touristRepository.deleteTouristAttraction(name);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
