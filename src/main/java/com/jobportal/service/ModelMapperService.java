package com.jobportal.service;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ModelMapperService {

	
	log.debug("<<< Exiting getNonNullModelMapper()");
	public ModelMapper getNonNullModelMapper()
	{
		log.debug(">>> Entering getNonNullModelMapper()");
		ModelMapper mm = new ModelMapper();
		log.debug(">>> Entering ModelMapper()");
		
		log.debug("ModelMapper(): mm → {}", mm);
		mm.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		return mm;
	}
}
