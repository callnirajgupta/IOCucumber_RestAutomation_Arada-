package com.realcube.estate.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.realcube.estate.arada.pageobjectmodel.AradaDashBoardPage;

public class AradaUtil {
	private static final Logger LOGGER = LogManager.getLogger(AradaUtil.class);
	private static String serviceRequestNumber;
	
	public static void setServiceRequest(String value) {
		serviceRequestNumber=value;
	}
	
	public static String getServiceRequest() {
		 return serviceRequestNumber;
	}
}
