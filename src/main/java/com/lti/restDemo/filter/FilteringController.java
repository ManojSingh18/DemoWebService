package com.lti.restDemo.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean()
	{
		SomeBean someBean=new SomeBean("value1","value2","value3");
		
		MappingJacksonValue map=new MappingJacksonValue(someBean);
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter",filter);
		
		map.setFilters(filters);
		
		return map;
	}
	
	

	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBean()
	{
		List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2","value3"),
				new SomeBean("value11","value22","value33"));
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		
		MappingJacksonValue map=new MappingJacksonValue(list);
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter",filter);
		
		map.setFilters(filters);
		
		return map;
	}
}
