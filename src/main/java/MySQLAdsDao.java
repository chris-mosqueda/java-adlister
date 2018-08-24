import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;


public class MySQLAdsDao implements Ads{
    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword());
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        try {
            String selectQry = "SELECT * FROM ads";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(selectQry);
            List<Ad> newList = new ArrayList<>();
            while(rs.next()) {
                newList.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                        ));
            }
            return newList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Problem buidling");
        }
    }

    @Override
    public long insert(Ad ad) {
        try {
            String query = "INSERT INTO ads(user_id, title, description) VALUES ('"+ad.getUserId()+"', '"+ad.getTitle()+"','"+ ad.getDescription()+"');";
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Problem buidling");
        }
    }
}
