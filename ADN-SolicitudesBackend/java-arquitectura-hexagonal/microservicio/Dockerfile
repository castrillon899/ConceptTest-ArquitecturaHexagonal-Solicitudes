FROM openjdk:8

ARG TZ='America/Bogota'
ENV TZ=${TZ}
WORKDIR /home

COPY build/libs/solicitudes-0.0.1-SNAPSHOT.jar /home/solicitudes.jar

RUN cp /usr/share/zoneinfo/${TZ} /etc/localtime && echo ${TZ} > /etc/timezone

CMD ["java", "-Duser.timezone=${TZ}", "-jar", "/home/solicitudes.jar"]


EXPOSE 8083

