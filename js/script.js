document.addEventListener('DOMContentLoaded', function() {
    const productos = [
        {
            id: 1,
            name: "Producto 1",
            url_image: "https://picsum.photos/200/300?random=5",
            price: 10.0,
            discount: 0,
            category: 1
        },
        {
            id: 2,
            name: "Producto 2",
            url_image: "https://imagenes.20minutos.es/files/image_1920_1080/uploads/imagenes/2024/05/24/kabosu-el-perro-detras-del-meme-doge.png",
            price: 20.0,
            discount: 0,
            category: 1
        },
        {
            id: 3,
            name: "Producto 3",
            url_image: "https://imagenes.20minutos.es/files/image_1920_1080/uploads/imagenes/2024/05/24/kabosu-el-perro-detras-del-meme-doge.png",
            price: 30.0,
            discount: 0,
            category: 1
        },
        {
            id: 4,
            name: "Producto 4",
            url_image: "https://imagenes.20minutos.es/files/image_1920_1080/uploads/imagenes/2024/05/24/kabosu-el-perro-detras-del-meme-doge.png",
            price: 30.0,
            discount: 0,
            category: 1
        },
        {
            id: 5,
            name: "Producto 5",
            url_image: "https://imagenes.20minutos.es/files/image_1920_1080/uploads/imagenes/2024/05/24/kabosu-el-perro-detras-del-meme-doge.png",
            price: 30.0,
            discount: 0,
            category: 3
        },
        {
            id: 6,
            name: "Producto 6",
            url_image: "https://imagenes.20minutos.es/files/image_1920_1080/uploads/imagenes/2024/05/24/kabosu-el-perro-detras-del-meme-doge.png",
            price: 30.0,
            discount: 0,
            category: 4
        }
    ];

    const contenedorProductos = document.getElementById('productos');

    productos.forEach(producto => {
        const productoDiv = document.createElement('div');
        productoDiv.className = 'producto';

        productoDiv.innerHTML = `
            <img src="${producto.url_image}" alt="${producto.name}">
            <h3>${producto.name}</h3>
            <p>Precio: $${producto.price}</p>
            <p>Descuento: ${producto.discount}%</p>
            <p>Categoría: ${producto.category}</p>
        `;

        contenedorProductos.appendChild(productoDiv);
    });
});

