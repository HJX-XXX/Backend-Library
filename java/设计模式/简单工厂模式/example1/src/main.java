void main() {
    Database mySQL = DatabaseFactory.createDatabase("MySQL");
    Database pgSQL = DatabaseFactory.createDatabase("PgSQL");
    Database wrong = DatabaseFactory.createDatabase("wrong");
}