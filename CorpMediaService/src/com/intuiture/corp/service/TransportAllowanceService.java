package com.intuiture.corp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.TransportAllowanceRepository;
import com.intuiture.corp.entity.TransportAllowance;
import com.intuiture.corp.json.TransportAllowanceJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class TransportAllowanceService {
	
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private TransportAllowanceRepository transportAllowanceRepository;
	
	
	
	public Boolean saveTransportAllowance(TransportAllowanceJson transportAllowanceJson) {
		TransportAllowance transportAllowance = null;

		
		try {
			if (transportAllowanceJson.getTransportAllowanceId() != null) {
				transportAllowance = transportAllowanceRepository.findbyId(transportAllowanceJson.getTransportAllowanceId());
			} else {
				transportAllowance = new TransportAllowance();
			}
			TransformJsonToDomain.getTransportAllowance(transportAllowance, transportAllowanceJson);
			if (transportAllowanceJson.getTransportAllowanceId() != null) {
				commonRepository.update(transportAllowance);
			} else {
				commonRepository.persist(transportAllowance);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public TransportAllowanceJson getTransportAllowanceList(Integer companyId) {
		TransportAllowanceJson transportAllowanceJson = null;
		try {
			List<TransportAllowance> transportAllowanceList = (List<TransportAllowance>) commonRepository.getAllRecordsByCompanyId(companyId, TransportAllowance.class);
			if (transportAllowanceList != null && transportAllowanceList.size() > 0) {
				for (TransportAllowance transportAllowance : transportAllowanceList) {
					transportAllowanceJson =TransformDomainToJson.getTransportAllowanceJson(transportAllowance);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transportAllowanceJson;
	}
	
	

}
