package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CommonRepository extends BaseRepository {

	/*
	 * This method is to save an object
	 */
	public synchronized void persist(Object object) {
		getSession().persist(object);
	}

	/*
	 * This method is to update an object
	 */
	public synchronized void update(Object object) {
		getSession().merge(object);
	}

}
