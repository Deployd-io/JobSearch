package com.jobportal.service;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ModelMapperService {

	
	public ModelMapper getNonNullModelMapper()
	log.debug(">>> Entering getNonNullModelMapper()");
	{
		ModelMapper mm = new ModelMapper();
		log.debug("getNonNullModelMapper(): mm → {}", mm);
		
		mm.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		log.debug("<<< Exiting getNonNullModelMapper()");
		return mm;
	}
}
