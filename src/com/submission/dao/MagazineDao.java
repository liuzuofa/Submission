package com.submission.dao;

import java.util.HashMap;
import java.util.List;

import com.submission.entity.Magazine;

public interface MagazineDao {
		//作者投稿--初次稿件
		public int addMagazine(Magazine magazine);
		
		//作者投稿--修改稿件
		public int updateMagazine(Magazine magazine);
		
		//根据id删除periodical id
		public int deleteMagazineById(int id);
		
		//通过稿件id查看稿件详细信息
		public Magazine getMagazineById(int id);
		
		//根据id更新稿件的状态
		public int updateMagazineStateById(int id, String state);
		
		//根据id更新稿件的审核时间
		public int updateMagazineReviewTimeById(int id, String time);
		
		//根据id更新稿件的出版时间
		public int updateMagazinePublishTimeByPeriodicalId(int periodicalId, String time);
		
		//根据id和用户类型更新稿件的状态、意见
		public int updateMagazineStateAndAdviseById(int id, String state, String advise, String userType);
		
		//根据id和用户类型更新稿件的状态、意见和拒时间
		public int updateMagazineStateRejectTimeAndAdviseById(int id, String state, String rejectTime, String advise, String userType);
				
		//根据id更新稿件的expert
		public int updateMagazineEditorAndExpertById(int id, String editor, String expert);
		
		//根据id更新状态和periodical id
		public int updateMagazineStateAndPeriodicalIdById(String state, int magazineId, int periodicalId);	
		
		//根据id删除periodical id
		public int deletePeriodicalIdById(int id);	
		
		//根据状态查询所有稿件
		public List<Magazine> getAllMagazineByState(String state);	
		
		//根据期刊id查询所有稿件
		public List<Magazine> getAllMagazineByPeriodicalId(int periodicalId);	
		
		//根据状态和期刊id查询所有稿件
		public List<Magazine> getAllMagazineByStateAndPeriodicalId(String state, int periodicalId);	
		
		//根据状态和名字查询所有稿件
		public List<Magazine> getAllMagazineByStateAndAuthor(String state, String author);	
		
		//根据状态和专家查询所有稿件
		public List<Magazine> getAllMagazineByStateAndExpert(String state, String expert);
		
		//获取技术类别
		public List<String> getAllSubject();
		
		//增加学科领域
		public int addSubject(String subject);
		
		//减少学科领域
		public int deleteSubject(String subject);
		
		//查询该学科领域下有多少专家
		public HashMap<String,Object> getSubjectExpert();
		
}
