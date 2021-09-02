Este bloque contiene la estructura necesaria para construir un proyecto en java favoreciendo el enfoque de DDD.

Los principales patrones y estilos de arquitectura que guían este bloque son

Arquitectura hexagonal
Arquitectura que fomenta que nuestro dominio sea el núcleo de todas las capas, también conocida como puertos y adaptadores en la cual el dominio define los puertos y en las capas superiores se definen los adaptadores para desacoplar el dominio. Se divide princialmente en tres capas, aplicación, dominio e infraestructura

Infraestructura: Capa que tiene las responsabilidades de realizar los adaptadores a los puertos definidos en el domino, exponer web services, consumir web services, realizar conexiones a bases de datos, ejecutar sentencias DML, en general todo lo que sea implementaciones de cualquier framework
Aplicación: capa encargada de enrutar los eventos entrantes de la capa de infraestructura hacía la capa del dominio, generalmente se conoce como una barrera transaccional la cual agrupa toda la invocación de un caso de uso, se pueden encontrar patrones como Fabricas, Manejadores de Comandos, Bus de eventos, etc
Dominio: representa toda la lógica de negocio de la aplicación la cual es la razón de existir del negocio. Se busca evitar el anti-patron https://martinfowler.com/bliki/AnemicDomainModel.html y favorecer el principio https://martinfowler.com/bliki/TellDontAsk.html en esta capa se pueden encontrar los siguientes patrones agregados, servicios de dominio, entidades, objetos de valor, repositorios (puerto), etc.
Para obtener mas documentación sobre este tipo de arquitectura se recomienda https://codely.tv/blog/screencasts/arquitectura-hexagonal-ddd/

Patrón CQRS:
Patrón con el cual dividimos nuestro modelo de objetos en dos, un modelo para consulta y un modelo para comando (modificación de datos). Este patrón es recomendado cuando se va desarrollar lógica de negocio compleja porque nos ayuda a separar las responsabilidades y a mantener un modelo de negocio consistente.

Consulta: modelo a través del cual se divide la responsabilidad para presentar datos en la interfaz de usuario, los objetos se modelan basado en lo que se va a presentar y no en la lógica de negocio, ejm: ver facturas, consultar clientes
Comando: son todas las operaciones que cambian el estado del sistema, ejm: (facturar, aplicar descuento), este modelo se construye todo el modelo de objetos basado en la lógica de negocio de la aplicación
Para mayor documentación del patrón https://martinfowler.com/bliki/CQRS.html

Especificaciones técnicas:
Spring boot 2.1.2
Flayway -> administrar todos los script DDL e iniciliazadores de la bd
Integración con Jenkins: Jenkins File
Integración con Sonar: Sonar properties
Acceso a la base de datos por medio de JDBC template
Se entregan pruebas de muestra automatizadas para cada una de las capas
Pruebas de carga de ejemplo en el directorio microservicio/external-resources
Ejemplo de como modelar un Comando y un Query
Ejemplo de pruebas de integración con H2
Java 8
Se debe tener configurado el IDE con Lombok, descargar desde (https://projectlombok.org/download)
