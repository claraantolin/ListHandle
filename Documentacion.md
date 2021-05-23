# ListHandle

## JUEGOS

###Estructura de un juego:
```
{
    id: String (identificador del juego),
    name: String (nombre del juego),
    position: int (posición del juego en la lista),
    platform: String (plataforma),
    pegi: String (Edad mínima recomendada)
}
```

## Llamadas api

##Índice:
1. [Listar todos los juegos: [GET] /api/games/](#listar-juegos)
2. [Obtener un juego: [GET] /api/games/game/{id}](#obtener-juego)
3. [Insertar un juego: [POST] /api/games/game](#insertar-juego)
4. [Actualizar un juego: [PUT] /api/games/game/{id}](#actualizar-juego)
5. [Actualizar una posición: [PUT] /api/games/game/{id}/position](#actualizar-posicion)
6. [Eliminar un juego: [DELETE] /api/games/game/{id}](#eliminar-juego)
7. [Eliminar todos los juegos: [DELETE] /api/games/](#eliminar-juegos)
8. [Listar plataformas: [GET] /api/filter/platforms](#listar-plataformas)
9. [Listar pegis: [GET] /api/filter/pegis](#listar-pegis)
10. [Listar pegis: [GET] /api/filter/pegis](#listar-pegis)
11. [Listar juegos con filtros: [GET] /api/filter/game?...](#listar-juegos-filtros)
12. [Generar juegos: [POST] /api/games/](#generar-juegos)


### Listar todos los juegos <a name="listar-juegos"></a>
Lista todos los juegos en orden de posición

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
        "position": 1,
        "platform": "Play Station 4",
        "pegi": "18"
    },
    {
        "id": "60a35e8e96d3b160b7527dee",
        "name": "Until Dawn",
        "position": 2,
        "platform": "Play Station 4",
        "pegi": "16"
    },
    {
        "id": "60a6782f9b3bf02de1de8ecb",
        "name": "SOMA",
        "position": 3,
        "platform": "Play Station 3",
        "pegi": "18"
    }
]
```

### Obtener un juego <a name="obtener-juego"></a>
Devuelve un juego con el identificador id

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
    "position": 1,
    "platform": "Play Station 4",
    "pegi": "18"
}
```
### Insertar un juego <a name="insertar-juego"></a>
Inserta un juego en la última posición de la lista

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
    "name": "Mario",
    "platform": "Switch",
    "pegi": "7"
}
```
*Respuesta:* 201 CREATED
```
{
    "id": "60a678399b3bf02de1de8ecc",
    "name": "Mario",
    "position": 4,
    "platform": "Switch",
    "pegi": "7"
}
```
### Actualizar un juego <a name="actualizar-juegos"></a>
Actualizar cualquiera de los siguientes datos de un juego pasándole el id:

```
name
platform
pegi
```

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
    "position": 2,
    "platform": "Switch"
    "pegi": "16"
}
```
### Actualizar una posición <a name="actualizar-posicion"></a>
Actualizar la posición de un juego pasándole en el body la nueva posició, reordena el resto de juegos de la lista y 
devuelve el juego con la posición actualizada.

**PUT**
```
endpoint: /api/games/game/{id}/position
puerto : 8080
```
Ejemplo:

*Llamada:* `/api/games/game/60a6782f9b3bf02de1de8ecb/position`

*Body:*
```
{
    "position": 1
}
```
*Respuesta:* 200 OK
```
{
    "id": "60a6782f9b3bf02de1de8ecb",
    "name": "SOMA",
    "position": 1,
    "platform": "Play Station 3",
    "pegi": "18"
}
```

### Eliminar un juego <a name="eliminar-juego"></a>
Elimina un juego de la lista pasándole el id del juego a eliminar

**DELETE**
```
endpoint: /api/games/game/{id}
puerto : 8080
```
Ejemplo:

*Llamada:* `/api/games/game/60a35e8e96d3b160b7527dee`

*Respuesta:* 200 OK


### Eliminar todos los juegos <a name="eliminar-juegos"></a>
Para limpiar la lista y eliminar todos los juegos de golpe

**DELETE**
```
endpoint: /api/games/
puerto : 8080
```
Ejemplo:

*Llamada:* `/api/games/`

*Respuesta:* 200 OK

## FILTROS

### Listar plataformas <a name="listar-plataformas"></a>
Devuelve una lista con todas las plataformas distintas que hay en el momento

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

### Listar pegis <a name="listar-pegis"></a>
Devuelve una lista con todos los pegis distintos que hay en el momento

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
### Listar los juegos con filtros <a name="listar-juegos-filtros"></a>
Devuelve en una lista todos los juegos que cumplen los filtros indicados, por el momento sólo se puede filtrar por:

```
platform
pegi
```

**GET**
```
endpoint: /api/filter/game?...  
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
        "position": 4,
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
        "position": 1,
        "platform": "Play Station 4",
        "pegi": "18"
    },
    {
        "id": "60a6782f9b3bf02de1de8ecb",
        "name": "SOMA",
        "position": 3,
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
        "position": 4,
        "platform": "Switch",
        "pegi": "7"
    }
]
```


##Llamadas para pruebas <a name="generar-juegos"></a>
Elimina la base de datos por completo, genera de golpe 10 juegos y los devuelve en orden de posición.


**POST**
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
        "id": "60aa27480dd7491241c4b8e4",
        "name": "Juego 1",
        "position": 1,
        "platform": "platform",
        "pegi": "pegi"
    },
    {
        "id": "60aa27480dd7491241c4b8e3",
        "name": "Juego 2",
        "position": 2,
        "platform": "platform",
        "pegi": "pegi"
    },
    {
        "id": "60aa27480dd7491241c4b8e2",
        "name": "Juego 3",
        "position": 3,
        "platform": "platform",
        "pegi": "pegi"
    },
    {
        "id": "60aa27480dd7491241c4b8e1",
        "name": "Juego 4",
        "position": 4,
        "platform": "platform",
        "pegi": "pegi"
    },
    {
        "id": "60aa27480dd7491241c4b8e0",
        "name": "Juego 5",
        "position": 5,
        "platform": "platform",
        "pegi": "pegi"
    },
    {
        "id": "60aa27480dd7491241c4b8df",
        "name": "Juego 6",
        "position": 6,
        "platform": "platform",
        "pegi": "pegi"
    },
    {
        "id": "60aa27480dd7491241c4b8de",
        "name": "Juego 7",
        "position": 7,
        "platform": "platform",
        "pegi": "pegi"
    },
    {
        "id": "60aa27480dd7491241c4b8dd",
        "name": "Juego 8",
        "position": 8,
        "platform": "platform",
        "pegi": "pegi"
    },
    {
        "id": "60aa27480dd7491241c4b8dc",
        "name": "Juego 9",
        "position": 9,
        "platform": "platform",
        "pegi": "pegi"
    },
    {
        "id": "60aa27480dd7491241c4b8db",
        "name": "Juego 10",
        "position": 10,
        "platform": "platform",
        "pegi": "pegi"
    }
]
```