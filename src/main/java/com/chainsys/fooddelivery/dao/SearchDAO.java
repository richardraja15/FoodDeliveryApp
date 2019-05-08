package com.chainsys.fooddelivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.chainsys.fooddelivery.util.ConnectionUtil;

public class SearchDAO {

	public ArrayList<String> getRestaurant(String search) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<String> names = null;
		String name;
		try {
			String sql = " select restaurant_name from restauant where restaurant_name LIKE '?%';";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, search);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				name = resultSet.getString("restaurant_name");
				names.add(name);
			}
		} catch (Exception e) {
			throw new Exception();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return names;

	}

	public ArrayList<String> getMenu(String search) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<String> names = null;
		String name;
		try {
			String sql = " select name from trn_menu where name LIKE '?%';";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, search);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				name = resultSet.getString("name");
				names.add(name);
			}
		} catch (Exception e) {
			throw new Exception();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return names;

	}

}
