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
		
		mm.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		log.info("getNonNullModelMapper()=null): SOC2-AUDIT: Change management operation performed");
		return mm;
	}
}
