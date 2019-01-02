package com.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IacsGateway {

    private final static String IACS_URL_FORMAT = "%s/api/%s/compensation";

    private final static String IACS_VEHICLE_ENDPOINT = "vehicle";


    @Value("${iacs.url}")
    private String iacsUrl;

    @Autowired
    private RestTemplate restTemplate;


    public CompensationResponseDto calculateVehicleCompensation(Integer bonusMalus, Integer firstRegistrationYear, Double vehicleValue) {
        return restTemplate.postForObject(
                String.format(IACS_URL_FORMAT, iacsUrl, IACS_VEHICLE_ENDPOINT),
                new VehicleCompensationRequestDto(bonusMalus, firstRegistrationYear, vehicleValue),
                CompensationResponseDto.class
        );
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
