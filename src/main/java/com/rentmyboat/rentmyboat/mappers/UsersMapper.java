package com.rentmyboat.rentmyboat.mappers;

import com.rentmyboat.rentmyboat.dto.UsersDto;
import com.rentmyboat.rentmyboat.model.Users;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UsersMapper {

    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    UsersDto toDto (Users users);
    Users toEntity(UsersDto usersDto);
}
