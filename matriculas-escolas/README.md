
# matriculas-escolas Project

## Sites da API
## Matriculas Escolas
http://datapoa.com.br/dataset/sie/resource/5b5bc272-6666-4d24-8ddd-138fea511809

## Cadastro Escolas
https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5579bc8e-1e47-47ef-a06e-9f08da28dec8

## Servidores Ativos
http://datapoa.com.br/dataset/folha-de-pagamento-servidores-ativos

## Modelo
https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={%22_id%22:%225%22}

## Pesquisar: filters, fields e datastore_search
https://docs.ckan.org/en/latest/maintaining/datastore.html?highlight=filters#downloading-resources

https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={%22codigo%22:%22250%22}&fields=nome

https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={%22codigo%22:%22250%22}

## Help API Ckan
https://dadosabertos.poa.br/api/3/action/help_show?name=datastore_search

## Documentations
https://docs.ckan.org/_/downloads/en/latest/pdf/

## Testes
http://localhost:3333/matriculas-escolas/findByCodigo/5

https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={%22_id%22:5}

https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={"_id":5}

https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={%22codigo%22:%22250%22}&fields=nome

https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={"codigo":"250"}&fields=nome

https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&fields

## Dados Git Raw
cadastro-escolas:
https://raw.githubusercontent.com/eusouakau/dados-abertos-poa-json/master/cadastro_escolas.json          

matrículas-escolas:
https://raw.githubusercontent.com/eusouakau/dados-abertos-poa-json/master/matriculas_escolas.json              

servidores-ativos:
https://raw.githubusercontent.com/eusouakau/dados-abertos-poa-json/master/servidores_ativos.json

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/matriculas-escolas-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and JPA
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing JAX-RS and more

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
