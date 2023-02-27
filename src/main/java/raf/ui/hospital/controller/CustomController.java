package raf.ui.hospital.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raf.ui.hospital.service.CustomService;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/custom")
@RestController
public class CustomController {

    private CustomService customService;

    // Find the most often prescribed medications for given illness, order descending
    @GetMapping ("/query1")
    public ResponseEntity<List<String[]>> query1(@RequestParam String illnessName){
        return new ResponseEntity<>(customService.query1(illnessName), HttpStatus.OK);
    }

    // Find a manufacturer of the most prescribed medication with given name
    @GetMapping ("/query2")
    public ResponseEntity<String> query2(@RequestParam String medicationName){
        return new ResponseEntity<>(customService.query2(medicationName), HttpStatus.OK);
    }

    // Find a percentage of people diagnosed with COVID-19, which received antibiotics during their treatment (40 = 40%)
    @GetMapping ("/query3")
    public ResponseEntity<Long> query3(){
        return new ResponseEntity<>(customService.query3(), HttpStatus.OK);
    }

    // Find an average number of procedure licences grouped by specialization
    @GetMapping ("/query4")
    public ResponseEntity<List<String[]>> query4(){
        return new ResponseEntity<>(customService.query4(), HttpStatus.OK);
    }

    // Find a name of every procedure performed in hospital, order by price descending
    @GetMapping ("/query5")
    public ResponseEntity<String> query5(){
        return new ResponseEntity<>(customService.query5(), HttpStatus.OK);
    }

    //Find a department which had the most operations
    @GetMapping ("/query6")
    public ResponseEntity<List<String>> query6(){
        return new ResponseEntity<>(customService.query6(), HttpStatus.OK);
    }

    // Find an average number of procedure performed by doctor with given name, per week
    @GetMapping ("/query7")
    public ResponseEntity<Double> query7(@RequestParam String firstName, @RequestParam String lastName){
        return new ResponseEntity<>(customService.query7(firstName, lastName), HttpStatus.OK);
    }
}
