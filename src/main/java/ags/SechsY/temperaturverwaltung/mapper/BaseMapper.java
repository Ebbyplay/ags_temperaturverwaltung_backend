package ags.SechsY.temperaturverwaltung.mapper;

public interface BaseMapper<ENTITY, DTO> {

    public DTO mapEntity(ENTITY entity);

    public ENTITY mapDTO(DTO dto);
}
