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

package ci.bbg.notificationChequeMail.Helper;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import ci.bbg.notificationChequeMail.Dto.NotifactionChequeMailDto;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 0.1-SNAPSHOT
 */

public class Utilities {

	
	public static void sendMail(NotifactionChequeMailDto requestDto) 	
    { 	  
		  
		  final String host="192.168.200.213";  
		  final String user="spadmin@bridgebankgroup.com";//change accordingly  
		  final String password="Bbgci2012";//change accordingly  
		  final String port="25";
		  final String to=requestDto.getEmailReceiver();//change accordingly  
		  //Get the session object  
		  Properties props = new Properties();  
		  props.put("mail.smtp.host",host);  
		  props.put("mail.smtp.auth", "true"); 
		  props.put("mail.smtp.port", port);
		  props.put("mail.smtp.ssl .enable", "false");
		  
		  String mail="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
		  		"\r\n" + 
		  		"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\r\n" + 
		  		"<head>\r\n" + "<!-- maikol AHOUE MAI 2019 --!>"+
		  		"<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\r\n" + 
		  		"<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\r\n" + 
		  		"<meta content=\"width=device-width\" name=\"viewport\"/>\r\n" + 
		  		"<!--[if !mso]><!-->\r\n" + 
		  		"<meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\"/>\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"<title></title>\r\n" + 
		  		"<!--[if !mso]><!-->\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"<style type=\"text/css\">\r\n" + 
		  		"		body {\r\n" + 
		  		"			margin: 0;\r\n" + 
		  		"			padding: 0;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		table,\r\n" + 
		  		"		td,\r\n" + 
		  		"		tr {\r\n" + 
		  		"			vertical-align: top;\r\n" + 
		  		"			border-collapse: collapse;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		* {\r\n" + 
		  		"			line-height: inherit;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		a[x-apple-data-detectors=true] {\r\n" + 
		  		"			color: inherit !important;\r\n" + 
		  		"			text-decoration: none !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser table {\r\n" + 
		  		"			table-layout: fixed;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		[owa] .img-container div,\r\n" + 
		  		"		[owa] .img-container button {\r\n" + 
		  		"			display: block !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		[owa] .fullwidth button {\r\n" + 
		  		"			width: 100% !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		[owa] .block-grid .col {\r\n" + 
		  		"			display: table-cell;\r\n" + 
		  		"			float: none !important;\r\n" + 
		  		"			vertical-align: top;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .block-grid,\r\n" + 
		  		"		.ie-browser .num12,\r\n" + 
		  		"		[owa] .num12,\r\n" + 
		  		"		[owa] .block-grid {\r\n" + 
		  		"			width: 600px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .mixed-two-up .num4,\r\n" + 
		  		"		[owa] .mixed-two-up .num4 {\r\n" + 
		  		"			width: 200px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .mixed-two-up .num8,\r\n" + 
		  		"		[owa] .mixed-two-up .num8 {\r\n" + 
		  		"			width: 400px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .block-grid.two-up .col,\r\n" + 
		  		"		[owa] .block-grid.two-up .col {\r\n" + 
		  		"			width: 300px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .block-grid.three-up .col,\r\n" + 
		  		"		[owa] .block-grid.three-up .col {\r\n" + 
		  		"			width: 300px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .block-grid.four-up .col [owa] .block-grid.four-up .col {\r\n" + 
		  		"			width: 150px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .block-grid.five-up .col [owa] .block-grid.five-up .col {\r\n" + 
		  		"			width: 120px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .block-grid.six-up .col,\r\n" + 
		  		"		[owa] .block-grid.six-up .col {\r\n" + 
		  		"			width: 100px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .block-grid.seven-up .col,\r\n" + 
		  		"		[owa] .block-grid.seven-up .col {\r\n" + 
		  		"			width: 85px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .block-grid.eight-up .col,\r\n" + 
		  		"		[owa] .block-grid.eight-up .col {\r\n" + 
		  		"			width: 75px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .block-grid.nine-up .col,\r\n" + 
		  		"		[owa] .block-grid.nine-up .col {\r\n" + 
		  		"			width: 66px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .block-grid.ten-up .col,\r\n" + 
		  		"		[owa] .block-grid.ten-up .col {\r\n" + 
		  		"			width: 60px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .block-grid.eleven-up .col,\r\n" + 
		  		"		[owa] .block-grid.eleven-up .col {\r\n" + 
		  		"			width: 54px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		.ie-browser .block-grid.twelve-up .col,\r\n" + 
		  		"		[owa] .block-grid.twelve-up .col {\r\n" + 
		  		"			width: 50px !important;\r\n" + 
		  		"		}\r\n" + 
		  		"	</style>\r\n" + 
		  		"<style id=\"media-query\" type=\"text/css\">\r\n" + 
		  		"		@media only screen and (min-width: 620px) {\r\n" + 
		  		"			.block-grid {\r\n" + 
		  		"				width: 600px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid .col {\r\n" + 
		  		"				vertical-align: top;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid .col.num12 {\r\n" + 
		  		"				width: 600px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.mixed-two-up .col.num3 {\r\n" + 
		  		"				width: 150px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.mixed-two-up .col.num4 {\r\n" + 
		  		"				width: 200px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.mixed-two-up .col.num8 {\r\n" + 
		  		"				width: 400px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.mixed-two-up .col.num9 {\r\n" + 
		  		"				width: 450px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.two-up .col {\r\n" + 
		  		"				width: 300px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.three-up .col {\r\n" + 
		  		"				width: 200px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.four-up .col {\r\n" + 
		  		"				width: 150px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.five-up .col {\r\n" + 
		  		"				width: 120px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.six-up .col {\r\n" + 
		  		"				width: 100px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.seven-up .col {\r\n" + 
		  		"				width: 85px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.eight-up .col {\r\n" + 
		  		"				width: 75px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.nine-up .col {\r\n" + 
		  		"				width: 66px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.ten-up .col {\r\n" + 
		  		"				width: 60px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.eleven-up .col {\r\n" + 
		  		"				width: 54px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid.twelve-up .col {\r\n" + 
		  		"				width: 50px !important;\r\n" + 
		  		"			}\r\n" + 
		  		"		}\r\n" + 
		  		"\r\n" + 
		  		"		@media (max-width: 620px) {\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid,\r\n" + 
		  		"			.col {\r\n" + 
		  		"				min-width: 320px !important;\r\n" + 
		  		"				max-width: 100% !important;\r\n" + 
		  		"				display: block !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.block-grid {\r\n" + 
		  		"				width: 100% !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.col {\r\n" + 
		  		"				width: 100% !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.col>div {\r\n" + 
		  		"				margin: 0 auto;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			img.fullwidth,\r\n" + 
		  		"			img.fullwidthOnMobile {\r\n" + 
		  		"				max-width: 100% !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.no-stack .col {\r\n" + 
		  		"				min-width: 0 !important;\r\n" + 
		  		"				display: table-cell !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.no-stack.two-up .col {\r\n" + 
		  		"				width: 50% !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.no-stack .col.num4 {\r\n" + 
		  		"				width: 33% !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.no-stack .col.num8 {\r\n" + 
		  		"				width: 66% !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.no-stack .col.num4 {\r\n" + 
		  		"				width: 33% !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.no-stack .col.num3 {\r\n" + 
		  		"				width: 25% !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.no-stack .col.num6 {\r\n" + 
		  		"				width: 50% !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.no-stack .col.num9 {\r\n" + 
		  		"				width: 75% !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.video-block {\r\n" + 
		  		"				max-width: none !important;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.mobile_hide {\r\n" + 
		  		"				min-height: 0px;\r\n" + 
		  		"				max-height: 0px;\r\n" + 
		  		"				max-width: 0px;\r\n" + 
		  		"				display: none;\r\n" + 
		  		"				overflow: hidden;\r\n" + 
		  		"				font-size: 0px;\r\n" + 
		  		"			}\r\n" + 
		  		"\r\n" + 
		  		"			.desktop_hide {\r\n" + 
		  		"				display: block !important;\r\n" + 
		  		"				max-height: none !important;\r\n" + 
		  		"			}\r\n" + 
		  		"		}\r\n" + 
		  		"	</style>\r\n" + 
		  		"</head>\r\n" + 
		  		"<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #B8CCE2;\">\r\n" + 
		  		"<style id=\"media-query-bodytag\" type=\"text/css\">\r\n" + 
		  		"@media (max-width: 620px) {\r\n" + 
		  		"  .block-grid {\r\n" + 
		  		"    min-width: 320px!important;\r\n" + 
		  		"    max-width: 100%!important;\r\n" + 
		  		"    width: 100%!important;\r\n" + 
		  		"    display: block!important;\r\n" + 
		  		"  }\r\n" + 
		  		"  .col {\r\n" + 
		  		"    min-width: 320px!important;\r\n" + 
		  		"    max-width: 100%!important;\r\n" + 
		  		"    width: 100%!important;\r\n" + 
		  		"    display: block!important;\r\n" + 
		  		"  }\r\n" + 
		  		"  .col > div {\r\n" + 
		  		"    margin: 0 auto;\r\n" + 
		  		"  }\r\n" + 
		  		"  img.fullwidth {\r\n" + 
		  		"    max-width: 100%!important;\r\n" + 
		  		"    height: auto!important;\r\n" + 
		  		"  }\r\n" + 
		  		"  img.fullwidthOnMobile {\r\n" + 
		  		"    max-width: 100%!important;\r\n" + 
		  		"    height: auto!important;\r\n" + 
		  		"  }\r\n" + 
		  		"  .no-stack .col {\r\n" + 
		  		"    min-width: 0!important;\r\n" + 
		  		"    display: table-cell!important;\r\n" + 
		  		"  }\r\n" + 
		  		"  .no-stack.two-up .col {\r\n" + 
		  		"    width: 50%!important;\r\n" + 
		  		"  }\r\n" + 
		  		"  .no-stack.mixed-two-up .col.num4 {\r\n" + 
		  		"    width: 33%!important;\r\n" + 
		  		"  }\r\n" + 
		  		"  .no-stack.mixed-two-up .col.num8 {\r\n" + 
		  		"    width: 66%!important;\r\n" + 
		  		"  }\r\n" + 
		  		"  .no-stack.three-up .col.num4 {\r\n" + 
		  		"    width: 33%!important\r\n" + 
		  		"  }\r\n" + 
		  		"  .no-stack.four-up .col.num3 {\r\n" + 
		  		"    width: 25%!important\r\n" + 
		  		"  }\r\n" + 
		  		"}\r\n" + 
		  		"</style>\r\n" + 
		  		"<!--[if IE]><div class=\"ie-browser\"><![endif]-->\r\n" + 
		  		"<table bgcolor=\"#B8CCE2\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #B8CCE2; width: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
		  		"<tbody>\r\n" + 
		  		"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
		  		"<td style=\"word-break: break-word; vertical-align: top; border-collapse: collapse;\" valign=\"top\">\r\n" + 
		  		"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#B8CCE2\"><![endif]-->\r\n" + 
		  		"<div style=\"background-color:transparent;\">\r\n" + 
		  		"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;;\">\r\n" + 
		  		"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
		  		"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\r\n" + 
		  		"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\r\n" + 
		  		"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top;;\">\r\n" + 
		  		"<div style=\"width:100% !important;\">\r\n" + 
		  		"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
		  		"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"<div class=\"mobile_hide\">\r\n" + 
		  		"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
		  		"<tbody>\r\n" + 
		  		"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
		  		"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 5px; padding-right: 5px; padding-bottom: 5px; padding-left: 5px; border-collapse: collapse;\" valign=\"top\">\r\n" + 
		  		"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"40\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%; border-top: 0px solid transparent; height: 40px;\" valign=\"top\" width=\"100%\">\r\n" + 
		  		"<tbody>\r\n" + 
		  		"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
		  		"<td height=\"40\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; border-collapse: collapse;\" valign=\"top\"><span></span></td>\r\n" + 
		  		"</tr>\r\n" + 
		  		"</tbody>\r\n" + 
		  		"</table>\r\n" + 
		  		"</td>\r\n" + 
		  		"</tr>\r\n" + 
		  		"</tbody>\r\n" + 
		  		"</table>\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
		  		"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<div style=\"background-color:transparent;\">\r\n" + 
		  		"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #061c27;;\">\r\n" + 
		  		"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#061c27;\">\r\n" + 
		  		"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#061c27\"><![endif]-->\r\n" + 
		  		"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#061c27;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 20px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\r\n" + 
		  		"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top;;\">\r\n" + 
		  		"<div style=\"width:100% !important;\">\r\n" + 
		  		"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
		  		"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 20px;\">\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"<div align=\"center\" class=\"img-container center fixedwidth\" style=\"padding-right: 25px;padding-left: 25px;\">\r\n" + 
		  		"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 25px;padding-left: 25px;\" align=\"center\"><![endif]-->\r\n" + 
		  		"<div style=\"font-size:1px;line-height:25px\"> </div><img align=\"center\" alt=\"Image\" border=\"0\" class=\"center fixedwidth\" src=\"https://www.bridgebankgroup.com/images/logo.png\" style=\"outline: none; text-decoration: none; -ms-interpolation-mode: bicubic; clear: both; border: 0; height: auto; float: none; width: 100%; max-width: 203px; display: block;\" title=\"Image\" width=\"203\"/>\r\n" + 
		  		"<div style=\"font-size:1px;line-height:25px\"> </div>\r\n" + 
		  		"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
		  		"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<div style=\"background-color:transparent;\">\r\n" + 
		  		"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;;\">\r\n" + 
		  		"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\r\n" + 
		  		"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#FFFFFF\"><![endif]-->\r\n" + 
		  		"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#FFFFFF;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 35px; padding-left: 35px; padding-top:35px; padding-bottom:40px;\"><![endif]-->\r\n" + 
		  		"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top;\">\r\n" + 
		  		"<div style=\"width:100% !important;\">\r\n" + 
		  		"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
		  		"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:35px; padding-bottom:40px; padding-right: 35px; padding-left: 35px;\">\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Arial, sans-serif\"><![endif]-->\r\n" + 
		  		"<div style=\"color:#132F40;font-family:'Cabin', Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:120%;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
		  		"<div style=\"font-size: 12px; line-height: 14px; font-family: 'Cabin', Arial, 'Helvetica Neue', Helvetica, sans-serif; color: #132F40;\">\r\n" + 
		  		"<p style=\"font-size: 14px; line-height: 26px; margin: 0;\"><span style=\"font-size: 22px;\">Bonjour&nbsp;&nbsp;<strong>Cher(e) Client(e),</strong></span></p>\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		" \r\n" + 
		  		"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
		  		"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 5px; padding-bottom: 30px; font-family: Arial, sans-serif\"><![endif]-->\r\n" + 
		  		"<div style=\"color:#061c27;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:150%;padding-top:5px;padding-right:10px;padding-bottom:30px;padding-left:10px;\">\r\n" + 
		  		"<div style=\"font-size: 12px; line-height: 18px; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; color: #061c27;\">\r\n" + 
		  		"<p style=\"font-size: 14px; line-height: 25px; margin: 0;\"><span style=\"font-size: 17px; color: #000000; mso-ansi-font-size: 18px;\">Nous avons le plaisir de vous informer que votre ch&eacute;quier est disponible. </span><br/><span style=\"font-size: 17px; line-height: 25px; mso-ansi-font-size: 18px;\"><span style=\"color: #000000; font-size: 17px; line-height: 25px; mso-ansi-font-size: 18px;\">Rendez-vous vite en agence pour le r&eacute;cup&eacute;rer</span>.</span><br/><br/></p>\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
		  		"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
		  		"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<div style=\"background-color:transparent;\">\r\n" + 
		  		"<div class=\"block-grid two-up no-stack\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #132f40;;\">\r\n" + 
		  		"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#132f40;\">\r\n" + 
		  		"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#132f40\"><![endif]-->\r\n" + 
		  		"<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"background-color:#132f40;width:300px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 20px; padding-left: 25px; padding-top:15px; padding-bottom:15px;\"><![endif]-->\r\n" + 
		  		"<div class=\"col num6\" style=\"max-width: 320px; min-width: 300px; display: table-cell; vertical-align: top;;\">\r\n" + 
		  		"<div style=\"width:100% !important;\">\r\n" + 
		  		"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
		  		"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:15px; padding-bottom:15px; padding-right: 20px; padding-left: 25px;\">\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top: 0px; padding-bottom: 0px; font-family: Arial, sans-serif\"><![endif]-->\r\n" + 
		  		"<div style=\"color:#555555;font-family:'Cabin', Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:150%;padding-top:0px;padding-right:0px;padding-bottom:0px;padding-left:0px;\">\r\n" + 
		  		"<div style=\"font-family: 'Cabin', Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; line-height: 18px; color: #555555;\">\r\n" + 
		  		"<p style=\"font-size: 14px; line-height: 21px; margin: 0;\"><span style=\"font-size: 14px; line-height: 21px; color: #ffffff;\">Nous contacter: info@bridgebankgroup.com</span><br/><span style=\"font-size: 14px; line-height: 21px; color: #ffffff;\">Copyright &copy Bridgebankgroup C&ocirc;te d'Ivoire. Tous droits r&eacute;serv&eacute;s.</span></p>\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
		  		"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
		  		"<!--[if (mso)|(IE)]></td><td align=\"center\" width=\"300\" style=\"background-color:#132f40;width:300px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\r\n" + 
		  		"<div class=\"col num6\" style=\"max-width: 320px; min-width: 300px; display: table-cell; vertical-align: top;;\">\r\n" + 
		  		"<div style=\"width:100% !important;\">\r\n" + 
		  		"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
		  		"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"<div></div>\r\n" + 
		  		"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
		  		"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<div style=\"background-color:transparent;\">\r\n" + 
		  		"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;;\">\r\n" + 
		  		"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
		  		"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\r\n" + 
		  		"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\r\n" + 
		  		"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top;;\">\r\n" + 
		  		"<div style=\"width:100% !important;\">\r\n" + 
		  		"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
		  		"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
		  		"<tbody>\r\n" +
		  		"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
		  		"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 5px; padding-right: 5px; padding-bottom: 5px; padding-left: 5px; border-collapse: collapse;\" valign=\"top\">\r\n" + 
		  		"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" height=\"30\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%; border-top: 0px solid transparent; height: 30px;\" valign=\"top\" width=\"100%\">\r\n" + 
		  		"<tbody>\r\n" + 
		  		"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
		  		"<td height=\"30\" style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; border-collapse: collapse;\" valign=\"top\"><span></span></td>\r\n" + 
		  		"</tr>\r\n" + 
		  		"</tbody>\r\n" + 
		  		"</table>\r\n" + 
		  		"</td>\r\n" + 
		  		"</tr>\r\n" + 
		  		"</tbody>\r\n" + 
		  		"</table>\r\n" + 
		  		"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--<![endif]-->\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
		  		"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"</div>\r\n" + 
		  		"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
		  		"</td>\r\n" + 
		  		"</tr>\r\n" + 
		  		"</tbody>\r\n" + 
		  		"</table>\r\n" + 
		  		"<!--[if (IE)]></div><![endif]-->\r\n" + 
		  		"</body>\r\n" + 
		  		"</html>";
		    Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    	  PasswordAuthentication passwordAuthentication=new PasswordAuthentication(user,password);
		    	  return  passwordAuthentication  ; 
		      }  
		    });  
		   	session.setDebug(true);
		   	//Compose the message  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress("notification@bridgebankgroup.com"));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		     message.setSubject("Chéquier Disponible");  
		     //message.setText("This is sample program for sending email using web service"); 
		     MimeMultipart multipart = new MimeMultipart();
	         BodyPart messageBodyPart = new MimeBodyPart();
		       
		     // String htmlText = readEmailFromHtml("C:/mail/HTMLTemplate.html",input);
	         messageBodyPart.setContent(mail, "text/html");
	         multipart.addBodyPart(messageBodyPart); 
	         message.setContent(multipart);
		     
		     //send the message  
		     Transport.send(message);  
		     System.out.println("message sent successfully...");  
		   
		     } catch (MessagingException e) {e.printStackTrace();}  
		
	
	}

}
