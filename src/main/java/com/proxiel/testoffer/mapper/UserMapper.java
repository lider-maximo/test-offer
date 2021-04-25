package com.proxiel.testoffer.mapper;

import com.proxiel.testoffer.data.User;
import com.proxiel.testoffer.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapstruct user Mapper
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO entityToDto(User entity);

    User dtoToEntity(UserDTO dto);

    List<UserDTO> entitiesToDTOs(List<User> entities);

    List<User> dtosToEntities(List<UserDTO> dtos);
}
