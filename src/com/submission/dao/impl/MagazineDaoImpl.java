package com.submission.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.submission.dao.MagazineDao;
import com.submission.entity.Magazine;
import com.submission.util.DBUtil;

public class MagazineDaoImpl extends DBUtil implements MagazineDao {
	
	@Override
	public int addMagazine(Magazine magazine) {
		String sql = "insert into magazine (name,summary,author,state,address,subject,submission_time) values(?,?,?,?,?,?,?)";
		return super.execUpdate(sql,magazine.getName(),magazine.getSummary(),magazine.getAuthor(),
				magazine.getState(),magazine.getAddress(),magazine.getSubject(),magazine.getSubmission_time());
	}
	
	@Override
	public int updateMagazine(Magazine magazine) {
		String sql = "update magazine set state = ? , address = ? where id = ? ";
		return super.execUpdateBackId(sql,magazine.getState(),magazine.getAddress(),magazine.getId());
	}

	@Override
	public Magazine getMagazineById(int id) {
		// TODO Auto-generated method stub
		String sql = " select * from magazine where id = ? ";
		ResultSet rs =super.execQuery(sql,id);
		Magazine magazine = null;
		try {
			if(rs.next()){
				int id1 = rs.getInt(1);
				String name = rs.getString(2);
				String summary = rs.getString(3);
				String author = rs.getString(4);
				String state = rs.getString(5);
				String address = rs.getString(6);
				String subject = rs.getString(7);
				String submission_time = rs.getString(8);
				String review_time = rs.getString(9);
				String reject_time = rs.getString(10);
				String pubish_time = rs.getString(11);
				String editor = rs.getString(12);
				String expert = rs.getString(13);
				String editor_advise = rs.getString(14);
				String expert_advise = rs.getString(15);
				int periodical_id = rs.getInt(16);
				magazine = new Magazine(id1, name, summary, author, state, address, 
						subject, submission_time, review_time, reject_time, pubish_time, 
						editor, expert, editor_advise,expert_advise,periodical_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return magazine;
	}
	
	@Override
	public int updateMagazineStateById(int id,String state) {
		String sql = "update magazine set state = ? where id = ? ";
		return super.execUpdate(sql, state, id);
	}
	
	@Override
	public int updateMagazineReviewTimeById(int id, String time) {
		String sql = "update magazine set review_time = ? where id = ? ";
		return super.execUpdate(sql, time, id);
	}
	
	@Override
	public int updateMagazinePublishTimeByPeriodicalId(int periodicalId, String time) {
		String sql = "update magazine set publish_time = ? where periodical_id = ? ";
		return super.execUpdate(sql, time, periodicalId);
	}
	
	@Override
	public int updateMagazineStateAndAdviseById(int id, String state, String advise, String userType) {
		String sql = "update magazine set state = ?, editor_advise = ? where id = ? ";
		String sql1 = "update magazine set state = ?, expert_advise = ? where id = ? ";
		if ("editor".equals(userType)) {
			return super.execUpdate(sql, state, advise, id);
		}
		return super.execUpdate(sql1, state, advise, id);
	}
	
	@Override
	public int updateMagazineStateRejectTimeAndAdviseById(int id, String state, String rejectTime, String advise, String userType) {
		String sql = "update magazine set state = ?, reject_time = ?, editor_advise = ? where id = ? ";
		String sql1 = "update magazine set state = ?, reject_time = ?, expert_advise = ? where id = ? ";
		if ("editor".equals(userType)) {
			return super.execUpdate(sql, state, rejectTime,advise, id);
		}
		return super.execUpdate(sql1, state, rejectTime,advise, id);
	}
	
	@Override
	public int updateMagazineEditorAndExpertById(int id, String editor, String expert) {
		String sql = "update magazine set editor = ? , expert = ? , state = '专家待审'  where id = ? ";
		return super.execUpdate(sql,editor,expert,id);
	}
	
	@Override
	public int updateMagazineStateAndPeriodicalIdById(String state, int magazineId, int periodicalId) {
		String sql = "update magazine set state = ? , periodical_id = ?  where id = ? ";
		return super.execUpdate(sql,state,periodicalId, magazineId);
	}
	
	@Override
	public int deletePeriodicalIdById(int id) {
		String sql = "update magazine set periodical_id = 0  where id = ? ";
		return super.execUpdate(sql,id);
	}

	@Override
	public List<Magazine> getAllMagazineByState(String state) {
		String sql = " select * from magazine where state like ? ";
		ResultSet rs =super.execQuery(sql, "%"+state+"%");
		List<Magazine> magazines = new ArrayList<>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String summary = rs.getString(3);
				String author = rs.getString(4);
				String state1 = rs.getString(5);
				String address = rs.getString(6);
				String subject = rs.getString(7);
				String submission_time = rs.getString(8);
				String review_time = rs.getString(9);
				String reject_time = rs.getString(10);
				String pubish_time = rs.getString(11);
				String editor = rs.getString(12);
				String expert = rs.getString(13);
				String editor_advise = rs.getString(14);
				String expert_advise = rs.getString(15);
				int periodical_id = rs.getInt(16);
				Magazine magazine = new Magazine(id, name, summary, author, state1, address, 
						subject, submission_time, review_time, reject_time, pubish_time, 
						editor, expert, editor_advise,expert_advise,periodical_id);
				magazines.add(magazine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return magazines;
	}
	
	@Override
	public List<Magazine> getAllMagazineByPeriodicalId(int periodicalId) {
		String sql = " select * from magazine where periodical_id = ? ";
		ResultSet rs =super.execQuery(sql, periodicalId);
		List<Magazine> magazines = new ArrayList<>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String summary = rs.getString(3);
				String author = rs.getString(4);
				String state1 = rs.getString(5);
				String address = rs.getString(6);
				String subject = rs.getString(7);
				String submission_time = rs.getString(8);
				String review_time = rs.getString(9);
				String reject_time = rs.getString(10);
				String pubish_time = rs.getString(11);
				String editor = rs.getString(12);
				String expert = rs.getString(13);
				String editor_advise = rs.getString(14);
				String expert_advise = rs.getString(15);
				int periodical_id = rs.getInt(16);
				Magazine magazine = new Magazine(id, name, summary, author, state1, address, 
						subject, submission_time, review_time, reject_time, pubish_time, 
						editor, expert, editor_advise,expert_advise,periodical_id);
				magazines.add(magazine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return magazines;
	}
	
	@Override
	public List<Magazine> getAllMagazineByStateAndPeriodicalId(String state, int periodicalId) {
		String sql = " select * from magazine where state like ? and periodical_id = ? ";
		ResultSet rs =super.execQuery(sql, "%"+state+"%", periodicalId);
		List<Magazine> magazines = new ArrayList<>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String summary = rs.getString(3);
				String author = rs.getString(4);
				String state1 = rs.getString(5);
				String address = rs.getString(6);
				String subject = rs.getString(7);
				String submission_time = rs.getString(8);
				String review_time = rs.getString(9);
				String reject_time = rs.getString(10);
				String pubish_time = rs.getString(11);
				String editor = rs.getString(12);
				String expert = rs.getString(13);
				String editor_advise = rs.getString(14);
				String expert_advise = rs.getString(15);
				int periodical_id = rs.getInt(16);
				Magazine magazine = new Magazine(id, name, summary, author, state1, address, 
						subject, submission_time, review_time, reject_time, pubish_time, 
						editor, expert, editor_advise,expert_advise,periodical_id);
				magazines.add(magazine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return magazines;
	}
	
	@Override
	public List<Magazine> getAllMagazineByStateAndAuthor(String state, String author) {
		String sql = " select * from magazine where state like ? and author = ? ";
		ResultSet rs =super.execQuery(sql,"%"+state+"%",author);
		List<Magazine> magazines = new ArrayList<>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String summary = rs.getString(3);
				String author1 = rs.getString(4);
				String state1 = rs.getString(5);
				String address = rs.getString(6);
				String subject = rs.getString(7);
				String submission_time = rs.getString(8);
				String review_time = rs.getString(9);
				String reject_time = rs.getString(10);
				String pubish_time = rs.getString(11);
				String editor = rs.getString(12);
				String expert = rs.getString(13);
				String editor_advise = rs.getString(14);
				String expert_advise = rs.getString(15);
				int periodical_id = rs.getInt(16);
				Magazine magazine = new Magazine(id, name, summary, author1, state1, address, 
						subject, submission_time, review_time, reject_time, pubish_time, 
						editor, expert, editor_advise,expert_advise,periodical_id);
				magazines.add(magazine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return magazines;
	}
	
	@Override
	public List<Magazine> getAllMagazineByStateAndExpert(String state, String expert) {
		String sql = " select * from magazine where state like ? and expert = ? ";
		ResultSet rs =super.execQuery(sql,"%"+state+"%",expert);
		List<Magazine> magazines = new ArrayList<>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String summary = rs.getString(3);
				String author = rs.getString(4);
				String state1 = rs.getString(5);
				String address = rs.getString(6);
				String subject = rs.getString(7);
				String submission_time = rs.getString(8);
				String review_time = rs.getString(9);
				String reject_time = rs.getString(10);
				String pubish_time = rs.getString(11);
				String editor = rs.getString(12);
				String expert1 = rs.getString(13);
				String editor_advise = rs.getString(14);
				String expert_advise = rs.getString(15);
				int periodical_id = rs.getInt(16);
				Magazine magazine = new Magazine(id, name, summary, author, state1, address, 
						subject, submission_time, review_time, reject_time, pubish_time, 
						editor, expert1, editor_advise,expert_advise,periodical_id);
				magazines.add(magazine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return magazines;
	}
}
