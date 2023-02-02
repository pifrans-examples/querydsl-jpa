package com.pifrans.querydsljpa.business;

import com.pifrans.querydsljpa.domains.dtos.UserDTO;
import com.pifrans.querydsljpa.domains.entities.User;
import com.pifrans.querydsljpa.queries.UserQuery;
import com.pifrans.querydsljpa.repositories.UserRepository;
import com.pifrans.querydsljpa.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserQuery userQuery;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, UserQuery userQuery, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userQuery = userQuery;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO.All> filterByNameAndAgeMinMax(String name, Integer minAge, Integer maxAge) {
        Iterable<User> iterable = userRepository.findAll(userQuery.filterByNameAndAgeMinMax(name, minAge, maxAge));
        List<User> list = StreamSupport.stream(iterable.spliterator(), false).toList();
        return list.stream().map(user -> modelMapper.map(user, UserDTO.All.class)).toList();
    }

    @Override
    public List<UserDTO.All> filterByAll(UserDTO.Filter object) {
        Iterable<User> iterable = userRepository.findAll(userQuery.filterByAll(object));
        List<User> list = StreamSupport.stream(iterable.spliterator(), false).toList();
        return list.stream().map(user -> modelMapper.map(user, UserDTO.All.class)).toList();
    }

    @Override
    public List<UserDTO.All> saveAll(List<UserDTO.Save> list) {
        List<User> objectsToSave = new ArrayList<>();
        for (UserDTO.Save object : list) {
            objectsToSave.add(modelMapper.map(object, User.class));
        }

        List<User> savedObjects = userRepository.saveAll(objectsToSave);
        List<UserDTO.All> objectsToReturn = new ArrayList<>();
        for (User object : savedObjects) {
            objectsToReturn.add(modelMapper.map(object, UserDTO.All.class));
        }

        return objectsToReturn;
    }
}
