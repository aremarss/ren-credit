package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static java.sql.DriverManager.getConnection;

public class DBHelper {
    private final static QueryRunner queryRunner = new QueryRunner();
    private final static Connection conn = connection();
    private static final String url = "jdbc:postgresql://localhost:5432/db";
    private static final String user = "user";
    private static final String password = "pass";

    @SneakyThrows
    private static Connection connection() {
        return getConnection(url, user, password);
    }

    @SneakyThrows
    public static void setStartStep(String name) {
        queryRunner.update(conn,
                "INSERT INTO steps (step_start_time,step_end_time,step_name) " +
                        "VALUES (?, 'В процессе прохождения', ?)",
                generateDate(), name);
    }

    @SneakyThrows
    public static void setEndStep() {
        queryRunner.update(conn, "UPDATE steps " +
                        "SET step_end_time = ? " +
                        "WHERE step_end_time = 'В процессе прохождения'",
                generateDate());
    }

    @SneakyThrows
    public static void deleteDB() {
        queryRunner.update(conn, "DELETE FROM steps");
    }

    private static String generateDate() {
        return LocalDateTime.now().format(DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
}