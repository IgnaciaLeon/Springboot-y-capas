package com.example.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Manejar una vista a través de una plantilla HTML, esto lo hacemos por ahora, pero en la práctica
//usaremos react para hacer un front
public class IndexController {

    //cuando ingrese a esta ruta, hará una peticion de tipo GET y nos trae lo que estemos indicando en el método.
 @RequestMapping("/")
    public String vistaHome() {
     return "index";
 }



}
