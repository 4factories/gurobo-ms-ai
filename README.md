ff-ai
=======

Microservizio Spring Boot per la gestione e l'esecuzione dei job pianificati
all'interno della piattaforma 4Factories.

Il servizio gestisce task schedulati e configurazioni ai persistite su database,
integrandosi con gli altri microservizi della piattaforma e con i servizi comuni
Gurobo per configurazione, sicurezza, service discovery e monitoraggio.

------------------------------------------------------------
Funzionalità principali
------------------------------------------------------------
- Gestione dei job schedulati
- Esecuzione di task periodici tramite Spring Scheduling
- Persistenza delle configurazioni tramite Spring Data JPA
- Gestione dello schema database tramite Liquibase
- Integrazione con gli altri microservizi 4Factories
- Registrazione e service discovery tramite Consul
- Health check e monitoraggio tramite Spring Boot Actuator
- Logging e tracciabilità delle esecuzioni

------------------------------------------------------------
Stack principale
------------------------------------------------------------
- Java 25+
- Spring Boot 4.1+
- Spring Data JPA
- Hibernate ORM
- PostgreSQL
- Liquibase
- Spring Cloud Consul
- Spring Boot Actuator
- Lombok

------------------------------------------------------------
Configurazione
------------------------------------------------------------

Il microservizio utilizza le configurazioni comuni definite nei moduli base Gurobo.

Configurazione standard:

- Porta applicativa: 80
- Porta management: 8081
- Actuator base path: /api/actuator
- Endpoint Actuator esposti: health, info, metrics
- Service discovery: Consul
- Database: PostgreSQL
- Migrazione database: Liquibase

Le configurazioni specifiche dell'ambiente vengono fornite tramite variabili
d'ambiente e Docker Compose.

Principali variabili utilizzate:

PROFILO
SERVER_PORT
MANAGEMENT_PORT
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
HIBERNATE_SHOW_SQL
GATEWAY_BASE_URL

------------------------------------------------------------
Actuator
------------------------------------------------------------

Gli endpoint di management vengono esposti sulla porta dedicata 8081.

Health check:

http://<host>:8081/api/actuator/health

Il relativo endpoint viene utilizzato anche da Consul per verificare lo stato
del microservizio.

------------------------------------------------------------
Database
------------------------------------------------------------

Il servizio utilizza PostgreSQL tramite Spring Data JPA.

Lo schema del database viene validato da Hibernate e gestito tramite Liquibase.

Il changelog Liquibase viene caricato dalla configurazione comune Gurobo.

------------------------------------------------------------
Service Discovery
------------------------------------------------------------

Il microservizio viene registrato su Consul come servizio applicativo.

La registrazione utilizza:

- servizio applicativo sulla porta 80
- endpoint health sulla porta management 8081

------------------------------------------------------------
Build
------------------------------------------------------------

mvn clean install -DskipTests

------------------------------------------------------------
Docker
------------------------------------------------------------

Il microservizio viene distribuito come JAR eseguibile all'interno di un
container Docker basato su Eclipse Temurin Java 25.


------------------------------------------------------------
Licenza
------------------------------------------------------------

Proprietà Gurobo S.r.l.s. – uso interno alla piattaforma 4Factories.