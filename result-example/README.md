# Result Pattern
Generalmente en nuestro día a día hacemos uso de excepciones para manejar los errores de nuestra 
aplicación. Por ejemplo, si queremos crear un usuario en base de datos y el email no es válido, 
lanzamos una excepción. Sin embargo, este comportamiento no es algo excepcional, es algo muy común 
en el uso diario por parte un usuario.

## ¿Qué es una excepción?
Una excepción es algo "excepcional", por ejemplo que el servidor no responda, que no conecte a la base de datos, 
que no pueda leer un archivo, etc.
Abusar el uso de excepciones solo hará que nuestro código sea menos mantenible y más difícil de 
entender, ya que tendremos varios bloques **try/catch** en varios puntos, y podríamos estar propagando 
un error en diferentes capas hasta llegar a la capa más externo. Además, en lenguajes como Java, 
el tratado de excepciones son operaciones muy costosas, por lo que puede llegar a afectar al 
rendimiento.

## Una posible solución, aplicar el patrón Result
El **patrón Result** es un patrón de diseño que nos permite devolver un resultado exitoso o un error.
Este patrón es muy utilizado en lenguajes funcionales como Haskell, F# o Rust, pero también podemos
aplicarlo en lenguajes orientados a objetos como Java, C# o PHP.
Este artefacto nos puede aportar una serie de métodos, para saber si la operación ha sido exitosa o
no, y en caso de error, poder obtener el tipo de error. Por lo que siempre devolveremos un Result
que envuelva el valor o el error, y será en la capa de infra donde mapearemos ese error a lo que 
necesitemos, por ejemplo a un código de error HTTP.
Es una aproximación más funcional y más limpia que el uso de excepciones, ya que evitamos ese 
propagado de excepciones y nos obliga a tratar el error en el mismo punto donde se produce.