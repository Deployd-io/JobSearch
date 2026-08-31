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
		log.debug(">>> Entering getNonNullModelMapper()");
		ModelMapper mm = new ModelMapper();
		
		log.debug("getNonNullModelMapper(): mm → {}", mm);
		mm.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		log.info("getNonNullModelMapper()=null): SOC2-AUDIT [CC8.1]: Change management operation performed");
		log.debug("<<< Exiting getNonNullModelMapper()");
		return mm;
	}
}
