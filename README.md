![Eclipse JNoSQL Artemis Project](https://github.com/JNOSQL/diana-site/blob/master/images/duke-artemis.png)
# Four databases types and an unique API that is the whole concept of Eclipse NoSQL

## Key-value

![Redis Project](https://jnosql.github.io/img/logos/redis.png)



**Redis**: Redis is a software project that implements data structure servers. It is open-source, networked, in-memory, and stores keys with optional durability.

### How To Install


![Docker](https://www.docker.com/sites/default/files/horizontal_large.png)


1. Install docker: https://www.docker.com/
1. https://store.docker.com/images/redis
1. Run docker command
1. `docker run --name redis-instance -p 6379:6379 -d redis`


## Column

![Cassandra Project](https://jnosql.github.io/img/logos/cassandra.png)


**Cassandra**: Apache Cassandra is a free and open-source distributed database management system designed to handle large amounts of data across many commodity servers, providing high availability with no single point of failure.


## Document

![Couchbase Project](https://jnosql.github.io/img/logos/couchbase.svg)


**Couchbase**: Couchbase Server, originally known as Membase, is an open-source, distributed multi-model NoSQL document-oriented database software package that is optimized for interactive applications.


### How To Install

![Docker](https://www.docker.com/sites/default/files/horizontal_large.png)


1. Install docker: https://www.docker.com/
1. https://hub.docker.com/r/couchbase/server/
1. Run docker command
1. `docker run -d --name couchbase-instance -p 8091-8094:8091-8094 -p 11210:11210 couchbase`
1. Follow the instructions: https://hub.docker.com/r/couchbase/server/
1. Create a **gods** bucket name
1. create an index running the query `CREATE PRIMARY INDEX index_gods on gods;`
1. Follow the instructions: https://developer.couchbase.com/documentation/server/current/fts/full-text-intro.html to create a index-diana full text index

## Graph

![Neo4J Project](http://www.jnosql.org/img/logos/neo4j.png)

Neo4j is a graph database management system developed by  Neo4j, Inc. Described by its developers as an ACID-compliant transactional database with native graph storage and processing, Neo4j is the most popular graph database according to db-engines.com. Neo4j is available in a GPL3-licensed open-source "community edition", with online backup and high availability extensions licensed under the terms of the Affero General Public License. Neo also licenses Neo4j with these extensions under closed-source commercial terms. Neo4j is implemented in Java and accessible from software written in other languages using the Cypher Query Language through a transactional HTTP endpoint, or through the binary 'bolt' protocol.

## Using Docker

![Docker](https://www.docker.com/sites/default/files/horizontal_large.png)


1. Install docker: https://www.docker.com/
1. https://store.docker.com/images/neo4j
1. Run docker command
1. `docker run --publish=7474:7474 --publish=7687:7687 --volume=$HOME/neo4j/data:/data neo4j`


Check the configuraion database such as user and password at jnosql.json at **src/main/resources/jnosql.json**