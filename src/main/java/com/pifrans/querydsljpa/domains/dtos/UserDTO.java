package com.pifrans.querydsljpa.domains.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDTO implements Serializable {


    @Getter
    @Setter
    public static class Save {
        private String name;
        private String lastName;
        private Integer age;
    }

    @Getter
    @Setter
    public static class All extends Save {
        private Long id;
    }


    @Getter
    @Setter
    public static class Filter {
        private String id;
        private String name;
        private String lastName;
        private String age;


        public static Filter check(Filter filter) {
            Filter object = new Filter();
            object.setId(filter.getId() == null ? "" : filter.getId());
            object.setName(filter.getName() == null ? "" : filter.getName());
            object.setLastName(filter.getLastName() == null ? "" : filter.getLastName());
            object.setAge(filter.getAge() == null ? "" : filter.getAge());
            return object;
        }
    }
}
