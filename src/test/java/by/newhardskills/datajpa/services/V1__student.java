package by.newhardskills.datajpa.services;

import by.newhardskills.datajpa.services.impl.StudentServiceImpl;
import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootTest
@ActiveProfiles({"local", "test"})
public class V1__student extends BaseJavaMigration {

    @Autowired
    private final StudentService studentService = new StudentServiceImpl();

    @BeforeAll
    static void init() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }

    @BeforeEach
    void migrate() throws Exception {

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "password"
        );

        migrate(new Context() {
            @Override
            public Configuration getConfiguration() {
                return new FluentConfiguration();
            }

            @Override
            public Connection getConnection() {
                return connection;
            }
        });
    }

    @Test
    void getCountOfAllStudentsTest() {
        Assertions.assertEquals(3, studentService.getCountOfAllStudents());
    }

    public void migrate(Context context) throws Exception {
        final String file = "src/test/resources/db/migration/V1_1__create_student.sql";
        final String file2 = "src/test/resources/db/migration/V1_2__add_student_data.sql";
        migrateFromFile(file, context.getConnection());
        migrateFromFile(file2, context.getConnection());
        context.getConnection().close();
    }

    private void migrateFromFile(String filename, Connection connection) throws SQLException, IOException {
        String line;
        Statement stmt = connection.createStatement();
        StringBuilder sql = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(Paths.get(filename).toFile()));
        while ((line = reader.readLine()) != null) {
            if (!line.startsWith("--")) {
                sql.append(line);
            }
            if (line.endsWith(";")) {
                stmt.execute(sql.toString());
                sql = new StringBuilder();
            }
        }
    }

}

