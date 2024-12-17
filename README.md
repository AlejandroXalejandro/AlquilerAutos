Mi proyecto consiste en un alquiler de autos, este tiene como objetivo administrar vehículos para que el usuario pueda alquilar alguna de su gusto para sus necesidades, este proyecto tiene un apartado de usuario estándar y otro de administrador para que se pueda hacer una correcta gestión de los vehículos disponibles y sus complementos.
Empezamos por la clase loginInvitado:
Este se estructura de la siguiente manera

![image](https://github.com/user-attachments/assets/16d14b41-f505-425a-8ede-57936b22269f)
 


import javax.swing.JOptionPane;
import java.sql.Connection;

Hago el uso de esas librerías para obtener la conexión a mi base de datos y para hacer el uso de los textos y botones de tipo JOptionPane.


![image](https://github.com/user-attachments/assets/3434e7f8-1cf9-4acc-aa7a-064f8c305680)


Este código es parte de un sistema de inicio de sesión en una aplicación. Su función principal es tomar un usuario y contraseña ingresados en la interfaz gráfica de la aplicación, luego intentar verificar si esos datos coinciden con los almacenados en una base de datos.

Captura los datos ingresados: Primero, el código toma el valor del campo de texto donde el usuario escribe su nombre de usuario (usuario) y la contraseña (contraseña), que es tomada como un arreglo de caracteres y convertida a una cadena de texto.
Verificación de campos vacíos: Luego verifica si los campos de usuario o contraseña están vacíos. Si es así, muestra una advertencia para que el usuario complete ambos campos.
Conexión a la base de datos: Si los campos no están vacíos, intenta conectar a la base de datos usando una clase llamada Conexion. Si se conecta con éxito, procede con la consulta.
Consulta SQL: El código prepara una consulta SQL para verificar si el nombre de usuario y la contraseña coinciden con algún registro en la base de datos. Para esto, se utiliza un PreparedStatement que protege la consulta de posibles ataques de inyección SQL.
Verificación de usuario y contraseña: Si la consulta devuelve un resultado (rs.next()), significa que encontró un usuario con ese nombre y contraseña, por lo que abre una nueva ventana (vistaR) y cierra la ventana actual.
Manejo de errores: Si no hay coincidencias, muestra un mensaje de error. Si hay algún problema con la conexión a la base de datos o con la consulta SQL, también muestra un mensaje de error.



![image](https://github.com/user-attachments/assets/70e48b1d-7b0f-4249-be67-81d1e62fcddb)

 
Este bloque de código define una validación para el campo "Usuario". Usa un KeyListener, que se activa cada vez que el usuario presiona una tecla.
Cuando el usuario escribe una tecla, el código verifica si el carácter ingresado es una letra (Character.isLetterOrDigit(c)) o un número, o si es el guion bajo (_).
Si el carácter no es ninguno de esos, el código usa evt.consume(), que detiene la escritura de ese carácter, evitando que se ingrese un símbolo no permitido.



Ahora pasamos a la ventana VistaR


![image](https://github.com/user-attachments/assets/3b112bbc-5d92-4874-8d41-11c5b7e24445)



Hago el uso de estas librerías:
import java.sql.Connection;
import javax.swing.*; 
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener; 
import java.util.Date; 
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class vistaR extends javax.swing.JFrame {
    Conexion con1 = new Conexion();
    Connection conet;

Con este bloque mando a llamar a mi clase Conexión que es la que se encargara de comunicarse por asi decirlo con la base de datos.


![image](https://github.com/user-attachments/assets/e37541f7-43e0-4c47-a02d-5e6beefb1f7f)


![image](https://github.com/user-attachments/assets/ed68dc7a-46f4-4865-8e84-bf8a9f8cfe33)

1. Recuperar datos de los campos:
Se obtienen los valores de los campos de la interfaz de usuario: lugares de recolección y devolución, fechas y horas de inicio y fin. Estos datos se guardan en variables.
2. Validaciones:
Validación de los lugares:
Se comprueba si el lugar de recolección o el lugar de devolución contienen los valores predeterminados (por ejemplo, "¿En qué estado comienza el viaje?"). Si es así, muestra un mensaje pidiendo al usuario que seleccione un lugar válido.
Validación de los campos de fecha y hora:
Se verifica que los campos de fecha (inicio y fin) y hora (inicio y fin) no estén vacíos. Si alguno está vacío, se muestra un mensaje de advertencia.

Validación del formato de fecha:
Se valida que las fechas estén en el formato YYYY-MM-DD. Si no se cumple este formato, se lanza una excepción y se muestra un mensaje pidiendo al usuario que ingrese las fechas correctamente.
Validación del formato de hora:
De manera similar, se valida que las horas estén en el formato HH:MM:SS. Si no lo están, se muestra un mensaje de error.
3. Inserción de datos en la base de datos:
Si todas las validaciones pasan correctamente, el código construye una consulta SQL (INSERT INTO alquileres...) para guardar los datos en la tabla de alquileres de la base de datos.
Se utiliza un PreparedStatement para insertar los valores de los campos en la base de datos de manera segura, previniendo inyecciones SQL.
Luego, la inserción se ejecuta con executeUpdate().
4. Recuperación del ID generado:
Después de insertar el nuevo alquiler en la base de datos, se recupera el ID generado automáticamente por la base de datos (usualmente un valor autoincremental) y se muestra en la consola. Este ID puede ser utilizado para otras operaciones o para asociarlo con otros datos.
5. Mensajes y navegación:
Si la inserción es exitosa, muestra un mensaje de confirmación.
Luego, abre una nueva ventana (probablemente una ventana para registrar los pasajeros asociados con el alquiler) pasando el ID del alquiler recién creado.
Finalmente, cierra la ventana actual (this.dispose()).
6. Manejo de errores:
Si ocurre un error durante la inserción (por ejemplo, problemas con la conexión a la base de datos), se captura la excepción SQLException y se muestra un mensaje de error con detalles.


![image](https://github.com/user-attachments/assets/573ab2d3-b5bc-44ce-a7ea-c36b8a314872)


En esta clase lo que hago es editar mis entradas de texto para que esto muestre un poco mejor el diseño del programa, lo que hice fue editar las funciones del mouse sobre cada entrada de texto esto para que cuando corra el programa por default aparezca la fecha y hora en los campos y que cuando le de click encima se borren en automatico.



Posteriormente pasamos a la clase “pasajeros”


![image](https://github.com/user-attachments/assets/160c92f2-cfac-4ad0-ba8c-43f001e91f1a)

Aquí el usuario puede elegir su vehiculo y su complemento si es que desea agregar alguno, además esta clase se enlaza con el administrador ya que él puede modificar los vehículos y complementos, abajo esta un botón llamado “ver vehículos” el cual al darle click nos lleva a esta ventana

![image](https://github.com/user-attachments/assets/2f52c5a9-6b56-49c8-8a5c-d5623f41b744)


En esta ventana podemos visualizar los vehículos y los complementos nada mas, regresando a nuestra clase “pasajeros”


![image](https://github.com/user-attachments/assets/8bf859e7-ee99-4a91-824c-03d510cfa07d)

Esta recupera los detalles de los vehículos almacenados en la tabla vehiculos de la base de datos. La información solicitada incluye: marca, modelo, año, tipo, color, matrícula, precio por día y disponibilidad.
Ademas, el código utiliza un Connection (con1.conectar()) para conectarse a la base de datos.
Luego, un Statement se usa para ejecutar la consulta (stmt.executeQuery(query)).
El ResultSet (rs) almacena los resultados obtenidos de la consulta.
Básicamente lo que hace es que carga los datos de los vehículos almacenados en una base de datos y los muestra en la tabla. Primero, se hace una consulta a la base de datos, luego los resultados se recorren y se agregan a la tabla para que el usuario pueda verlos de forma estructurada. Si ocurre algún error en el proceso, se muestra un mensaje de error en la consola.
La siguiente ventana es esta:


![image](https://github.com/user-attachments/assets/ebf935b8-9a56-4703-b2bc-b387da0c5201)

![image](https://github.com/user-attachments/assets/2fb491ed-9499-40e6-b3ec-2ab54c5fc461)

El cual se encarga de insertar el nombre del cliente en la base de datos y si mandas el campo vacio este te da una alerta , además hace el uso de if y else para avisarte cuando el nombre es guardado de manera exitosa o algún error al guardar el nombre.
Tambien tenemos el método para validar el teléfono del cliente

![image](https://github.com/user-attachments/assets/732216ce-2d89-4f73-b86a-a15e3fa0fb73)

Y para que pida lo que es la licencia e ine, este impedirá el hecho de omitir este paso ya que es un requisito necesario para seguir usando el programa.

![image](https://github.com/user-attachments/assets/38d6f462-8fd7-4b91-84ce-7297a17f000c)

De la reserva me manda a solicitar los datos de la tarjeta del usuario, esto en caso de cualquier tipo de golpe o daño físico que reciba el vehiculo


![image](https://github.com/user-attachments/assets/3a4dc1bc-3d2f-4511-817b-b40ee8de58d1)


![image](https://github.com/user-attachments/assets/78cb384b-9c80-493b-800f-02e8e86e1884)



Este método se encarga de validar que todos los campos relacionados con los datos de una tarjeta de crédito estén correctamente formateados y sean válidos. Si alguno de los campos no es válido (por ejemplo, si el número de tarjeta no tiene 16 dígitos o si la fecha de expiración está en el pasado), se muestra un mensaje de error y se devuelve false. Si todo es correcto, se devuelve true.



Al darle click en continuar nos vamos al apartado de la confirmación del alquiler.


 ![image](https://github.com/user-attachments/assets/2fa3f9a3-4404-4b38-b178-2152d8772d2a)


Aquí nos aparecen los datos que ingresamos y este al darle clic en aceptar lo que hará es generar un pdf con la ayuda de la librería “itext5.jar” además que al mismo tiempo establecerá la conexión con la base de datos extrayendo los datos y los enviara al correo electrónico previamente ingresado.

![image](https://github.com/user-attachments/assets/c312e7c3-c4eb-4fa3-bce4-ba3214ebf925)

![image](https://github.com/user-attachments/assets/ba00bd18-8191-4464-a22f-622dcab76729)

![image](https://github.com/user-attachments/assets/e397e393-fec8-4181-8cd3-40d83e5e1a53)


El correo demora unos segundos en llegar pero es funcional!!!
Tambien se puede visualizar el pdf en la raíz de nuestro programa


![image](https://github.com/user-attachments/assets/63decea9-b9f2-4925-bf3c-7db4cb0b303d)

Esta es mi clase que establece la conexión con la base de datos


![image](https://github.com/user-attachments/assets/8af92653-bebb-45d9-868e-22abc405f968)


Me pide contraseña de mi base de datos, mi usuario que por defecto es root, el puerto y la ruta de acceso.




Anexo capturas de mi base de datos elaborada en Workbench

![Uploading image.png…]()
