package com.gateway;

import com.dto.enums.MedicalRecord;
import com.error.ContractError;
import com.exception.contract.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IacsGateway {

    private final static String IACS_URL_FORMAT = "%s/api/%s/compensation";

    private final static String IACS_VEHICLE_ENDPOINT = "vehicle";
    private final static String IACS_PROPERTY_ENDPOINT = "property";
    private final static String IACS_LIFE_ENDPOINT = "life";

    @Value("${iacs.url}")
    private String iacsUrl;

    @Autowired
    private RestTemplate restTemplate;

    public CompensationResponseDto calculateVehicleCompensation(Integer bonusMalus, Integer firstRegistrationYear, Double vehicleValue) {
        try {
            return restTemplate.postForObject(
                    String.format(IACS_URL_FORMAT, iacsUrl, IACS_VEHICLE_ENDPOINT),
                    new VehicleCompensationRequestDto(bonusMalus, firstRegistrationYear, vehicleValue),
                    CompensationResponseDto.class
            );
        } catch (Exception e) {
            throw new ContractException(ContractError.CANNOT_CALCULATE_COMPENSATION_TRY_AGAIN_LATER);
        }
    }

    public CompensationResponseDto calculatePropertyCompensation(Integer constructionYear, Double objectiveValue) {
        try {
            return restTemplate.postForObject(
                    String.format(IACS_URL_FORMAT, iacsUrl, IACS_PROPERTY_ENDPOINT),
                    new PropertyCompensationRequestDto(constructionYear, objectiveValue),
                    CompensationResponseDto.class
            );
        } catch (Exception e) {
            throw new ContractException(ContractError.CANNOT_CALCULATE_COMPENSATION_TRY_AGAIN_LATER);
        }
    }

    public CompensationResponseDto calculateLifeCompensation(Integer securedAge, MedicalRecord medicalRecord, Double insuredValue) {
        try {
            return restTemplate.postForObject(
                    String.format(IACS_URL_FORMAT, iacsUrl, IACS_LIFE_ENDPOINT),
                    new LifeCompensationRequestDto(securedAge, medicalRecord, insuredValue),
                    CompensationResponseDto.class
            );
        } catch (Exception e) {
            throw new ContractException(ContractError.CANNOT_CALCULATE_COMPENSATION_TRY_AGAIN_LATER);
        }
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(5000)
                .setReadTimeout(4000)
                .build();
    }

}
