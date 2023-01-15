package raf.ui.hospital.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raf.ui.hospital.dto.doctorDto.CreateDoctorDto;
import raf.ui.hospital.dto.doctorDto.PresentDoctorDto;
import raf.ui.hospital.service.impl.DoctorServiceImpl;

@RestController
@RequestMapping("/doctor")
@AllArgsConstructor
public class DoctorController {
    private DoctorServiceImpl doctorService;
    @PostMapping("/save")
    public ResponseEntity<Void> saveDoctor(@RequestBody CreateDoctorDto doctorDto){
        doctorService.save(doctorDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<PresentDoctorDto> findDoctor(@PathVariable Long id){
        return new ResponseEntity<>(doctorService.findDoctorById(id), HttpStatus.OK);
    }
}
