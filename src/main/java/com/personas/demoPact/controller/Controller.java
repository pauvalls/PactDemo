package com.personas.demoPact.controller;

import com.personas.demoPact.controller.dto.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController()
public class Controller {
   private static final ArrayList<Persona> cache = new ArrayList<>();
    public static void chargeCache(){
        cache.add(
                Persona
                        .builder()
                        .id(UUID.randomUUID())
                        .nombre("Pau")
                        .apellidos("valls")
                        .edad(26)
                        .direccion("calle falsa 123")
                        .build()
        );
        cache.add(
                Persona
                        .builder()
                        .id(UUID.randomUUID())
                        .nombre("Pepe")
                        .apellidos("Medina")
                        .edad(54)
                        .direccion("calle falsa 321")
                        .build()
        );

    }

    @RequestMapping(value = "/add/persona", method = RequestMethod.POST)
        public ResponseEntity addPersona(@RequestBody Persona persona) {
            persona.setId(UUID.randomUUID());
            cache.add(persona);
            return ResponseEntity.ok(cache);
        }

    @RequestMapping(value = "/get/persona", method = RequestMethod.GET)
    public ResponseEntity getPersona(@RequestBody Persona persona) {
        Persona persona1 = cache
                .stream()
                .filter(x -> x.getNombre().equals(persona.getNombre())).findFirst().get();
        return ResponseEntity.ok(persona1);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/getall/persona", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(cache);
    }


}
