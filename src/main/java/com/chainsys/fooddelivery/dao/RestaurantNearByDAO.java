package com.chainsys.fooddelivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chainsys.fooddelivery.util.ConnectionUtil;

public class RestaurantNearByDAO {

	public int getUserCity() throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id = 0;
		try {
			String sql = "select city_id from users where user_id=1";
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("emp_id");
			}
		} catch (Exception e) {
			throw new Exception("unable to get id");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return id;

	}

}
