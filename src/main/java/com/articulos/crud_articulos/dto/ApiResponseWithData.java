package com.articulos.crud_articulos.dto;

public class ApiResponseWithData<T> {
    private T data; // Datos adicionales

    // Constructor
    public ApiResponseWithData( T data) {
        this.data = data;
    }

    // Getters y setters

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
