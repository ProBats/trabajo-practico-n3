package ar.org.centro8.java.curso.tests;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class TestConnection {

    public static void main(String[] args) {
        
        Properties props = new Properties();

        try (InputStream in = TestConnection.class
                                .getClassLoader()
                                .getResourceAsStream("application.properties")
                                ) {
            if (in == null) {
                System.out.println("No se encontro el application.properties en el classpath");
                return;
            }
            props.load(in);
        } catch (Exception e) {
            System.out.println("Error cargando propiedades: " + e.getMessage());
            return;
        }

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(props.getProperty("spring.datasource.url"));
        config.setUsername(props.getProperty("spring.datasource.username"));
        config.setPassword(props.getProperty("spring.datasource.password"));

        try (HikariDataSource ds = new HikariDataSource(config);
            Connection conn = ds.getConnection()) {
            if (conn.isValid(2)) {
                System.out.println("\nConexion exitosa a: " + conn.getMetaData().getURL()+"\n");
            } else{
                System.err.println("Conexion establecida pero no valida");
            }
        } catch (Exception e) {
            System.err.println("Error de conexion: " + e.getMessage());
        }
    }
}
