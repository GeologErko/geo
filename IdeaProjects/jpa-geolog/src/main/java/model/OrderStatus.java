package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    CREATED("сreated", "СОЗДАН"),
    IN_DELIVERY("inDelivery", " В_ДОСТАВКЕ"),
    DELIVERED("delivered", "ДОСТАВЛЕН");

    private final String serviceName;
    private final String displayName;

}
