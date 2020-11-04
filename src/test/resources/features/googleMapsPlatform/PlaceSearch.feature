# language: es

Característica: Buscar lugares por medio de API Google Maps Platform

  @regression
  Esquema del escenario: Buscar lugares por palabras clave
    Dado que <Usuario> esta en la busqueda de un <clave>
    Cuando el/ella haga la solicitud de busqueda a Google Maps
    Entonces se muestran los resultados de la busqueda

    Ejemplos:
      | Usuario | clave                  |
      | Andres  | Restaurante+en+Choachi |
      | Felipe  | Banco+en+Anapoima      |


  @regression
  Esquema del escenario: Buscar información del lugar
    Dado que <Usuario> esta en la busqueda de informacion de <lugar> con <place ID>
    Cuando el/ella haga la solicitud de busqueda a Google Maps
    Entonces se muestra la información básica del lugar

    Ejemplos:
      | Usuario | lugar                  | place ID                    |
      | Andres  | La+Montaña+Restaurante | ChIJN1t_tDeuEmsRUsoyG83frY4 |
      | Felipe  | Restaurante+Suizo      | ChIJo83FExK-P44R8KvJ2zftr9o |