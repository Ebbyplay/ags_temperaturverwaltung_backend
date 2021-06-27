package ags.SechsY.temperaturverwaltung.mapper.request;

import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.dto.request.ManufacturerRequestDTO;
import ags.SechsY.temperaturverwaltung.mapper.BaseMapper;
import ags.SechsY.temperaturverwaltung.model.Manufacturer;

@Component
public class ManufacturerRequestMapper implements BaseMapper<Manufacturer, ManufacturerRequestDTO> {

    @Override
    public ManufacturerRequestDTO mapEntity(Manufacturer manufacturer) {
        ManufacturerRequestDTO dto = new ManufacturerRequestDTO();
        dto.setName(manufacturer.getName());
        return dto;
    }

    @Override
    public Manufacturer mapDTO(ManufacturerRequestDTO dto) {
        Manufacturer manufacturer = new Manufacturer(dto.getName());
        return manufacturer;
    }

}
