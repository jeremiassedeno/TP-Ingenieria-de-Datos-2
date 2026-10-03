package com.tp;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

public class Neo4jConnection implements AutoCloseable {

    private static final String URI =
            "bolt://localhost:7687";

    private static final String USER =
            "neo4j";

    private static final String PASSWORD =
            "PasswordPrueba"; // Cambia esto por tu contraseña real

    private Driver driver;

    public void connect() {

        driver = GraphDatabase.driver(
                URI,
                AuthTokens.basic(
                        USER,
                        PASSWORD
                )
        );

        driver.verifyConnectivity();

        System.out.println(
                "Neo4j conectado correctamente."
        );
    }

    public Driver getDriver() {
        return driver;
    }

    public void close() {

        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}