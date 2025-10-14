package com.jobportal.service;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ModelMapperService {

	
	public ModelMapper getNonNullModelMapper()
	{
		ModelMapper mm = new ModelMapper();
		log.debug(">>> Entering getNonNullModelMapper()");
		log.debug("getNonNullModelMapper(): mm → {}", mm);
		
		mm.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		log.debug("<<< Exiting getNonNullModelMapper()");
		return mm;
	}
}
