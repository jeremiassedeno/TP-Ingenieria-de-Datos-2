package com.tp;

import com.datastax.oss.driver.api.core.CqlSession;

import java.net.InetSocketAddress;

public class CassandraConnection implements AutoCloseable {

    

    private CqlSession session;

    public void connect() {

        session = CqlSession.builder()
                .addContactPoint(
                        new InetSocketAddress("127.0.0.1", 9042)
                )
                .withLocalDatacenter("datacenter1")
                .build();

        String version = session
                .execute(
                        "SELECT release_version FROM system.local"
                )
                .one()
                .getString("release_version");

        System.out.println(
                "Cassandra conectado correctamente."
        );

        System.out.println(
                "Version Cassandra: " + version
        );
    }

    public CqlSession getSession() {
        return session;
    }

    public void close() {

         if (session != null) {
            session.close();
            session = null;
        }
    }
}