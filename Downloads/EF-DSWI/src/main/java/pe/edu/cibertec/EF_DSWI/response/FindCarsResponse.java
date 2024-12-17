package pe.edu.cibertec.EF_DSWI.response;

import pe.edu.cibertec.EF_DSWI.dto.CarDto;

import java.util.List;

public record FindCarsResponse(String code,
                               String error,
                               List<CarDto> cars)  {
}
