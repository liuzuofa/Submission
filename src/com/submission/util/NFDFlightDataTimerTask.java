package com.submission.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

import com.submission.dao.MagazineDao;
import com.submission.dao.impl.MagazineDaoImpl;
import com.submission.entity.Magazine;

public class NFDFlightDataTimerTask  extends TimerTask {
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void run() {
        try {
            //在这里写你要执行的内容
        	MagazineDao magaineDao = new MagazineDaoImpl();
        	List<Magazine> magazineList = new ArrayList<>();
        	magazineList = magaineDao.getAllMagazineByState("待审");
        	for (Magazine magazine : magazineList) {
				String submissionTime = magazine.getSubmission_time();
				int day = Utils.calculateTime(submissionTime);
				System.out.println("day = " + day);
			}
            System.out.println("执行当前时间"+formatter.format(Calendar.getInstance().getTime()));
        } catch (Exception e) {
            System.out.println("-------------解析信息发生异常--------------");
        }
    }
}
