package pe.edu.cibertec.EF_DSWI.response;

import pe.edu.cibertec.EF_DSWI.dto.CarDetailDto;

public record FindCarResponse(String code,
                              String error,
                              CarDetailDto carDetailDto) {
}
