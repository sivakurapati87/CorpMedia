package com.intuiture.corp.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.CompanyBanks;

@Repository
public class CompanyBankRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(CompanyBankRepository.class);

	public CompanyBanks getCompanyBanksById(Integer id) {
		return (CompanyBanks) getSession().get(CompanyBanks.class, id);
	}
}
