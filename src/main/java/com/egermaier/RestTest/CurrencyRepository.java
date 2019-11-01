package com.egermaier.RestTest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CurrencyRepository {
	
	Connection con = null;
	
	//Připojení k databázi
	public CurrencyRepository() {
			
		String secondUrl = "jdbc:mysql://127.0.0.1:3306/restapidb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
		
		//TODO - doplnit údaje
		String username = "";
		String password = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(secondUrl,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Získání záznamů z DB tabulky
	public List<Currency> getCurrs() {
		List<Currency> currs = new ArrayList<>();
		String sql = "select * from currencies";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Currency c = new Currency();
				c.setAmount(rs.getDouble(1));
				c.setCnbMid(rs.getDouble(2));
				c.setCountry(rs.getString(3));
				c.setCurrencyBuy(rs.getDouble(4));
				c.setCurrencySell(rs.getDouble(5));
				c.setCurrMid(rs.getDouble(6));
				c.setMove(rs.getDouble(7));
				c.setName(rs.getString(8));
				c.setShortName(rs.getString(9));
				c.setValBuy(rs.getDouble(10));
				c.setValidFrom(rs.getDate(11));
				c.setValMid(rs.getDouble(12));
				c.setValSell(rs.getDouble(13));
				c.setVersion(rs.getDouble(14));
				currs.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currs;
	}

	//Tvorba záznámů v DB tabulce
	public void create(List<Currency> currs) {
		
		try {
			Statement s = con.createStatement();
			s.executeUpdate("truncate table currencies");
			for(Currency c : currs) {
			String sql = "insert into currencies values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setDouble(1, c.getAmount());
			st.setDouble(2, c.getCnbMid());
			st.setString(3, c.getCountry());
			st.setDouble(4, c.getCurrencyBuy());
			st.setDouble(5, c.getCurrencySell());
			st.setDouble(6, c.getCurrMid());
			st.setDouble(7, c.getMove());
			st.setString(8, c.getName());
			st.setString(9, c.getShortName());
			st.setDouble(10, c.getValBuy());
		
			java.sql.Date sqld = new java.sql.Date(c.getValidFrom().getTime());
			st.setDate(11,sqld);
			st.setDouble(12, c.getValMid());
			st.setDouble(13, c.getValSell());
			st.setDouble(14, c.getVersion());
			st.executeUpdate();
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
