package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.EmployeeRepository;
import com.intuiture.corp.entity.Employee;
import com.intuiture.corp.entity.EmployeeAddressInfo;
import com.intuiture.corp.entity.EmployeeEducationalInfo;
import com.intuiture.corp.entity.EmployeeExperienceInfo;
import com.intuiture.corp.entity.EmployeeFamilyInfo;
import com.intuiture.corp.entity.EmployeePersonalInfo;
import com.intuiture.corp.entity.EmployeeProfessionalInfo;
import com.intuiture.corp.json.EmployeeEducationalInfoJson;
import com.intuiture.corp.json.EmployeeExperienceInfoJson;
import com.intuiture.corp.json.EmployeeFamilyInfoJson;
import com.intuiture.corp.json.EmployeeJson;
import com.intuiture.corp.json.EmployeePersonalInfoJson;
import com.intuiture.corp.json.EmployeeProfessionalInfoJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	public Boolean saveOrUpdateEmployee(EmployeeJson employeeJson) {
		Employee employee = null;
		try {
			if (employeeJson != null) {
				if (employeeJson.getEmployeeId() != null) {
					employee = (Employee) commonRepository.findById(employeeJson.getEmployeeId(), Employee.class);
				} else {
					employee = new Employee();
				}
				TransformJsonToDomain.getEmployee(employee, employeeJson);
				if (employeeJson.getEmployeeId() != null) {
					commonRepository.update(employee);
				} else {
					commonRepository.persist(employee);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeJson> getAllEmployeesByCompanyId(Integer companyId) {
		List<EmployeeJson> employeeJsonList = null;
		try {
			List<Employee> employeesList = (List<Employee>) commonRepository.getAllRecordsByCompanyId(companyId, Employee.class);
			if (employeesList != null && employeesList.size() > 0) {
				employeeJsonList = new ArrayList<EmployeeJson>();
				for (Employee employee : employeesList) {
					employeeJsonList.add(TransformDomainToJson.getEmployeeJson(employee));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeJsonList;
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeFamilyInfoJson> getAllEmployeeFamilyList(Integer employeeId) {
		List<EmployeeFamilyInfoJson> employeeFamilyInfoJsonList = null;
		try {
			List<EmployeeFamilyInfo> employeesFamilyInfoList = (List<EmployeeFamilyInfo>) commonRepository.findByEmployeeId(employeeId, EmployeeFamilyInfo.class);
			if (employeesFamilyInfoList != null && employeesFamilyInfoList.size() > 0) {
				employeeFamilyInfoJsonList = new ArrayList<EmployeeFamilyInfoJson>();
				for (EmployeeFamilyInfo empFamilyInfo : employeesFamilyInfoList) {
					employeeFamilyInfoJsonList.add(TransformDomainToJson.getEmployeeFamilyJson(empFamilyInfo));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeFamilyInfoJsonList;
	}

	public Boolean saveOrUpdateEmployeePersonalInfo(EmployeePersonalInfoJson employeePersonalInfoJson) {
		EmployeePersonalInfo employeePersonalInfo = null;
		EmployeeAddressInfo employeeAddressInfo = null;
		try {
			if (employeePersonalInfoJson != null) {
				// This is to insert the data to Personal Info Table
				if (employeePersonalInfoJson.getEmployeePersonalInfoId() != null) {
					employeePersonalInfo = (EmployeePersonalInfo) commonRepository.findById(employeePersonalInfoJson.getEmployeePersonalInfoId(), EmployeePersonalInfo.class);
				} else {
					employeePersonalInfo = new EmployeePersonalInfo();
				}
				TransformJsonToDomain.getEmployeePersonalInfo(employeePersonalInfo, employeePersonalInfoJson);
				if (employeePersonalInfoJson.getEmployeePersonalInfoId() != null) {
					commonRepository.update(employeePersonalInfo);
				} else {
					commonRepository.persist(employeePersonalInfo);
				}
				// This is to insert the data to Address Info Table
				if (employeePersonalInfoJson.getEmployeeAddressInfoId() != null) {
					employeeAddressInfo = (EmployeeAddressInfo) commonRepository.findById(employeePersonalInfoJson.getEmployeeAddressInfoId(), EmployeeAddressInfo.class);
				} else {
					employeeAddressInfo = new EmployeeAddressInfo();
				}
				TransformJsonToDomain.getEmployeeAddressInfo(employeeAddressInfo, employeePersonalInfoJson);
				if (employeePersonalInfoJson.getEmployeeAddressInfoId() != null) {
					commonRepository.update(employeeAddressInfo);
				} else {
					commonRepository.persist(employeeAddressInfo);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Boolean saveOrUpdateEmployeeFamilyInfo(EmployeeFamilyInfoJson employeeFamilyInfoJson) {
		EmployeeFamilyInfo employeeFamilyInfo = null;
		try {
			if (employeeFamilyInfoJson != null) {
				// This is to insert the data to family Info Table
				if (employeeFamilyInfoJson.getEmployeeFamilyInfoId() != null) {
					employeeFamilyInfo = (EmployeeFamilyInfo) commonRepository.findById(employeeFamilyInfoJson.getEmployeeFamilyInfoId(), EmployeeFamilyInfo.class);
				} else {
					employeeFamilyInfo = new EmployeeFamilyInfo();
				}
				TransformJsonToDomain.getEmployeeFamilyInfo(employeeFamilyInfo, employeeFamilyInfoJson);
				if (employeeFamilyInfoJson.getEmployeeFamilyInfoId() != null) {
					commonRepository.update(employeeFamilyInfo);
				} else {
					commonRepository.persist(employeeFamilyInfo);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public EmployeePersonalInfoJson getEmployeePersonalInfo(Integer employeeId) {
		EmployeePersonalInfoJson employeePersonalInfoJson = null;
		try {
			List<EmployeePersonalInfo> employeePersonalInfoList = (List<EmployeePersonalInfo>) commonRepository.findByEmployeeId(employeeId, EmployeePersonalInfo.class);
			List<EmployeeAddressInfo> employeeAddressInfoList = (List<EmployeeAddressInfo>) commonRepository.findByEmployeeId(employeeId, EmployeeAddressInfo.class);
			if (employeePersonalInfoList != null && employeePersonalInfoList.size() > 0) {
				if (employeeAddressInfoList != null && employeeAddressInfoList.size() > 0) {
					employeePersonalInfoJson = TransformDomainToJson.getEmployeePersonalInfoJson(employeeAddressInfoList.get(0), employeePersonalInfoList.get(0));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeePersonalInfoJson;
	}

	public Boolean saveOrUpdateEmployeeProfessionalInfo(EmployeeProfessionalInfoJson employeeProfessionalInfoJson) {
		EmployeeProfessionalInfo employeeProfessionalInfo = null;
		try {
			if (employeeProfessionalInfoJson != null) {
				// This is to insert the data to professional Info Table
				if (employeeProfessionalInfoJson.getEmployeeProfessionalInfoId() != null) {
					employeeProfessionalInfo = (EmployeeProfessionalInfo) commonRepository.findById(employeeProfessionalInfoJson.getEmployeeProfessionalInfoId(), EmployeeProfessionalInfo.class);
				} else {
					employeeProfessionalInfo = new EmployeeProfessionalInfo();
				}
				TransformJsonToDomain.getEmployeeProfessionalInfo(employeeProfessionalInfo, employeeProfessionalInfoJson);
				if (employeeProfessionalInfoJson.getEmployeeProfessionalInfoId() != null) {
					commonRepository.update(employeeProfessionalInfo);
				} else {
					commonRepository.persist(employeeProfessionalInfo);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Boolean saveOrUpdateEmployeeExperienceInfo(EmployeeExperienceInfoJson employeeExperienceInfoJson) {
		EmployeeExperienceInfo employeeExperienceInfo = null;
		try {
			if (employeeExperienceInfoJson != null) {
				// This is to insert the data to professional Info Table
				if (employeeExperienceInfoJson.getEmployeeExperienceInfoId() != null) {
					employeeExperienceInfo = (EmployeeExperienceInfo) commonRepository.findById(employeeExperienceInfoJson.getEmployeeExperienceInfoId(), EmployeeExperienceInfo.class);
				} else {
					employeeExperienceInfo = new EmployeeExperienceInfo();
				}
				TransformJsonToDomain.getEmployeeExperienceInfo(employeeExperienceInfo, employeeExperienceInfoJson);
				if (employeeExperienceInfoJson.getEmployeeExperienceInfoId() != null) {
					commonRepository.update(employeeExperienceInfo);
				} else {
					commonRepository.persist(employeeExperienceInfo);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Boolean saveOrUpdateEmployeeEducationalInfo(EmployeeEducationalInfoJson employeeEducationalInfoJson) {
		EmployeeEducationalInfo employeeEducationalInfo = null;
		try {
			if (employeeEducationalInfoJson != null) {
				// This is to insert the data to professional Info Table
				if (employeeEducationalInfoJson.getEmployeeEducationalInfoId() != null) {
					employeeEducationalInfo = (EmployeeEducationalInfo) commonRepository.findById(employeeEducationalInfoJson.getEmployeeEducationalInfoId(), EmployeeEducationalInfo.class);
				} else {
					employeeEducationalInfo = new EmployeeEducationalInfo();
				}
				TransformJsonToDomain.getEmployeeEducationalInfo(employeeEducationalInfo, employeeEducationalInfoJson);
				if (employeeEducationalInfoJson.getEmployeeEducationalInfoId() != null) {
					commonRepository.update(employeeEducationalInfo);
				} else {
					commonRepository.persist(employeeEducationalInfo);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public EmployeeProfessionalInfoJson getEmployeeProfessionalInfo(Integer employeeId) {
		EmployeeProfessionalInfoJson employeeProfessionalInfoJson = null;
		try {
			List<EmployeeProfessionalInfo> employeeProfessionalInfoList = (List<EmployeeProfessionalInfo>) commonRepository.findByEmployeeId(employeeId, EmployeeProfessionalInfo.class);
			if (employeeProfessionalInfoList != null && employeeProfessionalInfoList.size() > 0) {
				employeeProfessionalInfoJson = TransformDomainToJson.getEmployeeProfessionalInfoJson(employeeProfessionalInfoList.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeProfessionalInfoJson;
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeExperienceInfoJson> getEmployeeExperienceInfo(Integer employeeId) {
		List<EmployeeExperienceInfoJson> employeeExperienceInfoJsonList = null;
		try {
			List<EmployeeExperienceInfo> employeeExperienceInfoList = (List<EmployeeExperienceInfo>) commonRepository.findByEmployeeId(employeeId, EmployeeExperienceInfo.class);
			if (employeeExperienceInfoList != null && employeeExperienceInfoList.size() > 0) {
				employeeExperienceInfoJsonList = new ArrayList<EmployeeExperienceInfoJson>();
				for (EmployeeExperienceInfo employeeExperienceInfo : employeeExperienceInfoList) {
					employeeExperienceInfoJsonList.add(TransformDomainToJson.getEmployeeExperienceInfoJson(employeeExperienceInfo));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeExperienceInfoJsonList;
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeEducationalInfoJson> getEmployeeEducationalInfo(Integer employeeId) {
		List<EmployeeEducationalInfoJson> employeeEducationalInfoJsonList = null;
		try {
			List<EmployeeEducationalInfo> employeeEducationalInfoList = (List<EmployeeEducationalInfo>) commonRepository.findByEmployeeId(employeeId, EmployeeEducationalInfo.class);
			if (employeeEducationalInfoList != null && employeeEducationalInfoList.size() > 0) {
				employeeEducationalInfoJsonList = new ArrayList<EmployeeEducationalInfoJson>();
				for (EmployeeEducationalInfo employeeEducationalInfo : employeeEducationalInfoList) {
					employeeEducationalInfoJsonList.add(TransformDomainToJson.getEmployeeEducationalInfoJson(employeeEducationalInfo));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeEducationalInfoJsonList;
	}

	public Boolean deleteEmployeeFamilyInfo(Integer employeeFamilyInfoId) {
		try {
			EmployeeFamilyInfo employeeFamilyInfo = (EmployeeFamilyInfo) commonRepository.findById(employeeFamilyInfoId, EmployeeFamilyInfo.class);
			if (employeeFamilyInfo != null) {
				employeeFamilyInfo.setIsDeleted(Boolean.TRUE);
				commonRepository.update(employeeFamilyInfo);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Boolean deleteEmployeeExperienceInfo(Integer employeeExperienceId) {
		try {
			EmployeeExperienceInfo employeeExperienceInfo = (EmployeeExperienceInfo) commonRepository.findById(employeeExperienceId, EmployeeExperienceInfo.class);
			if (employeeExperienceInfo != null) {
				employeeExperienceInfo.setIsDeleted(Boolean.TRUE);
				commonRepository.update(employeeExperienceInfo);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
