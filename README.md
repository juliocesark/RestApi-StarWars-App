# RestAPI StarWars
RestAPI criada para fazer o cadastro dos planetas do StarWars. Foi utilizado java 8, spring boot, mongodb e docker em seu desenvolvimento. Além disso, foi consumida a [API do StarWars](https://swapi.co/) para obter a informação da quantidade de vezes que o planeta apareceu nos filmes da franquia.

## Procedimentos para execução
- Baixe e instale o [Docker](https://docs.docker.com/install/) e o [Git](https://git-scm.com/downloads)
- Após o docker e o git estarem instalados, clone o projeto com o comando ```git clone https://github.com/juliocesark/RestApi-StarWars-App.git```
- Acesse o diretório do projeto clonado
- Execute o comando ```docker-compose up -d``` para fazer com que o docker inicie os serviços do projeto em segundo plano.
- Em seguida utilize o comando ```docker logs -f restapi-starwars-app``` para verificar a inicialização do projeto. Assim que estiver com a mensagem abaixo, poderá fazer o teste da aplicação. Utilize ```CTRL + C``` para sair do log.
    ```
    : Tomcat started on port(s): 8080 (http) with context path ''
    : Started RestApiStarWarsAppApplication in 18.226 seconds (JVM running for 24.561)
    ```
- Após este processo, a API poderá ser testada no link: ```http://localhost:8182/api/planetas``` para exibir os dados da API interna ou no link: ```http://localhost:8182/swapi/planetas/?pagina=1``` para exibir os dados da API externa
- Para testes de requisições na API, pode-se utilizar o [Postman](https://www.getpostman.com/downloads/)

## Links para requisições na API
- GET: ```http://localhost:8182/api/planetas``` (Retorna todos os planetas)
``` 
[
    {
        "id": "5e2f6c649a90812d6c324406",
        "nome": "Coruscant",
        "clima": "temperate",
        "terreno": "cityscape, mountains",
        "aparicoesEmFilmes": 4
    },
    {
        "id": "5e2f6c649a90812d6c324407",
        "nome": "Alderaan",
        "clima": "temperate",
        "terreno": "grasslands, mountains",
        "aparicoesEmFilmes": 2
    }
]
```
- GET: ```http://localhost:8182/api/planetas/{id}``` (Retorna o planeta pertencente ao id informado)
    - Exemplo: ```http://localhost:8182/api/planetas/5e2f6c649a90812d6c324407```
``` 
{
    "id": "5e2f6c649a90812d6c324407",
    "nome": "Alderaan",
    "clima": "temperate",
    "terreno": "grasslands, mountains",
    "aparicoesEmFilmes": 2
}
```
- GET: ```http://localhost:8182/api/planetas/?nome={nome}``` (Retorna o planeta pertencente ao nome informado)
    - Exemplo:  ```http://localhost:8182/api/planetas/?nome=Coruscant```
``` 
{
    "id": "5e2f6c649a90812d6c324406",
    "nome": "Coruscant",
    "clima": "temperate",
    "terreno": "cityscape, mountains",
    "aparicoesEmFilmes": 4
}
```
- GET: ```http://localhost:8182/swapi/planetas/?pagina={pagina}``` (Retorna os planetas da API Externa do StarWars que estão na página informada)
    - Exemplo:  ```http://localhost:8182/swapi/planetas/?pagina=2```
``` 
{
    "count": 61,
    "next": "https://swapi.co/api/planets/?page=3",
    "previous": "https://swapi.co/api/planets/?page=1",
    "results": [
        {
            "name": "Utapau",
            "rotation_period": "27",
            "orbital_period": "351",
            "diameter": "12900",
            "climate": "temperate, arid, windy",
            "gravity": "1 standard",
            "terrain": "scrublands, savanna, canyons, sinkholes",
            "surface_water": "0.9",
            "population": "95000000",
            "residents": [
                "https://swapi.co/api/people/83/"
            ],
            "films": [
                "https://swapi.co/api/films/6/"
            ],
            "created": "2014-12-10T12:49:01.491000Z",
            "edited": "2014-12-20T20:58:18.439000Z",
            "url": "https://swapi.co/api/planets/12/"
        },
        {
            "name": "Mustafar",
            "rotation_period": "36",
            "orbital_period": "412",
            "diameter": "4200",
            "climate": "hot",
            "gravity": "1 standard",
            "terrain": "volcanoes, lava rivers, mountains, caves",
            "surface_water": "0",
            "population": "20000",
            "residents": [],
            "films": [
                "https://swapi.co/api/films/6/"
            ],
            "created": "2014-12-10T12:50:16.526000Z",
            "edited": "2014-12-20T20:58:18.440000Z",
            "url": "https://swapi.co/api/planets/13/"
        },
        {
            "name": "Kashyyyk",
            "rotation_period": "26",
            "orbital_period": "381",
            "diameter": "12765",
            "climate": "tropical",
            "gravity": "1 standard",
            "terrain": "jungle, forests, lakes, rivers",
            "surface_water": "60",
            "population": "45000000",
            "residents": [
                "https://swapi.co/api/people/13/",
                "https://swapi.co/api/people/80/"
            ],
            "films": [
                "https://swapi.co/api/films/6/"
            ],
            "created": "2014-12-10T13:32:00.124000Z",
            "edited": "2014-12-20T20:58:18.442000Z",
            "url": "https://swapi.co/api/planets/14/"
        },
        {
            "name": "Polis Massa",
            "rotation_period": "24",
            "orbital_period": "590",
            "diameter": "0",
            "climate": "artificial temperate ",
            "gravity": "0.56 standard",
            "terrain": "airless asteroid",
            "surface_water": "0",
            "population": "1000000",
            "residents": [],
            "films": [
                "https://swapi.co/api/films/6/"
            ],
            "created": "2014-12-10T13:33:46.405000Z",
            "edited": "2014-12-20T20:58:18.444000Z",
            "url": "https://swapi.co/api/planets/15/"
        },
        {
            "name": "Mygeeto",
            "rotation_period": "12",
            "orbital_period": "167",
            "diameter": "10088",
            "climate": "frigid",
            "gravity": "1 standard",
            "terrain": "glaciers, mountains, ice canyons",
            "surface_water": "unknown",
            "population": "19000000",
            "residents": [],
            "films": [
                "https://swapi.co/api/films/6/"
            ],
            "created": "2014-12-10T13:43:39.139000Z",
            "edited": "2014-12-20T20:58:18.446000Z",
            "url": "https://swapi.co/api/planets/16/"
        },
        {
            "name": "Felucia",
            "rotation_period": "34",
            "orbital_period": "231",
            "diameter": "9100",
            "climate": "hot, humid",
            "gravity": "0.75 standard",
            "terrain": "fungus forests",
            "surface_water": "unknown",
            "population": "8500000",
            "residents": [],
            "films": [
                "https://swapi.co/api/films/6/"
            ],
            "created": "2014-12-10T13:44:50.397000Z",
            "edited": "2014-12-20T20:58:18.447000Z",
            "url": "https://swapi.co/api/planets/17/"
        },
        {
            "name": "Cato Neimoidia",
            "rotation_period": "25",
            "orbital_period": "278",
            "diameter": "0",
            "climate": "temperate, moist",
            "gravity": "1 standard",
            "terrain": "mountains, fields, forests, rock arches",
            "surface_water": "unknown",
            "population": "10000000",
            "residents": [
                "https://swapi.co/api/people/33/"
            ],
            "films": [
                "https://swapi.co/api/films/6/"
            ],
            "created": "2014-12-10T13:46:28.704000Z",
            "edited": "2014-12-20T20:58:18.449000Z",
            "url": "https://swapi.co/api/planets/18/"
        },
        {
            "name": "Saleucami",
            "rotation_period": "26",
            "orbital_period": "392",
            "diameter": "14920",
            "climate": "hot",
            "gravity": "unknown",
            "terrain": "caves, desert, mountains, volcanoes",
            "surface_water": "unknown",
            "population": "1400000000",
            "residents": [],
            "films": [
                "https://swapi.co/api/films/6/"
            ],
            "created": "2014-12-10T13:47:46.874000Z",
            "edited": "2014-12-20T20:58:18.450000Z",
            "url": "https://swapi.co/api/planets/19/"
        },
        {
            "name": "Stewjon",
            "rotation_period": "unknown",
            "orbital_period": "unknown",
            "diameter": "0",
            "climate": "temperate",
            "gravity": "1 standard",
            "terrain": "grass",
            "surface_water": "unknown",
            "population": "unknown",
            "residents": [
                "https://swapi.co/api/people/10/"
            ],
            "films": [],
            "created": "2014-12-10T16:16:26.566000Z",
            "edited": "2014-12-20T20:58:18.452000Z",
            "url": "https://swapi.co/api/planets/20/"
        },
        {
            "name": "Eriadu",
            "rotation_period": "24",
            "orbital_period": "360",
            "diameter": "13490",
            "climate": "polluted",
            "gravity": "1 standard",
            "terrain": "cityscape",
            "surface_water": "unknown",
            "population": "22000000000",
            "residents": [
                "https://swapi.co/api/people/12/"
            ],
            "films": [],
            "created": "2014-12-10T16:26:54.384000Z",
            "edited": "2014-12-20T20:58:18.454000Z",
            "url": "https://swapi.co/api/planets/21/"
        }
    ]
}
```
- GET: ```http://localhost:8182/swapi/planeta/{id}``` (Retorna o planeta da API Externa do StarWars pertencente ao id informado)
    - Exemplo:  ```http://localhost:8182/swapi/planeta/6```
``` 
{
    "name": "Bespin",
    "rotation_period": "12",
    "orbital_period": "5110",
    "diameter": "118000",
    "climate": "temperate",
    "gravity": "1.5 (surface), 1 standard (Cloud City)",
    "terrain": "gas giant",
    "surface_water": "0",
    "population": "6000000",
    "residents": [
        "https://swapi.co/api/people/26/"
    ],
    "films": [
        "https://swapi.co/api/films/2/"
    ],
    "created": "2014-12-10T11:43:55.240000Z",
    "edited": "2014-12-20T20:58:18.427000Z",
    "url": "https://swapi.co/api/planets/6/"
}
```
- POST: ```http://localhost:8182/api/planetas``` (Cadastra um novo planeta)
``` 
{
    "nome": "Bespin",
    "clima": "temperate",
    "terreno": "gas giant"
}
```
- DELETE: ```http://localhost:8182/api/planetas/{id}``` (Deleta o planeta pertencente ao id informado)
    - Exemplo:  ```http://localhost:8182/api/planetas/5e2f6c649a90812d6c324407```

### May the force be with you!
