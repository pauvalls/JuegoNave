# JuegoNave
El juego de la nave creado con login y password,  donde se accede a los selvnet, haciendo gestiones 
dentro de la base de datos conectada en postgresql.

El juego arrancará con una página  jsp con 2 formularios,  uno de registro y otro de login.

El  formulario de registro  enviará al selvnet que comprobará que  en la base de datos no exista el usuario, si existe llevará 
a una pantala generica de error si no existe, se creará el usuario y regresará a la pantalla de inicio.

El formulario de login  tiene los campos de usuarios y contraseña que se trasmitirán a un selvnet que comprobara que el usuario
y la contraseña  esté y coincidan, si lo hacen, creará las cookies y te  enviará a la pantalla de menú principal.
( si no, irá a la pantalla de error generica).

En el jsp  se guardarán los datos de las cookies y se usarán  para poder  encontrar el nombre, ya que en el texto del menú  
estará una pantalla de bienvenida.

En el menú principal, tienes varias opciones:
  -ir al juego.
  -ir a el ultimas conexiones.
  -ir a el ranking.
  -ir a los mas viciados.
  -hacer logout.

El menu de juego te llevará a un selvnet que preparará  una fecha inicial ( para las partidas) y enviara al jsp del juego.
cuando se termine la partida estaran las opciones de jugar de nuevo y volver, si le das a jugar de nuevo, se enviara de nuevo 
al selvnet donde se guardo la fecha y se creara una segunda fecha ( la fecha final) y  guardarán los datos para que  se cree una fila con 
el usuario, las fechas y la puntuación guardada con un double.

ir al las ultimas conexiones realizara una consulta  de sql de los servicios, donde se guardarán los datos  en un arraylist y se enviarán 
a el jsp de ultimas conexiones que consta de una tabla con los respectivos datos.

ir al el ranking realizara una consulta  de sql de los servicios, donde se guardarán los datos  en un arraylist y se enviarán 
a el jsp de ranking que consta de una tabla con los respectivos datos.

ir al el los mas viciados realizara una consulta  de sql de los servicios, donde se guardarán los datos  en un arraylist y se enviarán 
a el jsp de los mas viciados que consta de una tabla con los respectivos datos.

hacer logout  te enviará de vuelta a la pantalla de registro y te borrará las cookies




