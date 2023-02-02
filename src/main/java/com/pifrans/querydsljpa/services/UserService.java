package com.pifrans.querydsljpa.services;

import com.pifrans.querydsljpa.domains.dtos.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDTO.All> filterByNameAndAgeMinMax(String name, Integer minAge, Integer maxAge);

    List<UserDTO.All> filterByAll(UserDTO.Filter object);

    List<UserDTO.All> saveAll(List<UserDTO.Save> list);
}
