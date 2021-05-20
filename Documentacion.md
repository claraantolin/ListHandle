# ListHandle

## JUEGOS

### Listar todos los juegos
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
        "platform": "Play Station 4",
        "pegi": "18"
    },
    {
        "id": "60a35e8e96d3b160b7527dee",
        "name": "Until Dawn",
        "platform": "Play Station 4",
        "pegi": "16"
    },
    {
        "id": "60a6782f9b3bf02de1de8ecb",
        "name": "SOMA",
        "platform": "Play Station 3",
        "pegi": "18"
    },
    {
        "id": "60a678399b3bf02de1de8ecc",
        "name": "Mario",
        "platform": "Switch",
        "pegi": "7"
    }
]
```

### Obtener un juego
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
    "platform": "Play Station 4",
    "pegi": "18"
}
```
### Insertar un juego
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
    "platform": "Play Station 4",
    "pegi": "18"
}
```
*Respuesta:* 201 CREATED
```
{
    "id": "60a35e8e96d3b160b7527dee",
    "name": "Until Dawn",
    "platform": "Play Station 4",
    "pegi": "18"
}
```
### Actualizar un juego
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
### Eliminar un juego
**DELETE**
```
endpoint: /api/games/game/{id}
puerto : 8080
```
Ejemplo:

*Llamada:* `/api/games/game/60a35e8e96d3b160b7527dee`

*Respuesta:* 200 OK

## FILTROS

### Listar todas las plataformas distintas
**GET**
```
endpoint: /api/filter/platforms
puerto : 8080
```
Ejemplo:

*Llamada:* `/api/filter/platforms`

*Respuesta:* 200 OK
```
[
    "Play Station 3",
    "Play Station 4",
    "Switch"
]
```

### Listar todos los pegis distintas
**GET**
```
endpoint: /api/filter/pegis
puerto : 8080
```
Ejemplo:

*Llamada:* `/api/filter/pegis`

*Respuesta:* 200 OK
```
[
    "16",
    "18",
    "7"
]
```
### Listar los juegos con filtros
**GET**
```
endpoint: /api/filter/game?...  // opciones de filtrado: "platform", "pegi"
puerto : 8080
```
Ejemplo 1:

*Llamada:* `/api/filter/game?platform=Switch`

*Respuesta:* 200 OK
```
[
    {
        "id": "60a678399b3bf02de1de8ecc",
        "name": "Mario",
        "platform": "Switch",
        "pegi": "7"
    }
]
```

Ejemplo 2:

*Llamada:* `/api/filter/game?pegi=18`

*Respuesta:* 200 OK
```
[
    {
        "id": "60a28f63028d1229daab9608",
        "name": "Uncharted",
        "platform": "Play Station 4",
        "pegi": "18"
    },
    {
        "id": "60a6782f9b3bf02de1de8ecb",
        "name": "SOMA",
        "platform": "Play Station 3",
        "pegi": "18"
    }
]
```

Ejemplo 3:

*Llamada:* `/api/filter/game?pegi=7&platform=Switch`

*Respuesta:* 200 OK
```
[
    {
        "id": "60a678399b3bf02de1de8ecc",
        "name": "Mario",
        "platform": "Switch",
        "pegi": "7"
    }
]
```