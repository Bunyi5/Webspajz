FROM openjdk:15

WORKDIR /

COPY /build/libs/webspajz-*jar /webspajz.jar

EXPOSE 8080

CMD ["java", "-jar", "-Dserver.port=8080", "/webspajz.jar"]