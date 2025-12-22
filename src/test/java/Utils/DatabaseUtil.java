package Utils;
import java.sql.*;
public class DatabaseUtil {
    // Oracle/Snowflake Connection String
    static final String DB_URL = "ep-twilight-frog-adaoukwz-pooler.c-2.us-east-1.aws.neon.tech";
    static final String USER = "neondb_owner";
    static final String PASS = "npg_hin54oySzNeJ";

    public static String getId(String id) {
        String status = null;
        String query = "SELECT * FROM ff14skills WHERE id > 500";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Parameterized Query (Prevents SQL Injection)
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                status = rs.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
