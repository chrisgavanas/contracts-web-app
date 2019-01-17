package com.service;

import com.dto.response.client.ClientResponseDto;

public interface ClientService {

    ClientResponseDto findUser(String username);
}
