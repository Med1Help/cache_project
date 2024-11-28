package com.Cacheproject.dtos.mapper;

import com.Cacheproject.dtos.ClientDto;
import com.Cacheproject.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientDtoMapper {
    Client clientDtoToClient(ClientDto clientDto);
}
