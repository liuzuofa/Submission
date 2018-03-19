package com.submission.dao;

import java.util.List;
import com.submission.entity.Periodical;

public interface PeriodicalDao {
		//新建期刊
		public int addPeriodical(Periodical periodical);
		
		//更新期刊状态
		public int updataPeriodicalStateById(int id, String state);
		
		//根据期刊状态查询所有的期刊
		public List<Periodical> getAllPeriodicalByState(String state);
		
		//根据期刊状态查询所有的期刊
		public List<Periodical> getAllPeriodical();
		
		//根据期刊id查询期刊
		public Periodical getPeriodicalById(int id);
		
		
}
