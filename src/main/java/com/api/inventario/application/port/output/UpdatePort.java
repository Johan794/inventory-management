package com.api.inventario.application.port.output;

public interface UpdatePort<T> {
    T save( T object);
    T delete(T object);

    T update(T object);

}
