package ags.SechsY.temperaturverwaltung.mapper;

public interface BaseMapper<E, D> {

    public D mapEntity(E e);

    public E mapDTO(D d);
}
