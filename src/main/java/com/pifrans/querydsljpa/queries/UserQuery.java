package com.pifrans.querydsljpa.queries;


import com.pifrans.querydsljpa.domains.dtos.UserDTO;
import com.pifrans.querydsljpa.domains.entities.QUser;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Component;

@Component
public class UserQuery {


    public BooleanExpression filterByNameAndAgeMinMax(String name, Integer minAge, Integer maxAge) {
        QUser user = QUser.user;
        return user.name.containsIgnoreCase(name).and(user.age.between(minAge, maxAge));
    }

    public BooleanExpression filterByAll(UserDTO.Filter object) {
        QUser user = QUser.user;
        return user.id.stringValue().containsIgnoreCase(object.getId())
                .and(user.name.containsIgnoreCase(object.getName()))
                .and(user.lastName.containsIgnoreCase(object.getLastName()))
                .and(user.age.stringValue().containsIgnoreCase(object.getAge()));
    }
}
