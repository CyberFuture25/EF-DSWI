package pe.edu.cibertec.EF_DSWI.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.EF_DSWI.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
