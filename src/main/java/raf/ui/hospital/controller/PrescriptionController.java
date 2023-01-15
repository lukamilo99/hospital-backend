package raf.ui.hospital.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raf.ui.hospital.dto.prescriptionDto.CreatePrescriptionDto;
import raf.ui.hospital.dto.prescriptionDto.PresentPrescriptionDto;
import raf.ui.hospital.service.PrescriptionService;

@RestController
@RequestMapping("/prescription")
@AllArgsConstructor
public class PrescriptionController {
    private PrescriptionService prescriptionService;
    @PostMapping("/save")
    public ResponseEntity<Void> savePrescription(@RequestBody CreatePrescriptionDto dto){
        prescriptionService.savePrescription(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<PresentPrescriptionDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(prescriptionService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        prescriptionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
