package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.TagsRepository;
import com.intuiture.corp.entity.Tags;
import com.intuiture.corp.json.TagsJson;
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

}
