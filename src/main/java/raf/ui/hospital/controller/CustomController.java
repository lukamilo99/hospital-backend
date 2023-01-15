package raf.ui.hospital.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raf.ui.hospital.dto.ProcedureDto;
import raf.ui.hospital.service.CustomService;
import raf.ui.hospital.service.impl.CustomServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/custom")
@AllArgsConstructor
public class CustomController {
    private CustomService customService;
    @GetMapping ("/query1")
    public ResponseEntity<List<String[]>> query1(@RequestParam String param){
        return new ResponseEntity<>(customService.query1(param), HttpStatus.OK);
    }

    @GetMapping ("/query2")
    public ResponseEntity<String> query2(@RequestParam String param){
        return new ResponseEntity<>(customService.query2(param), HttpStatus.OK);
    }

    @GetMapping ("/query3")
    public ResponseEntity<Long> query3(){
        return new ResponseEntity<>(customService.query3(), HttpStatus.OK);
    }

    @GetMapping ("/query4")
    public ResponseEntity<List<String[]>> query4(){
        return new ResponseEntity<>(customService.query4(), HttpStatus.OK);
    }

    @GetMapping ("/query5")
    public ResponseEntity<String> query5(){
        return new ResponseEntity<>(customService.query5(), HttpStatus.OK);
    }

    @GetMapping ("/query6")
    public ResponseEntity<List<ProcedureDto>> query6(){
        return new ResponseEntity<>(customService.query6(), HttpStatus.OK);
    }

    @GetMapping ("/query7")
    public ResponseEntity<Double> query7(@RequestParam String firstName, @RequestParam String lastName){
        return new ResponseEntity<>(customService.query7(firstName, lastName), HttpStatus.OK);
    }
}
