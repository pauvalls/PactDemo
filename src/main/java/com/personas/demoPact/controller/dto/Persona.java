package com.personas.demoPact.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Persona {
    UUID id;
    String nombre;
    String apellidos;
    int edad;
    String direccion;
}
