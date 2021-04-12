# MadPhobia (Guia)
Primer Juego de SimpDevs

## Tipos de armas y sus danos
- Fuego: 20 de dano base y aumenta de acuerdo al nivel
- Melee: 15 de dano base y aumenta de acuerdo al nivel
- Explosivo: 25 de dano base y aumenta de acuerdo al nivel
## Armas
- Melee
  - Botella rota

    ![Botella rota](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/armas/meele/bottle.png)
  - Bate

    ![Bate de baseball](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/armas/meele/bat.png)
- Fuego
  - Glock

    ![Glock](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/armas/fuego/glock.png)
  - Uzi

    ![Uzi](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/armas/fuego/revolver.png)
  - Revolver

    ![Shot Gun](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/armas/fuego/shotgun.png)
  - Shot Gun
- Explosivo
  - Bomba molotov

    ![Molotov](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/armas/explosivo/molotov.png)
  - Granada de fragmentacion

    ![Granada](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/armas/explosivo/granada.png)
## Enemigos
Hay 3 tipos de enemigos:
- Saqueadores
  - Hacen 15 dano base que aumenta conforme sube el nivel

    ![Saqueador 1](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/pjs/enemigos/saqueadores/saqueador.png)
    ![Saqueador 2](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/pjs/enemigos/saqueadores/saqueador2.png)
    ![Saqueador 3](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/pjs/enemigos/saqueadores/saqueador3.png)
    ![Saqueador 4](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/pjs/enemigos/saqueadores/saqueador4.png)
- Soldados

    ![Soldado 1](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/pjs/enemigos/soldados/soldado.png)
    ![Soldado 2](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/pjs/enemigos/soldados/soldado2.png)
  - Hacen 20 de dano base que aumenta con el nivel
- Deformes

    ![Cosa](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/pjs/enemigos/monos/cosa.gif)
    ![Hombre de Dos Cabezas](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/pjs/enemigos/monos/doscabezas.gif)
    ![Guts](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/pjs/enemigos/monos/tripas.gif)
  - Tiene 25 de ataque base que aumenta con el nivel
## Efectos hechos por enemigos
Existen 3 efectos que un enemigo puede aplicar sobre el jugador:
- Fuego ![Efecto de fuego](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/hud/iconos/fuego.png)
  - Hace 5 de dano por segundo durante 3 segundos
  - Solamente los soldados enemigos pueden causar este efecto con una probabilidad de 0.3
- Radiacion ![Efecto de fuego](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/hud/iconos/radia.png)
  - Hace 1 de dano por segundo durante 70 segundos
  - Solo los enemigos deformes causan este efecto con una probabilidad de 0.4
- Hemorragia ![Efecto de fuego](https://github.com/fwcheesecake/MadPhobia/blob/master/src/sprites/hud/iconos/sangre.png)
  - Hace 2 de dano por segundo durante 10 segundos
  - Cualquier enemigo puede causar emorragia con probabilidad de 0.3
## Mecanicas y Reglas de MadPhobia
- Las casillas no mostraran el contenido de ellas hasta que un jugador se mueva a una
- Cada jugador cuenta con un click por turno
- Si un jugador encuentra una casilla con un Objeto o Enemigo se le da otro click y le deja dos opciones:
  - Huir, sin embargo, al huir a una casilla con un enemigo o un objeto forza la interaccion con la siguente casilla
  - Interactuar con la entidad de la casilla. Si la entidad es un enemigo el jugador ataca, por otro lado, si es un objeto el jugador la guarda en su inventario
- Al recoger un arma o un escudo por primera vez, se equipan automaticamente
- Las armas y escudos tienen 50% de probabilidad de aparecer en cada nivel
## Requerimentos
- Intel Atom de 1.6GHz o equivalente
- 512MB de memoria RAM
