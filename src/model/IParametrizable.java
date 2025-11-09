package model;

public interface IParametrizable {
	public final String ip = "localhost", puerto = "3306", name_bbdd = "shop", user = "root", psw = "root",
			driver = "com.mysql.cj.jdbc.Driver";

	public default String getURL() {
		return String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s&useSSL=false&serverTimezone=UTC", ip, puerto,
				name_bbdd, user, psw);
	}

}
