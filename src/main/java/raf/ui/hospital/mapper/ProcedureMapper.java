package raf.ui.hospital.mapper;

import org.springframework.stereotype.Component;
import raf.ui.hospital.dto.ProcedureDto;
import raf.ui.hospital.model.Procedure;

@Component
public class ProcedureMapper {

    public ProcedureDto toDto(Procedure procedure){
        ProcedureDto dto = new ProcedureDto();
        dto.setPrice(procedure.getPrice());
        dto.setName(procedure.getName());

        return dto;
    }
}
