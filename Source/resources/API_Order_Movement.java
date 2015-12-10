package resources;

import java.util.HashMap;

import constants.Constant_Class;

public class API_Order_Movement {

	
	public void api_OrderStatusMovement(HashMap<String, String> hInputData,
			String baseStatus, String service_Name, String order_Details)

	{

//		Html_Library HL = new Html_Library();
		try

		{

			String XML = "";

			// Step1 :StatusXML and it's value Lookup

			HashMap<String, String> Authorization = new HashMap<String, String>();
			Authorization.put("Authorization_XML",
					Constant_Class.Authorization_XML);
			Authorization.put("Replace_Authorization_XML",
					Constant_Class.Replace_Authorization_XML);
			
						HashMap<String, String> RequestCollection = new HashMap<String, String>();
			RequestCollection.put("RequestCollection_XML",
					Constant_Class.RequestCollection_XML);
			RequestCollection.put("Replace_RequestCollection_XML",
					Constant_Class.Replace_RequestCollection_XML);

			HashMap<String, String> ExecuteCollection = new HashMap<String, String>();
			ExecuteCollection.put("ExecuteCollection_XML",
					Constant_Class.ExecuteCollection_XML);
			ExecuteCollection.put("Replace_ExecuteCollection_XML",
					Constant_Class.Replace_ExecuteCollection_XML);

						HashMap<String, String> holdresolution = new HashMap<String, String>();
			holdresolution.put("holdresolution_XML",
					Constant_Class.holdresolution_XML);
			holdresolution.put("Replace_holdresolution_XML",
					Constant_Class.Replace_holdresolution_XML);
			
			HashMap<String, String> lineholdresolution = new HashMap<String, String>();
			holdresolution.put("lineholdresolution_XML",
					Constant_Class.lineholdresolution_XML);
			holdresolution.put("Replace_lineholdresolution_XML",
					Constant_Class.Replace_lineholdresolution_XML);
			
			
			HashMap<String, String> authorisePayment = new HashMap<String, String>();
			holdresolution.put("authorisePayment_XML",
					Constant_Class.authorisePayment_XML);
			holdresolution.put("Replace_authorisePayment_XML",
					Constant_Class.Replace_authorisePayment_XML);
		
			

						// Add all the xml's in constant class and create a hash map for
			// that

			// Step2 :Master XML Lookup

			HashMap<String, HashMap<String, String>> master_Order_Movement_XML_Lookup = new HashMap<String, HashMap<String, String>>();
			
			
			master_Order_Movement_XML_Lookup.put(
					"AwaitingPaymentAuthorization",
					AwaitingPaymentAuthorization);
			
			master_Order_Movement_XML_Lookup.put("VendorPurchaseOrderReceived",
					VendorPurchaseOrderReceived);
			master_Order_Movement_XML_Lookup.put("RequestCollection",
					RequestCollection);
			master_Order_Movement_XML_Lookup.put("ExecuteCollection",
					ExecuteCollection);
			master_Order_Movement_XML_Lookup.put("FullFraud", FullFraud);
			master_Order_Movement_XML_Lookup.put("ClearFraud", ClearFraud);
			master_Order_Movement_XML_Lookup.put("Item_inventory_Feed",
					Item_inventory_Feed);
			master_Order_Movement_XML_Lookup.put("cancelUpdate", cancelUpdate);
			master_Order_Movement_XML_Lookup
					.put("fraudNegCheck", fraudNegCheck);
			master_Order_Movement_XML_Lookup
			.put("holdresolution", holdresolution);
			master_Order_Movement_XML_Lookup
			.put("lineholdresolution", lineholdresolution);
			master_Order_Movement_XML_Lookup
			.put("authorisePayment", authorisePayment);
		

			// Add the sub hashmap to master hashmap

			// Step3:update the order Status movement XML with new Values

			XML = update_XML(master_Order_Movement_XML_Lookup.get(baseStatus).get(baseStatus + "_XML"), master_Order_Movement_XML_Lookup.get(baseStatus).get("Replace_" + baseStatus + "_XML"),order_Details);
			

			// API Tester
			System.out.println("API : " +XML);
			
			API_Tester API = new API_Tester();
			API.api_Tester(service_Name, XML, Constant_Class.OMSEnvironment);// (hInputData,service_Name,XML);

	//		logInfo("Screen shot :", getRootTestObject().getScreenSnapshot());

		}

		catch (Exception e) {

			System.out.println("Error msg:" + e.getMessage());
			e.printStackTrace();

		}
	}

	
	
	public String update_XML(String XML, String replace, String values) {
		String temp = XML;

		String[] arrReplace = replace.split(",");

		String[] arrValues = values.split(",");

		for (int i = 0; i < arrReplace.length; i++)

		{
			arrReplace[i] = arrReplace[i].trim();
			temp = temp.replace(arrReplace[i], arrValues[i]);
		}

		System.out.println(temp);

		return temp;

	}


}
