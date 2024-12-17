package pe.edu.cibertec.EF_DSWI.service;

import pe.edu.cibertec.EF_DSWI.dto.CarDetailDto;
import pe.edu.cibertec.EF_DSWI.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<CarDto> getAllCars() throws Exception;
    Optional<CarDetailDto> getCarById(int id) throws Exception;
    boolean updateCar(CarDetailDto carDetailDto) throws Exception;
    boolean deleteCar(int id) throws Exception;
    boolean addCar(CarDetailDto carDetailDto) throws Exception;
}
