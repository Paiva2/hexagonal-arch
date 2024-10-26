package org.com.estudos.hexagonal.adapter.mapper;

import org.com.estudos.hexagonal.adapter.persistence.entity.UserEntity;
import org.com.estudos.hexagonal.domain.entity.User;
import org.springframework.beans.BeanUtils;

public class UserMapper {
    public static UserEntity toPersistence(User userDomain) {
        if (userDomain == null) return null;

        UserEntity userEntity = new UserEntity();
        copyProperties(userDomain, userEntity);

        return userEntity;
    }

    public static User toDomain(UserEntity userEntity) {
        if (userEntity == null) return null;

        User user = new User();
        copyProperties(userEntity, user);

        return user;
    }

    private static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }
}
