OBTENER TODOS LOS ARTICULOS

URL:http://localhost:8081/api/articulos
METODO: GET

OBTENER ARTICULO POR ID
URL: http://localhost:8081/api/articulos/"ID"
METODO: GET

CREAR NUEVO ARTICULO:
URL:http://localhost:8081/api/articulos
METODO: POST
CUERPO: {
"nombre": "GALAXY WACHT S4",
"descripcion": "RELOJ DEPORTIVO INTELIGENTE",
"stock": 14,
"precio_producto": 600.0
}

EDITAR ARTICULO EXISTENTE (POR CAMPOS, NO ES NECESARIO TODOS LOS CAMPOS)
URL: http://localhost:8081/api/articulos/"ID"
METODO: PATCH
CUERPO (colocar solo los campos a editar):
{
"stock": 5,
"precio_producto": 650.0
}


ELIMINAR ARTICULO DE LA TABLA
URL: http://localhost:8081/api/articulos/"ID"
METODO: DELETE


OBTENER TODOS LOS MOVIMIENTOS DE STOCK
URL: http://localhost:8081/api/movimientos-stock
METODO: GET

OBTENER TODOS LOS MOVIMIENTOS DE STOCK POR ID
URL:http://localhost:8081/api/movimientos-stock/"ID"
METODO: GET 
