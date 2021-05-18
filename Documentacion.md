# ListHandle

##Games

###Listar todos los juegos
**GET**
```
endpoint: /api/games/
puerto : 8080
```
Ejemplo:

*Llamada:* `/api/games/`

*Respuesta:* 200 OK
```
[
    {
        "id": "60a28f63028d1229daab9608",
        "name": "Uncharted",
        "platform": "Play Station 4"
    },
    {
        "id": "60a35e8e96d3b160b7527dee",
        "name": "Until Dawn",
        "platform": "Play Station 4"
    }
]
```

###Obtener un juego
**GET**
```
endpoint: /api/games/game/{id}
puerto : 8080
```
Ejemplo:

*Llamada:* `/api/games/game/60a28f63028d1229daab9608`

*Respuesta:* 200 OK
```
{
    "id": "60a28f63028d1229daab9608",
    "name": "Uncharted",
    "platform": "Play Station 4"
}
```
###Insertar un juego
**POST**
```
endpoint: /api/games/game
puerto : 8080
```
Ejemplo:

*Llamada:* `/api/games/game`

*Body:*
```
{
    "name": "Until Dawn",
    "platform": "Play Station 4"
}
```
*Respuesta:* 201 CREATED
```
{
    "id": "60a35e8e96d3b160b7527dee",
    "name": "Until Dawn",
    "platform": "Play Station 4"
}
```
###Actualizar un juego
**PUT**
```
endpoint: /api/games/game/{id}
puerto : 8080
```
Ejemplo:

*Llamada:* `/api/games/game/60a35e8e96d3b160b7527dee`

*Body:*
```
{
    "platform": "Switch"
}
```
*Respuesta:* 200 OK
```
{
    "id": "60a35e8e96d3b160b7527dee",
    "name": "Until Dawn",
    "platform": "Switch"
}
```
###Eliminar un juego
**DELETE**
```
endpoint: /api/games/game/{id}
puerto : 8080
```
Ejemplo:

*Llamada:* `/api/games/game/60a35e8e96d3b160b7527dee`

*Respuesta:* 200 OK

