# Estudiante

#### Bienvenido a el estudiante.
Se desea construir una aplicación para el manejo de información de los cursos que está
tomando un estudiante. El estudiante toma solo 4 cursos en el semestre.
De cada estudiante se conoce:
- Código
- Nombre
- Apellido
- Promedio
De cada curso se conoce:
 Código. Es el identificador del curso y no pueden haber dos cursos con el mismo
código.
- Nombre.
-Departamento. Puede ser Matemáticas, Física, Sistemas o Biología.
-Cantidad de créditos.
-Nota obtenida en el curso. Este valor debe estar entre 1.5 y 5.
Para poder calcular el promedio del estudiante, se deben ponderar las notas, teniendo en
cuenta la cantidad de créditos de las materias. Para esto, para cada curso se debe multiplicar
la nota del curso con su cantidad de créditos, sumar estos valores y dividir esta suma por la
cantidad total de créditos vistos por el estudiante.
Adicionalmente, se quiere poder saber si un estudiante está en prueba académica o si es
candidato para beca. Para esto se debe tener en cuenta las siguientes reglas.
- Se considera que un estudiante está en prueba académica si su promedio es inferior a
3.25.
- Se considera que un estudiante es candidato a beca si su promedio es igual o superior
a 4.75.
### La aplicación debe permitir:
1. Visualizar la información del estudiante.
2. Visualizar la información de los cursos.
3. Modificar la información de un curso.
4. Asignar una nota a un curso.
5. Calcular el promedio del estudiante.
6. Indicar si el estudiante está en prueba académica.
7. Indicar si el estudiante es candidato a beca.

#### Requerimientos Funcionales
------------------------------------------------------------------------------------------------------
**Nombre** R1 – Visualizar la información del estudiante.
**Resumen** Muestra la información detallada (código, nombre, apellido) del estudiante. 
**Entrada**
Ninguna
**Resultado** Muestra información detallada del estudiante.

------------------------------------------------------------------------------------------------------
**Nombre** R2 – Visualizar la información de los cursos.
**Resumen** Muestra la información detallada (código, nombre, departamento, crédito y la nota) de los cursos.
**Entrada**
Ninguna
**Resultado** Muestra información detallada de los cursos.

------------------------------------------------------------------------------------------------------
**Nombre** R3 – Modificar la información de un curso.
**Resumen** Modifica la información de un curso.
**Entrada**
Código Actual.
Código Nuevo.
Nombre del curso.
Departamento.
Cantidad de crédito.
**Resultado** Sí no existe un curso con el nuevo código, se modifica la información del curso.
Sí existe un curso con el nuevo código, no se modifica la información y se le avisa al usuario.

------------------------------------------------------------------------------------------------------
**Nombre**
R4 – Asignar una nota a un curso.
**Resumen**
Se asigna la nota de un curso. Esta nota debe ser entre 1.5 y 5.
**Entrada**
Código del curso
Nueva calificación del curso.
**Resultado** Sí la nota está dentro del rango válido. Se asigna la nota.
Sí la nota no está dentro del rango válido. No se asigna la nota y se informa al usuario.

------------------------------------------------------------------------------------------------------
**Nombre**
R5 – Calcular el promedio del estudiante.
**Resumen**
Calcula el promedio del estudiante.
empresa. 
**Entrada**
Ninguno.
**Resultado** Calcula el promedio del estudiante (teniendo en cuenta los créditos de los cursos).

------------------------------------------------------------------------------------------------------
**Nombre**
R6 – Indicar si el estudiante está en prueba académica.
**Resumen**
Indica al usuario si el estudiante está en prueba académica basado en su promedio.
empresa. 
**Entrada**
Ninguno.
**Resultado** Informa al usuario si el estudiante está a prueba académico.

------------------------------------------------------------------------------------------------------
**Nombre**
R7 – Indicar si el estudiante es candidato a beca.
**Resumen**
Indica al usuario si el estudiante es candidato a beca basado en su promedio.
empresa. 

**Entrada**
Ninguno.
**Resultado** Informa al usuario si el estudiante es candidato a beca.

------------------------------------------------------------------------------------------------------
#### Directorio
    editor.md/
       	source/
            test/source/
       	data/
        	docs/
            specs/
                 doc/
                   Javadoc/
            api/
        ...
  [YouTube](https://www.youtube.com/user/MrDionicios/videos "youtube")      
