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

package ci.bbg.notificationChequeMail.Service;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import ci.bbg.notificationChequeMail.Business.NotifactionChequeMailBusiness;
import ci.bbg.notificationChequeMail.Dto.NotifactionChequeMailDto;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 0.1-SNAPSHOT
 */
@Path("/service/")
public class NotifactionChequeMailService {
	
	@Autowired
	private NotifactionChequeMailBusiness notifactionChequeMailBusiness ;
	
	private Logger slf4jLogger = Logger.getLogger(NotifactionChequeMailService.class);


    @POST
    @Consumes("application/json")
	@Produces("application/json")
    @Path("/notificationCheque")
    public Response sendNotificationCheque(NotifactionChequeMailDto request) {
    	
    	slf4jLogger.info("--------------- Send notification mail  SERVICE BEGIN-----------------");
    	notifactionChequeMailBusiness=new NotifactionChequeMailBusiness();
		HashMap<String, Object> response = notifactionChequeMailBusiness.NotificationCheque(request);
		slf4jLogger.info("--------------- initOrdreVirement SERVICE END-----------------");
		return Response.status(Response.Status.OK).entity(response).build();
      
    }

   
}
