package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.TagsRepository;
import com.intuiture.corp.entity.Tags;
import com.intuiture.corp.json.TagsJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class TagsService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private TagsRepository tagsRepository;
	
	public Boolean saveTags(TagsJson tagsJson) {
		Tags tags = null;

		
		try {
			if (tagsJson.getTagId() != null) {
				tags = tagsRepository.findbyId(tagsJson.getTagId());
			} else {
				tags = new Tags();
			}
			TransformJsonToDomain.getTags(tags, tagsJson);
			if (tagsJson.getTagId() != null) {
				commonRepository.update(tags);
			} else {
				commonRepository.persist(tags);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TagsJson> getAllTagsList(Integer companyId) {
		List<TagsJson> tagsJsonList = null;
		try {
			List<Tags> tagsList = (List<Tags>) commonRepository.getAllRecordsByCompanyId(companyId, Tags.class);
			if (tagsList != null && tagsList.size() > 0) {
				tagsJsonList = new ArrayList<TagsJson>();
				for (Tags tags : tagsList) {
					tagsJsonList.add(TransformDomainToJson.getTagsJson(tags));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tagsJsonList;
	}
	
	
	public Boolean deleteTags(Integer tagId) {
		try {
			Tags tags = (Tags) commonRepository.findById(tagId, Tags.class);
			if (tags != null) {
				tags.setIsDeleted(Boolean.TRUE);
				commonRepository.update(tags);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
