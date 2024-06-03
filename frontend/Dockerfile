# Usa la imagen de Node.js
FROM node:14

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia los archivos necesarios al contenedor
COPY server.js .
COPY index.html .
COPY css css

# Expone el puerto 3000
EXPOSE 3000

# Comando para ejecutar el servidor Node.js
CMD ["node", "server.js"]
