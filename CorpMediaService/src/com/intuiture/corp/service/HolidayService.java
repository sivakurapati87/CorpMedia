package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanyLocationRepository;
import com.intuiture.corp.entity.Holidays;
import com.intuiture.corp.json.HolidaysJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class HolidayService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CompanyLocationRepository companyLocationRepository;

	public Boolean saveHoliday(HolidaysJson holidaysJson) {
		Holidays holidays = null;
		try {
			if (holidaysJson.getHolidaysId() != null) {
				holidays = (Holidays) commonRepository.findById(holidaysJson.getHolidaysId(), Holidays.class);
			} else {
				holidays = new Holidays();
			}
			TransformJsonToDomain.getHolidays(holidays, holidaysJson);
			if (holidaysJson.getHolidaysId() != null) {
				commonRepository.update(holidays);
			} else {
				commonRepository.persist(holidays);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<HolidaysJson> getAllHolidaysList(Integer companyId) {
		List<HolidaysJson> holidaysJsonList = null;
		try {
			List<Holidays> holidaysList = (List<Holidays>) commonRepository.getAllRecordsByCompanyId(companyId, Holidays.class);
			if (holidaysList != null && holidaysList.size() > 0) {
				holidaysJsonList = new ArrayList<HolidaysJson>();
				for (Holidays holidays : holidaysList) {
					holidaysJsonList.add(TransformDomainToJson.getHolidaysJson(holidays));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return holidaysJsonList;
	}

	public Boolean deleteHoliday(Integer holidayId) {
		try {
			Holidays holidays = (Holidays) commonRepository.findById(holidayId, Holidays.class);
			if (holidays != null) {
				holidays.setIsDeleted(Boolean.TRUE);
				commonRepository.update(holidays);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
