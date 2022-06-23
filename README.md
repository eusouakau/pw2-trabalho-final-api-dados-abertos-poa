# matriculas-escolas Project

## Site da API
http://datapoa.com.br/dataset/sie/resource/5b5bc272-6666-4d24-8ddd-138fea511809

## Modelo
https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={%22_id%22:%225%22}

## Pesquisar: filters e datastore_search
https://docs.ckan.org/en/latest/maintaining/datastore.html?highlight=filters#downloading-resources

## Testes
http://localhost:3333/matriculas-escolas/findByCodigo/5

https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={%22_id%22:5}

https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={"_id":5}

https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={%22codigo%22:%22250%22}&fields=nome

https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={"codigo":"250"}&fields=nome

https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&fields

## Dados
cadastro-escolas : 
matrículas-escolas : https://raw.githubusercontent.com/eusouakau/pw2-trabalho-final-api-dados-abertos-poa/master/matriculas_escolas.json
servidores-ativos: 
