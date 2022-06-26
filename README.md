# Project Dados Abertos Poa

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
