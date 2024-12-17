package pe.edu.cibertec.EF_DSWI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.EF_DSWI.dto.CarDetailDto;
import pe.edu.cibertec.EF_DSWI.dto.CarDto;
import pe.edu.cibertec.EF_DSWI.response.*;
import pe.edu.cibertec.EF_DSWI.service.CarService;

import java.util.List;
import java.util.Optional;

public class ManageCarApi {
    @Autowired
    CarService carService;

    @GetMapping("/all")
    public FindCarsResponse findCars() {

        try {
            List<CarDto> cars = carService.getAllCars();
            if (!cars.isEmpty())
                return new FindCarsResponse("01", "Se encontraron "+ cars.size() +" carros registrados :D", cars);
            else
                return new FindCarsResponse("02", "No registered cars found", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "An error occurred, please try again", null);

        }

    }

    @GetMapping("/detail")
    public FindCarResponse findCar(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            Optional<CarDetailDto> optional = carService.getCarById(Integer.parseInt(id));
            return optional.map(car ->
                    new FindCarResponse("01", null, car)
            ).orElse(
                    new FindCarResponse("02", "Car not found", null)
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponse("99", "An error occurred, please try again", null);

        }

    }

    @PutMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarDetailDto carDetailDto) {

        try {
            if (carService.updateCar(carDetailDto))
                return new UpdateCarResponse("01", null);
            else
                return new UpdateCarResponse("02", "Car not found to be updated");

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "An error occurred, please try again");

        }

    }

    @DeleteMapping("/delete/{id}")
    public DeleteCarResponse deleteCar(@PathVariable String id) {

        try {
            if (carService.deleteCar(Integer.parseInt(id)))
                return new DeleteCarResponse("01", "THe car was successfully removed");
            else
                return new DeleteCarResponse("02", "User not found");

        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "An error occurred, please try again");

        }

    }

    @PostMapping("/create")
    public CreateCarResponse createUser(@RequestBody CarDetailDto carDetailDto) {

        try {
            if (carService.addCar(carDetailDto))
                return new CreateCarResponse("01", "The car was successfully registered :D");
            else
                return new CreateCarResponse("02", "This car already exists");

        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "An error occurred, please try again");

        }

    }

}
