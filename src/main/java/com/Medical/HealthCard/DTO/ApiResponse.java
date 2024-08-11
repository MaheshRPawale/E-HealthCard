package com.Medical.HealthCard.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private String massage;
    private boolean success;
    private org.springframework.http.HttpStatus httpStatus;

}
