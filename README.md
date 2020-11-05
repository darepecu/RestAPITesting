# RestAPITesting

Repositorio que realiza pruebas de RestApi de Google

## Pre-condiciones

Tener en la maquina instalado:
- JDK  1.8.0_242 
- Gradle 6.5.1
- Intellij u otro editor de texto

Para realizar ejecuciones desde Jenkins 
- Docekr 19.03.13 
- docker pull jenkins/jenkins:lts
- Añadir al gestor de plugins
  - Git plugin
  - Gradle plugin
  - HTML Publisher plugin
- Instalar al nodo Gradle 6.5.1 y el JDK 1.8.0_XXX
- Crear pipeline para que lea archivo JenkinsFile del Repositorio.

## Estructura del proyecto

En donde se dividen los Escenarios en sintaxis de Gherkin en el folder features, las definiciones de los pasos se ubican en StepDefinitions y las acciones que invocan estos pasos se encuentran en RequestController y BusinessController.

```
project
│   README.md
│   Jenkinsfile
│
└───src/test/resources
│   └───features
│       │   ....
|
│   └───schemas
│       │   ....
│   
└───src/test/java
│   └───steps
    │   BusinessController
    │   RequestController
    │   StepDefinitions
```

## Correr Test Autromatizados 

Para correr los test es necesario descargar el proyecto en local con el comando:

```bash
git clone git@github.com:darepecu/RestAPITesting.git 
```

Ingresar al folder

```bash
cd RestAPITesting
```

Correr comando de ejecución:

```bash
gradle clean test aggregate
```

Para realizar ejecuciones por Tag de Cucumber:

```bash
gradle clean test aggregate -Dcucumber.options="--tags @test"
```

Para modificar el ambiente donde se realiza  las ejecuciones, modificar la variable  -Denvironment (stg, prd, dev), por defecto se ejecuta stg:

```bash
gradle clean test aggregate -Dcucumber.options="--tags @test" -Denvironment=stg
```

## License
[MIT](https://choosealicense.com/licenses/mit/)
