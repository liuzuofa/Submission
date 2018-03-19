package com.submission.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.submission.dao.MenuDao;
import com.submission.entity.Menu;
import com.submission.util.DBUtil;

public class MenuDaoImpl extends DBUtil implements MenuDao {

	@Override
	public List<Menu> getMenu(int id) {
		// TODO Auto-generated method stub
		String sql = "select name, path from permission where id = "
				+ "any (select permission_id from role_permission where role_id = "
				+ "(select role_id from user_role where user_id = ? ))";
		ResultSet rs =super.execQuery(sql, id);
		List<Menu> menuList = new ArrayList<>();
		try {
			while(rs.next()){
				String name = rs.getString(1);
				String path = rs.getString(2);
				Menu menu = new Menu(name, path);
				menuList.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuList;
	}

}
