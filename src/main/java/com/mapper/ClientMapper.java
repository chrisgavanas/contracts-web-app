package com.mapper;

import org.springframework.stereotype.Component;

import com.dto.response.client.ClientResponseDto;
import com.entity.Client;

@Component
public class ClientMapper {

    public ClientResponseDto clientToResponseDto(Client client) {
        if (client == null) {
            return null;
        }

        ClientResponseDto clientResponseDto = new ClientResponseDto();
        clientResponseDto.setClientId(client.getClientId());
        clientResponseDto.setFirstname(client.getFirstname());
        clientResponseDto.setLastname(client.getLastname());
        clientResponseDto.setUsername(client.getUsername());
        return clientResponseDto;
    }

}
