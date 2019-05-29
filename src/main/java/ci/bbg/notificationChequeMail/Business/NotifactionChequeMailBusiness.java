/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ci.bbg.notificationChequeMail.Business;

import java.util.HashMap;
import org.apache.log4j.Logger;
import ci.bbg.notificationChequeMail.Dto.NotifactionChequeMailDto;
import ci.bbg.notificationChequeMail.Helper.Utilities;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 0.1-SNAPSHOT
 */

public class NotifactionChequeMailBusiness {

	private Logger slf4jLogger = Logger.getLogger(NotifactionChequeMailBusiness.class);
	public NotifactionChequeMailBusiness() {
		super();
	}
	
	
	public HashMap<String, Object> NotificationCheque(NotifactionChequeMailDto requestDto) {
		slf4jLogger.info("---------------init MAIL Notification BUSINESS begin-----------------");
		HashMap<String, Object> response = new HashMap<String, Object>();
		// List<HashMap<String, Object>> datasServicesResult = null;
		try {

			/**
			 * Check value of dto's parameters and returns error if only one is missing
			 * 
			 */
			
			/*********************   CONTROLE BEGIN*****************/ 
			if(requestDto.getEmailReceiver().trim().equals("")) 
			{	
				response.put("hasError", true);
				response.put("errorMessage","email is empty");
				response.put("errorCode", 404);
				slf4jLogger.info(response);
				//NotificationDal.createNotification(generatedString,"400");
				return response;
			}
			
			
			/**************************************/ 
		
			/*********************   CONTROLE  END    *********************/ 
			
			
			Utilities.sendMail(requestDto);
			
			
			//slf4jLogger.info("Response wecashup api: " + responseCallApi + "-------");
			
//			if (responseCallApi.code()!=200) 
//			{
//				response.put("hasError", true);
//				response.put("errorMessage", ErrorMessage.AUTH_ERROR);
//				// TODO: Implementation token retrieving
//				slf4jLogger.error("---------------Notification BUSINESS end WITH code+"+responseCallApi.code()+"  ERROR-----------------");
//				NotificationDal.createNotification(requestDto.getTransaction_receiver_reference(),String.valueOf(responseCallApi.code()));
//
//			}
			
			//NotificationDal.createNotification(requestDto.getTransaction_receiver_reference(),String.valueOf(responseCallApi.code()));

		} catch (Exception e) {
			response.put("hasError", true);
			System.out.println(e);
			response.put("errorMessage", e);
			slf4jLogger.info("--------------- Notification BUSINESS end WITH EXCEPTION ERROR-----------------");
			return response;
		}
		response.put("hasError", false);
		response.put("errorMessage", "envoie reussi");
		slf4jLogger.info("---------------END Notification Mail BUSINESS end  -----------------");
		return response;
	}
	
	
}
