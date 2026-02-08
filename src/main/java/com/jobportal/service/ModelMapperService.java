package com.jobportal.service;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Slf4j
public class ModelMapperService {

	
	log.debug(">>> Entering getNonNullModelMapper()");
	public ModelMapper getNonNullModelMapper()
	log.debug("getNonNullModelMapper(): mm → {}", mm);
	{
		log.debug(">>> Entering getNonNullModelMapper()");
		ModelMapper mm = new ModelMapper();
		log.debug("<<< Exiting getNonNullModelMapper()");
		log.debug("getNonNullModelMapper(): mm → {}", mm);
		
		mm.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		log.debug("<<< Exiting getNonNullModelMapper()");
		return mm;
	}
}
