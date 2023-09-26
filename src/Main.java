// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        CREATE USER 'developer'@'localhost' IDENTIFIED BY 'password';
        FLUSH PRIVILEGES;

        CREATE USER 'viewer'@'localhost' IDENTIFIED BY 'password';
        FLUSH PRIVILEGES;

        CREATE USER 'writer'@'localhost' IDENTIFIED BY 'password';
        FLUSH PRIVILEGES;

        SELECT User FROM mysql.user;

        CREATE ROLE 'app_developer';
        CREATE ROLE 'app_read';
        CREATE ROLE 'app_write';

        GRANT ALL PRIVILEGES ON *.* TO 'app_developer';
        GRANT SELECT ON *.* TO 'app_read';
        GRANT INSERT, UPDATE, DELETE ON *.* TO 'app_write';

        GRANT 'app_developer' TO 'developer'@'localhost';
        GRANT 'app_read' TO 'viewer'@'localhost';
        GRANT 'app_write' TO 'writer'@'localhost';


        CREATE DATABASE IF NOT EXISTS newdb;

        GRANT ALL PRIVILEGES ON newdb.* TO 'developer'@'localhost';
        GRANT SELECT ON newdb.* TO 'viewer'@'localhost';
        GRANT INSERT, UPDATE, DELETE ON newdb.* TO 'writer'@'localhost';
        FLUSH PRIVILEGES;



    }
}