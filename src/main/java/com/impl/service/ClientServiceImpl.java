package com.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ClientDao;
import com.dto.response.client.ClientResponseDto;
import com.entity.Client;
import com.error.ContractError;
import com.exception.NotFoundException;
import com.mapper.ClientMapper;
import com.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ClientMapper clientMapper;


    @Override
    public ClientResponseDto findUser(String username) {
        return clientMapper.clientToResponseDto(findClientByUsername(username));
    }

    private Client findClientByUsername(String username) {
        return clientDao.findClientByUsername(username)
                .orElseThrow(() -> new NotFoundException(ContractError.CLIENT_NOT_FOUND));
    }

}
