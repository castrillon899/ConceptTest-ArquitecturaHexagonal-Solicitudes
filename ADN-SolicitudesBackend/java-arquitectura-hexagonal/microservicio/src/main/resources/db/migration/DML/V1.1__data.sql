insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

insert into usuario(nombre,clave,fecha_creacion) values('angelmarin','1234',now());

insert into solicitud values  (1,'la usuaria manifiesta inconformidad con la factura recibida por favor $200.000','QUEJA','EN_PROGRESO', now(), now(), now()+1, now()+2, 1,'Se esta revisando factura', 1233, '3004177487');

insert into solicitud values  (2,'la usuaria manifiesta inconformidad con la factura recibida por favor $500.000','QUEJA','FINALIZADA', now(), now(), now()+1, now()+2, 1,'Se valido factura sin novedades, la factura fue a corde a comprado por el cliente' ,1233, '3004177487');

insert into solicitud values  (3,'La usuaria desea conocer el estado del envio del pedido 254554','SOLICITUD','FINALIZADA', now(), now(), now()+2, now()+5, 1,'el envio se encuentra en camino, llegara el dia 30/08/2021' ,1244, '3004177488');

insert into solicitud values  (4,'La usuaria desea conocer el estado del envio del pedido 544112','SOLICITUD','FINALIZADA', now(), now(), now()+2, now()+5, 1,'el envio se encuentra en camino, llegara el dia 27/08/2021' ,1244, '3004177488');



insert into solicitud values  (5,'La usuaria desea conocer el estado del envio del pedido 5421','SOLICITUD','CANCELADA', now(), now(), now()+2, now()+5, 1,'Se cancela solicitud, el pedido no pertenece al cliente, no se le puede brindar esa informacion' ,1244, '3004177488');