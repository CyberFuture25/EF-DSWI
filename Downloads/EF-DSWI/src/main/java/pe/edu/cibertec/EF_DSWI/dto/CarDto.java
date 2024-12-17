package pe.edu.cibertec.EF_DSWI.dto;

import java.util.Date;


public record CarDto(Integer car_id,
                     String make,
                     String model,
                     String licensePlate,
                     String ownerName,
                     String ownerContact,
                     String color,
                     String insurancePolicyNumber,
                     Date registrationExpirationDate,
                     Date serviceDueDate) {
}
