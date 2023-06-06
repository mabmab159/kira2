FROM openjdk:17

EXPOSE 80
#Copiando el proyecto
COPY . /usr/src/myapp
#Instalando maven
RUN wget https://dlcdn.apache.org/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.tar.gz -O /tmp/maven.tar.gz
#extract the file
RUN cd /tmp && tar xvf maven.tar.gz
#copy the file into opt/maven
RUN mkdir "/usr/share/maven/"
RUN cp -R /tmp/apache-maven-3.9.1/* /usr/share/maven/
#Habilitar el tls
COPY ./java.security /usr/local/openjdk-11/conf/security/
WORKDIR /usr/src/myapp
#Instalar, empaquetar y ejecutar
RUN sh /usr/share/maven/bin/mvn package
RUN chmod 755 /usr/src/myapp/target/kira-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/usr/src/myapp/target/kira-0.0.1-SNAPSHOT.jar"]