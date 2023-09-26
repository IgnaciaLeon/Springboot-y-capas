package com.example.springboot.models;

import jakarta.persistence.*;
import lombok.*;
import java.security.Timestamp;
import java.util.List;

@Entity

@Table(name = "hobbies")
@NoArgsConstructor//nos va a crear el constructor vacío
@AllArgsConstructor//Genera constructor con todos los datos
@Getter //genera todos los getter automáticamente
@Setter ////genera todos los setter automáticamente
//@Data: no se recomienda mucho, pero contempla todas las notaciones de constructores, getter y setter
//@ToString: para imprimir el contenido de nuestro objeto
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hobbyId;

    @Column(name = "nombre")
    private String nombreHobby;

    @Column(name = "material")
    private String materialHobby;

    @Column(name = "tiempo", columnDefinition = "TIME")
    private Timestamp tiempoHobby;

    //relación de muchos a muchos
    @ManyToMany
    @JoinTable(  //hay que indicar el nombre de la tabla y el nombre de las columnas
            name = "estudiantes_hobbies", //nombre de la tabla
            joinColumns = @JoinColumn(name = "hobbyId"), //indicamos la columna que lleva la FK de este modelo
            inverseJoinColumns = @JoinColumn(name = "estudianteId") //indicamos la columna que lleva la FK del otro modelo
    )
  private List<Estudiante> listaEtudiantes;

}
//id, nombre, material, tiempo