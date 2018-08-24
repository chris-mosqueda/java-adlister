import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;


public class MySQLAdsDao implements Ads{
    private Connection connection;

    // make connection with config class
    public MySQLAdsDao(Config config) {
        try {
            // need to import correct driver pckg
            DriverManager.registerDriver(new Driver());
            // makes connection w/ Config.java class
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
            // stmt executes the sql (query)
            ResultSet rs = stmt.executeQuery(selectQry);
            // make a new list to add to and return
            List<Ad> newList = new ArrayList<>();
                // can make into another method -
                // private List<Ad> createList(ResultSet rs){...}
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
            // will halt execution of everything else if there is an error
            throw new RuntimeException("Problem buidling");
        }
    }

    // can make a main method to test connection before anything else
//    psv main(){
//        Config config = new Config();
//        MySQLAdsDao adsDao = new MySQLAdsDao(config);
//        List<Ad> ads = adsDao.all();
//        //getter methods
//        String testSHow = ads.get(0).getTitle(); //- will show the first title in db
//        System.out.println(testSHow);
//    }

    @Override
    // giving insert method an Ad Obj (ad)
    public long insert(Ad ad) {
        try {
            Statement stmt = connection.createStatement();
            // String query = String.format("Insert into ...() values(%d, '%s', '%s')",
            // ad.getUserId(),
            // ad.getTitle(),
            // ad.getDescription());
            String query = "INSERT INTO ads(user_id, title, description) VALUES ('"+ad.getUserId()+"', '"+ad.getTitle()+"','"+ ad.getDescription()+"');";
                                    //below gets the last inserted keys
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            //to get result set have to run a separate method, .getGenratedKeys()
            ResultSet genKeys = stmt.getGeneratedKeys();
            genKeys.next();
            return genKeys.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
            // will halt execution of everything else if there is an error
            throw new RuntimeException("Problem buidling");
        }
    }
}
