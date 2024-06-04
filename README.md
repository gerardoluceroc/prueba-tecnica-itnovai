# Prueba técnica de ItnovAI
Prueba técnica de la empresa ItnovAI.
* Objetivo: Determinar si el candidato está en condiciones de interactuar con una base de datos a través de una aplicación web, implementando cliente y servidor.

## Prerequisitos
* Utilizar el sistema operativo Ubuntu 22.04
* [Instalar Docker](https://www.hostinger.es/tutoriales/como-instalar-y-usar-docker-en-ubuntu)
* [Instalar Java 17](http://codigoelectronica.com/blog/instalar-java-17-en-ubuntu)

## Resumen
Se ha desarrollado una API Rest con Java Spring Boot (usando Java 17 y Maven) que se conecta con la base de datos facilitada para el ejercicio. Esta API se despliega con Docker y se mapea al puerto 8080 tanto interno como externo (ver docker-compose.yaml). 

En cuanto al frontend, aunque no se utiliza ningún framework ya que solo se emplea un archivo index.html (con el script dentro debido a pequeños problemas relacionados con "MIME type" cuando se separaba el script en archivos aparte), para una mayor comodidad y poder desplegar el sistema con Docker, se ha montado un pequeño servidor con Node.js en el que se despliega el archivo index.html correspondiente. 

Además de esto, se ha levantado un proxy inverso con nginx para redirigir las peticiones HTTP al servidor del frontend, el cual se encuentra escuchando en el puerto 3000. Por lo tanto, solo es necesario enviar una solicitud HTTP a la dirección IP del servidor donde se ha desplegado el sistema para acceder al catálogo desarrollado, sin necesidad de mapear a un puerto específico.

En cuanto a esto último, el sistema fue desplegado en el proveedor DigitalOcean, en el cual se ha automatizado la creación de un VPS utilizando la herramienta Terraform.

## Desplegar ejercicio

Primeramente, es necesario crear el archivo .jar para la API de Spring Boot, por lo que debe ingresar a este directorio.

```bash
cd api-spring-boot
```
Luego, debe crear el archivo .jar

```bash
./mvnw install -DskipTests
```

Luego de esto, puede volver al directorio principal.
```bash
cd ..
```

Finalmente, proceda a desplegar el ejercicio desarrollado utilizando Docker Compose con el siguiente comando.

```bash
docker compose up -d
```

Para acceder al catálogo desarrollado, en caso de desplegarse en un ambiente local, solo basta con ingresar localhost en la URL del navegador de la siguiente forma.
```text
http://localhost
```
En caso de desplegar el ejercicio en un servidor virtual privado (VPS) basta con escribir la IP pública del servidor para acceder, en este caso la IP es la siguiente.
```text
http://137.184.198.221
```
