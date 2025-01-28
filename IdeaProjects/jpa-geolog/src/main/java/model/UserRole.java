package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public enum UserRole {

    USER("user", "Пользователь"),
    MODER("moderator", "Модератор"),
    ADMIN("admin", "Администратор");

    private final String serviceName;
    private final String displayName;
}



