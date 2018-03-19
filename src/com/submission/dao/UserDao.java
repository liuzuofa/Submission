package com.submission.dao;

import java.util.List;

import com.submission.entity.User;

public interface UserDao {
	// 用户登录
	public User loginUser(String email, String password);

	// 注册用户
	public int registerUser(User user);

	// 修改个人信息
	public int ChangeInfo(User user);

	// 修改密码
	public int ChangePassword(User user, String newPassword);
	
	//根据用户类型获得所以用户
	public List<User> getAllUserByType(String type);
	
	//根据用户状态获得所以用户
	public List<User> getAllUserByState(String state);
	
	//获得所有用户
	public List<User> getAllUser();
	
	//根据id获取用户
	public User getUserById(int id);
	
	//根据id删除用户
	public int deleteUser(int id);
	
	//根据id更新用户状态
	public int updateUserStateById(int id, String type, String state);

}
