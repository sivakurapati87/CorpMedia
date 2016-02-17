package com.intuiture.corp.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.Department;

@Repository
public class DepartmentRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(DepartmentRepository.class);

	public Department findbyId(Integer id) {
		return (Department) getSession().get(Department.class, id);
	}
}
