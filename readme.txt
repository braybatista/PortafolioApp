el proyecto Spring esta configurado para un localhost ya que la url dada no recibio conexion, 
para configurar este si se quiere revisar se debe modificar el archivo application.properties en el paquete de resources del proecto

los tweet se trabajaron con la API de twitter en JAVA y no tiene persmisos de escritura, adicionalmente no hay tweets en dicha cuenta

elproyecto en angular se sube sin las dependencias por lo que es necesario instalarlas
adicionalmente el pryecto se le deben insalas algunas especificas via npm install materialize-css jquery

la api spring tiene recursos para cargas imagenes, tweets y la informacion del portafolio

se genera un script SQL con la estructura de la tabla correspondiente, esto debido a que la conexion con los datos indicadosa no fue exitosa


Resumen:

1. se creo una API REST con Spring boot, My Sql, JPA, Twitter API
2. se creo un aplicativo Frontend en Angular el cual consume dicha API
3. el aplicativo en angular carga imagenes, portafolio y tweet correspondientes y todo se consume gracias a la API.

Requisitos minimos:
spring tools configurado 
angular cli en ultima version
mysql