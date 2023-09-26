package com.example.springboot.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


//Le indicamos que esta es una entidad que debe mapearse a la base de datos
//el mapeo de datos es la integración de muchos conjuntos de datos en un diseño. Varios conjuntos
// de datos con diferentes formas de identificar puntos comparables pueden unirse de tal manera que los
//datos sean precisos y utilizables.
//@ es una notación
@Entity
//Asignar un nombre a la tabla que se va a crear
@Table(name = "estudiantes_cyberpunk")
public class Estudiante {

 @Id   //para decirle que esta es la llave primaria de la tabla ponemos esta notacion
 @GeneratedValue(strategy = GenerationType.IDENTITY) //para autoincrementar los valores y permitir que el usuario vaya agregando sus datos
 //el strategy es la forma en la que va a hacer esa incremenación de datos. Como estamos usando ID por eso ocupamos la estrategia ID.
    private Long estudianteId;

 @Column(name = "nombre")//permite modificar el nombre de la columna en la base de datos
 @NotNull //para evitar que este campo quede vacio
 @Size(min = 5, max = 10) //cantidad maxima y min de letras que puede contener
 private String estudianteNombre;

@Min(value = 18, message = "No pueden ingresar cabros chicos")//importamos esta libreria javax validation con un código en el archivo pom con el objetivo de validar
//que cada registro que agreguemos a esa columna tenga un valor mínimo de 18.
@Max(value = 50, message = "tas muy viejo pa ingresar")
@NotNull (message = "debes ingresar una edad")
 private Integer estudianteEdad;

@Email (message = "debes introducir un mail válido")
@NotNull
 private String email;

//Anotación para indicar relación de uno es a muchos
 //@JsonManagedReference //Anotación que permite eliminar problemas de recursividad
@ManyToOne
@JoinColumn(name = "cursosid")// esta es la llave foranea
private Curso curso;

//Constructor vacío
 public Estudiante() {
 }

 //Constructor Lleno
 public Estudiante(String estudianteNombre, Integer estudianteEdad, String email) {
  this.estudianteNombre = estudianteNombre;
  this.estudianteEdad = estudianteEdad;
  this.email = email;
  //no es necesario construir el id porque se crea y autoincrementa por si solo
 }

 //Getter y Setter
 //aquí se borra el set de id para que no se reescriba y nos cause problemas
 public Long getEstudianteId() {
  return estudianteId;
 }


 public String getEstudianteNombre() {
  return estudianteNombre;
 }

 public void setEstudianteNombre(String estudianteNombre) {
  this.estudianteNombre = estudianteNombre;
 }

 public Integer getEstudianteEdad() {
  return estudianteEdad;
 }

 public void setEstudianteEdad(Integer estudianteEdad) {
  this.estudianteEdad = estudianteEdad;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }
}


