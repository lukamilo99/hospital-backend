package raf.ui.hospital.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import raf.ui.hospital.dto.vacationDto.CreateVacationDto;
import raf.ui.hospital.facade.RequestVacationFacade;

@RestController
@RequestMapping("requestVacation")
@AllArgsConstructor
public class RequestVacationController {
    private RequestVacationFacade requestVacationFacade;
    @PostMapping()
    public ResponseEntity<String> requestVacation(@RequestBody CreateVacationDto dto){
        return new ResponseEntity<>(requestVacationFacade.requestVacation(dto), HttpStatus.OK);
    }
}
