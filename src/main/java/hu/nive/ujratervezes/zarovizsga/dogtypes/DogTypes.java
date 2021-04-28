package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.*;

public class DogTypes {

    private MariaDbDataSource dataSource;

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        List<String> dogTypes = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("select name from dog_types where country=?")
                )
        {
            ps.setString(1, country.toUpperCase());
            getResult(dogTypes, ps);
            Collections.sort(dogTypes, Collator.getInstance(new Locale("hu", "HU")));
            return dogTypes;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect", e);
        }
    }

    private void getResult(List<String> dogTypes, PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                dogTypes.add(rs.getString("name").toLowerCase());
            }
        }
    }
}
