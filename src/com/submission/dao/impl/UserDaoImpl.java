package com.submission.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.submission.dao.UserDao;
import com.submission.entity.User;
import com.submission.util.DBUtil;

public class UserDaoImpl extends DBUtil implements UserDao {

	@Override
	public User loginUser(String email, String password) {
		String sql = "select * from user where email=? and password=?";
		ResultSet rs = super.execQuery(sql,email,password);
		User user = null;
		try {
			if(rs.next()){			
				int id = rs.getInt(1);
				String email1 = rs.getString(2);
				String password1 = rs.getString(3);
				String type = rs.getString(4);
				String name = rs.getString(5);
				String education = rs.getString(6);
				String tel = rs.getString(7);
				String address = rs.getString(8);
				String state = rs.getString(9);
				user = new User(id, email1, password1, type, name, education, tel, address,state);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int registerUser(User user) {
		String sql1 ="select * from user where email = ?"; 
		ResultSet rs =super.execQuery(sql1, user.getEmail());
		try {
			if(rs.next()){
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		String sql = "insert into user (email,password,type,name,education,tel,address,state) values(?,?,?,?,?,?,?,?)";
		int i = super.execUpdateBackId(sql, user.getEmail(),user.getPassword(),user.getType(),
				user.getName(),user.getEducation(),user.getTel(),user.getAddress(),user.getState());
		if (i> 0 && "读者".equals(user.getType())) {
			String sql2 = "insert into user_role (user_id,role_id) values(?,?) ";
			int ii = super.execUpdate(sql2, i,1);
			return ii;
		}
		return i;
	}

	@Override
	public int ChangeInfo(User user) {
		String sql = "update user set education =? ,tel = ? ,address = ? where email = ?";
		return super.execUpdate(sql,user.getEducation(),user.getTel(),user.getAddress(),user.getEmail());
	}

	@Override
	public int ChangePassword(User user, String newPassword) {
		String sql ="select password from user where email = ?"; 
		ResultSet rs =super.execQuery(sql, user.getEmail());
		try {
			if(rs.next()){
				String password = rs.getString(1);
				if (!password.equals(user.getPassword())) {
					return 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		String sql1 = "update user set password = ? where email = ?";
		return super.execUpdate(sql1,newPassword,user.getEmail());	
	}

	@Override
	public List<User> getAllUserByType(String type) {
		String sql = "select * from user where type = ? ";
		ResultSet rs = super.execQuery(sql,type);
		List<User> userList = new ArrayList<>();
		try {
			while (rs.next()){		
				int id = rs.getInt(1);
				String email1 = rs.getString(2);
				String password1 = rs.getString(3);
				String type1 = rs.getString(4);
				String name = rs.getString(5);
				String education = rs.getString(6);
				String tel = rs.getString(7);
				String address = rs.getString(8);
				String state = rs.getString(9);
				User user = new User(id, email1, password1, type1, name, education, tel, address,state);
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public List<User> getAllUserByState(String state) {
		String sql = "select * from user where state = ? ";
		ResultSet rs = super.execQuery(sql,state);
		List<User> userList = new ArrayList<>();
		try {
			while (rs.next()){		
				int id = rs.getInt(1);
				String email1 = rs.getString(2);
				String password1 = rs.getString(3);
				String type1 = rs.getString(4);
				String name = rs.getString(5);
				String education = rs.getString(6);
				String tel = rs.getString(7);
				String address = rs.getString(8);
				String state1 = rs.getString(9);
				User user = new User(id, email1, password1, type1, name, education, tel, address,state1);
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public List<User> getAllUser() {
		String sql = "select * from user ";
		ResultSet rs = super.execQuery(sql);
		List<User> userList = new ArrayList<>();
		try {
			while (rs.next()){		
				int id = rs.getInt(1);
				String email1 = rs.getString(2);
				String password1 = rs.getString(3);
				String type1 = rs.getString(4);
				String name = rs.getString(5);
				String education = rs.getString(6);
				String tel = rs.getString(7);
				String address = rs.getString(8);
				String state = rs.getString(9);
				User user = new User(id, email1, password1, type1, name, education, tel, address,state);
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User getUserById(int id) {
		String sql = "select * from user where id = ? ";
		ResultSet rs = super.execQuery(sql,id);
		User user = null;
		try {
			if(rs.next()){			
				int id1 = rs.getInt(1);
				String email1 = rs.getString(2);
				String password1 = rs.getString(3);
				String type = rs.getString(4);
				String name = rs.getString(5);
				String education = rs.getString(6);
				String tel = rs.getString(7);
				String address = rs.getString(8);
				String state = rs.getString(9);
				user = new User(id1, email1, password1, type, name, education, tel, address,state);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int deleteUser(int id) {
		String sql = "delete from user where id = ? ";
		return super.execUpdate(sql,id);
	}

	@Override
	public int updateUserStateById(int id, String type, String state) {
		String sql = "update user set state = ? where id = ? ";
		String sql2 = "insert into user_role (user_id,role_id) values(?,?) ";
		int i = super.execUpdate(sql, state, id);
		if (i > 0) {
			int userType = 1;
			if("编辑".endsWith(type)) {
				userType = 2;
			}else if("专家".endsWith(type)) {
				userType = 3;
			}else if("主编".endsWith(type)) {
				userType = 4;
			} 
			return super.execUpdate(sql2, id,userType);
		}
		return i;
	}

}
