package raf.ui.hospital.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raf.ui.hospital.dto.MedicineDto;
import raf.ui.hospital.model.Medicine;
import raf.ui.hospital.service.impl.CustomServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/custom")
@AllArgsConstructor
public class CustomController {
    private final CustomServiceImpl customService;

    @GetMapping ("/query1")
    public ResponseEntity<List<MedicineDto>> query1(@RequestParam String param){
        return new ResponseEntity<>(customService.query1(param), HttpStatus.OK);
    }

    @GetMapping ("/query2")
    public ResponseEntity<List<MedicineDto>> query2(@RequestParam String param){
        return new ResponseEntity<>(customService.query2(param), HttpStatus.OK);
    }
}
