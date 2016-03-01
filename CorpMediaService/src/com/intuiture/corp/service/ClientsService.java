package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.Clients;
import com.intuiture.corp.json.ClientsJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class ClientsService {
	
	
	@Autowired
	private CommonRepository commonRepository;

	public Boolean saveClients(ClientsJson clientsJson) {
		Clients clients = null;

		try {
			if (clientsJson.getClientsId() != null) {
				clients = (Clients) commonRepository.findById(clientsJson.getClientsId(), Clients.class);
			} else {
				clients = new Clients();
			}
			TransformJsonToDomain.getClients(clients, clientsJson);
			if (clientsJson.getClientsId() != null) {
				commonRepository.update(clients);
			} else {
				commonRepository.persist(clients);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<ClientsJson> getAllClientsList(Integer companyId) {
		List<ClientsJson> clientsJsonList = null;
		try {
			List<Clients> clientsList = (List<Clients>) commonRepository.getAllRecordsByCompanyId(companyId, Clients.class);
			if (clientsList != null && clientsList.size() > 0) {
				clientsJsonList = new ArrayList<ClientsJson>();
				for (Clients clients : clientsList) {
					clientsJsonList.add(TransformDomainToJson.getClientsJson(clients));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientsJsonList;
	}
	
	
	public Boolean deleteClients(Integer clientsId) {
		try {
			Clients clients = (Clients) commonRepository.findById(clientsId, Clients.class);
			if (clients != null) {
				clients.setIsDeleted(Boolean.TRUE);
				commonRepository.update(clients);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	

}
