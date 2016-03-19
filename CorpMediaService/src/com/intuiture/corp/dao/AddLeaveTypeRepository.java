package com.intuiture.corp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.AddLeaveType;

@Repository
public class AddLeaveTypeRepository extends BaseRepository {

	@SuppressWarnings("unchecked")
	public List<AddLeaveType> getAllLeaveTypeListByCmpIdAndGenderId(Integer companyId, Integer genderId) {
		List<AddLeaveType> leaveTypeList = null;
		try {
			Criteria criteria = getSession().createCriteria(AddLeaveType.class);
			criteria.createAlias("companyLeaveType", "companyLeaveType");
			criteria.add(Restrictions.and(
					Restrictions.eq("companyLeaveType.companyId", companyId),
					Restrictions.or(Restrictions.eq("companyLeaveType.isDeleted", Boolean.FALSE),
							Restrictions.isNull("companyLeaveType.isDeleted")),
					Restrictions.or(Restrictions.eq("companyLeaveType.restrictToId", genderId),
							Restrictions.isNull("companyLeaveType.restrictToId"))));
			leaveTypeList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaveTypeList;
	}
}
