package com.submission.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.submission.dao.PeriodicalDao;
import com.submission.entity.Periodical;
import com.submission.util.DBUtil;

public class PeriodicalDaoImpl extends DBUtil implements PeriodicalDao {

	@Override
	public int addPeriodical(Periodical periodical) {
		String sql = "insert into periodical (year,month,state) values(?,?,?) ";
		return super.execUpdate(sql, periodical.getYear(), periodical.getMonth(), periodical.getState());
	}

	@Override
	public int updataPeriodicalStateById(int id, String state) {
		String sql = "update periodical set state = ? where id = ? ";
		return super.execUpdate(sql, state, id);
	}

	@Override
	public List<Periodical> getAllPeriodicalByState(String state) {
		String sql = " select * from Periodical where state = ? ";
		ResultSet rs =super.execQuery(sql,state);
		List<Periodical> periodicalList = new ArrayList<>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				String year = rs.getString(2);
				String month = rs.getString(3);
				String state1 = rs.getString(4);
				Periodical periodical = new Periodical(id, year, month, state1);
				periodicalList.add(periodical);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return periodicalList;
	}

	@Override
	public List<Periodical> getAllPeriodical() {
		String sql = " select * from Periodical ";
		ResultSet rs =super.execQuery(sql);
		List<Periodical> periodicalList = new ArrayList<>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				String year = rs.getString(2);
				String month = rs.getString(3);
				String state1 = rs.getString(4);
				Periodical periodical = new Periodical(id, year, month, state1);
				periodicalList.add(periodical);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return periodicalList;
	}

	@Override
	public Periodical getPeriodicalById(int id) {
		String sql = " select * from Periodical where id= ? ";
		ResultSet rs =super.execQuery(sql,id);
		Periodical periodical = null;
		try {
			if(rs.next()){
				int id1 = rs.getInt(1);
				String year = rs.getString(2);
				String month = rs.getString(3);
				String state = rs.getString(4);
				periodical = new Periodical(id1, year, month, state);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return periodical;
	}

}
