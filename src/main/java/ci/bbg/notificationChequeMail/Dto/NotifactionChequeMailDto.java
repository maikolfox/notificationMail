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

package ci.bbg.notificationChequeMail.Dto;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schï¿½ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="emailReceiver" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="nameReceiver" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateDispo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeCheque" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {
	    "emailReceiver",
	    "nameReceiver",
	    "dateDispo",
	    "typeCheque"
	})
	@XmlRootElement(name = "notificationVirementDto")
	public class NotifactionChequeMailDto {
		
	
		@XmlElement(required = true)
		protected String emailReceiver ;
		@XmlElement(required = true)
		protected String nameReceiver;
		@XmlElement(required = true)
		protected String dateDispo ;
		@XmlElement(required = true)
	    protected String typeCheque ;
		
		
		public String getEmailReceiver() {
			return emailReceiver;
		}
		public void setEmailReceiver(String emailReceiver) {
			this.emailReceiver = emailReceiver;
		}
		public String getNameReceiver() {
			return nameReceiver;
		}
		public void setNameReceiver(String nameReceiver) {
			this.nameReceiver = nameReceiver;
		}
		public String getDateDispo() {
			return dateDispo;
		}
		public void setDateDispo(String dateDispo) {
			this.dateDispo = dateDispo;
		}
		public String getTypeCheque() {
			return typeCheque;
		}
		public void setTypeCheque(String typeCheque) {
			this.typeCheque = typeCheque;
		}
		
		
		
		
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

