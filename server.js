const http = require('http');
const fs = require('fs');
const path = require('path');
const mime = require('mime');

const PORT = 8000;
const PUBLIC_DIR = path.join(__dirname, '/');

const server = http.createServer((req, res) => {
  const url = req.url === '/' ? '/index.html' : req.url;
  const filePath = path.join(PUBLIC_DIR, url);

  fs.readFile(filePath, (err, data) => {
    if (err) {
      if (err.code === 'ENOENT') {
        // Archivo no encontrado
        res.writeHead(404);
        res.end('404 Not Found');
      } else {
        // Error del servidor
        res.writeHead(500);
        res.end('Error interno del servidor');
      }
    } else {
      // Archivo encontrado, servirlo con el tipo MIME correcto
      const contentType = mime.getType(filePath) || 'text/html';
      res.writeHead(200, { 'Content-Type': contentType });
      res.end(data, 'utf-8');
    }
  });
});

server.listen(PORT, () => {
  console.log(`Servidor escuchando en el puerto ${PORT}`);
});
