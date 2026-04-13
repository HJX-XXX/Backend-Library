public class DatabaseFactory {
    public static Database createDatabase(String type) {
        switch (type) {
            case "mysql":
                return new MySQL();
            case "PgSQL":
                return new PgSQL();
            default:
                throw new IllegalArgumentException("不支持");
        }
    }
}
