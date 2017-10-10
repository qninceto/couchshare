package ittalents.couchshare.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractCityDAO extends AbstractDBConnDAO {
	public static int getCityId(String cityName, String countryName) {
		try {
			//TODO s prepared statement tuk!
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery(
					"select city.id  from cities city join countries c on(city.countries_id=c.id) where city.city_name='"
							+ cityName + "' and c.country_name='" + countryName + "';");
			resultSet.next();
			int id = resultSet.getInt(1);
			System.out.println("*"+id);
			return id;

		} catch (SQLException e) {
			// TODO throw wrapped exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public static String getCityName(int cityId) {
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("select city_name from cities where id="+cityId);
			resultSet.next();
			String name = resultSet.getString(1);

			return name;

		} catch (SQLException e) {
			// TODO throw wrapped exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getCountryName(int cityId) {
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("select c.country_name from cities city join countries c on(city.countries_id=c.id) where city.id="+cityId);
			resultSet.next();
			String name = resultSet.getString(1);

			return name;

		} catch (SQLException e) {
			// TODO throw wrapped exception
			e.printStackTrace();
		}
		return null;
	}
}
