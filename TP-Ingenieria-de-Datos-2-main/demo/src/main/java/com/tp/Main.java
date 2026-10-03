package com.tp;


public class Main {

    public static void main(String[] args) {
        System.out.println("Probando conexiones...");

        try (MongoDBConnection mongo = new MongoDBConnection()) {
            mongo.connect();
        } catch (Exception e) {
            System.err.println("Error en MongoDB:");
            e.printStackTrace();
        }

        try (CassandraConnection cassandra = new CassandraConnection()) {
            cassandra.connect();
        } catch (Exception e) {
            System.err.println("Error en Cassandra:");
            e.printStackTrace();
        }

        try (Neo4jConnection neo4j = new Neo4jConnection()) {
            neo4j.connect();
        } catch (Exception e) {
            System.err.println("Error en Neo4j:");
            e.printStackTrace();
        }

        System.out.println("Pruebas de conexión finalizadas.");
    }
}

