package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanyLocationRepository;
import com.intuiture.corp.entity.LeavesNotify;
import com.intuiture.corp.json.LeavesNotifyJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class NotifyService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CompanyLocationRepository companyLocationRepository;

	public Boolean addNotify(LeavesNotifyJson leavesNotifyJson) {
		LeavesNotify leavesNotify = null;
		try {
			if (leavesNotifyJson.getLeavesNotifyId() != null) {
				leavesNotify = (LeavesNotify) commonRepository.findById(leavesNotifyJson.getLeavesNotifyId(), LeavesNotify.class);
			} else {
				leavesNotify = new LeavesNotify();
			}
			TransformJsonToDomain.getLeavesNotify(leavesNotify, leavesNotifyJson);
			if (leavesNotifyJson.getLeavesNotifyId() != null) {
				commonRepository.update(leavesNotify);
			} else {
				commonRepository.persist(leavesNotify);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<LeavesNotifyJson> getAllNotifiersList(Integer companyId) {
		List<LeavesNotifyJson> notifyJsonList = null;
		try {
			List<LeavesNotify> notifiesList = (List<LeavesNotify>) commonRepository.getAllRecordsByCompanyId(companyId, LeavesNotify.class);
			if (notifiesList != null && notifiesList.size() > 0) {
				notifyJsonList = new ArrayList<LeavesNotifyJson>();
				for (LeavesNotify notify : notifiesList) {
					notifyJsonList.add(TransformDomainToJson.getNotifyJson(notify));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notifyJsonList;
	}

	public Boolean deleteNotify(Integer leavesNotifyId) {
		try {
			LeavesNotify leavesNotify = (LeavesNotify) commonRepository.findById(leavesNotifyId, LeavesNotify.class);
			if (leavesNotify != null) {
				leavesNotify.setIsDeleted(Boolean.TRUE);
				commonRepository.update(leavesNotify);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
