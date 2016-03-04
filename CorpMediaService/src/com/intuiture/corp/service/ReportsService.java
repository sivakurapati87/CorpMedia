package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.Reports;
import com.intuiture.corp.json.ReportsJson;
import com.intuiture.corp.util.TransformJsonToDomain;
@Service
@Transactional
public class ReportsService {
	
	@Autowired
	private CommonRepository commonRepository;
	
	public Boolean saveOrUpdateReports(ReportsJson reportsJson) {
		Reports reports = null;
		try {
			if (reportsJson != null) {
				// This is to insert the data to professional Info Table
				if (reportsJson.getReportsId() != null) {
					reports = (Reports) commonRepository.findById(reportsJson.getReportsId(), Reports.class);
				} else {
					reports = new Reports();
				}
				TransformJsonToDomain.getReports(reports, reportsJson);
				if (reportsJson.getReportsId() != null) {
					commonRepository.update(reports);
				} else {
					commonRepository.persist(reports);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}


}
