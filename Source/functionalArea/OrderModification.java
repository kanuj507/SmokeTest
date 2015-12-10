package functionalArea;

import java.util.HashMap;

import constants.Constant_Class;

public class OrderModification {

	
	
	public void orderModifyModule(HashMap<String, String> hInputData) throws Exception
	{
	
		int line=1;
		int lineNo=Integer.parseInt(hInputData.get("DATA"));
		try
		{
			HashMap<String, Integer> hBusines_Function=new HashMap<String, Integer>();
			{  
/*				hBusines_Function.put("LOS Modification Yantra", 1);
				hBusines_Function.put("Address Modification Yantra", 2);
				hBusines_Function.put("STH to ISP Modification Yantra", 3);
				hBusines_Function.put("Charge override Yantra", 4);
				hBusines_Function.put("ISP to STH Modification Yantra", 5);
				hBusines_Function.put("ISP Alternate Store Yantra", 6);
				hBusines_Function.put("DEL Address Modification Yantra", 7);
				hBusines_Function.put("DEL Reschedule Modification Yantra", 8);
				hBusines_Function.put("Payment Modification Yantra", 9);
				hBusines_Function.put("LOS Modification QO", 10);
				hBusines_Function.put("Address Modification QO", 11);
				hBusines_Function.put("STH to ISP Modification QO", 12);
				hBusines_Function.put("ISP to STH Modification QO", 13);
				hBusines_Function.put("ISP Alternate Store QO", 14);
				hBusines_Function.put("DEL Address Modification QO", 15);
				hBusines_Function.put("DEL Reschedule Modification QO", 16);
				hBusines_Function.put("DEL to STH Modification QO", 17);
				hBusines_Function.put("DEL to ISP Modification QO", 18);
				hBusines_Function.put("ISP to DEL Modification QO", 19);
				hBusines_Function.put("STH to DEL Modification QO", 20);
				hBusines_Function.put("Bill to Address Yantra", 23);
*/
				
				hBusines_Function.put("LOSMODIFICATIONOMS", 1);
				hBusines_Function.put("SHIPTOADDRESSMODIFICATION", 2);
				hBusines_Function.put("STH to ISP Modification Yantra", 3);
				hBusines_Function.put("ISP to STH Modification Yantra", 5);
				hBusines_Function.put("DEL Address Modification Yantra", 7);
				hBusines_Function.put("LOS Modification QO", 10);
				hBusines_Function.put("Address Modification QO", 11);
				hBusines_Function.put("STH to ISP Modification QO", 12);
				hBusines_Function.put("ISP to STH Modification QO", 13);
				hBusines_Function.put("DEL to ISP Modification QO", 18);
				hBusines_Function.put("ISP to DEL Modification QO", 19);
				hBusines_Function.put("Bill to Address Yantra", 23);

				
//				try
//				{
//					line=Integer.parseInt(hInputData.get("DATA"));
//				}
//				catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
			}
		if(Constant_Class.StatusFlag)
		{
					switch (hBusines_Function.get(hInputData.get("BUSINESS_FUNCTION"))) 
					{
						case 1:	
							STHM.modify_LOS_Yantra_Module(hInputData);
							
							break;
						case 2:
							STHM.modify_Address_Yantra_Module(hInputData);
						
							break;
						case 3:
							STHM.modify_STH_ISP_Yantra_Module(hInputData);
						
							break;	
						case 4:
							STHM.modify_Override_Modify_Charges_Yantra_Module(hInputData);
						
							break;
						case 5:
							STHM.modify_ISP_STH_Yantra_Module(hInputData);
						
							break;
						case 6:
							STHM.modify_Alternate_Store_Pickup_Yantra_Module(hInputData);
							break;
						case 7:
							DACM.modify_HomeDeliveryAddress(hInputData,line);	
							break;
						case 8:
							
							WCAM.WorkOrders_Change_Appointment(hInputData,line);
							break;
						case 9:
							
							PMM.payment_Modification(hInputData);
							break;
						case 10:
							
							STHM.modify_LOS_QO_Module(hInputData);
							break;	
						case 11:
							
							STHM.modify_Address_QO_Module(hInputData);
							break;
						case 12:
							
							STHM.modify_STH_ISP_QO_Module(hInputData);
							break;	
						case 13:
							
							STHM.modify_ISP_STH_QO_Module(hInputData);
							break;
						case 14:
							
							STHM.modify_Alternate_Store_Pickup_QO_Module(hInputData);
							break;	
						case 15:
							DM.modify_Delivery_Address_QO_Module(hInputData);
							
							break;
						case 16:
							
							DM.modify_Delivery_Reschedule_QO_Module(hInputData);
							break;	
						case 17:
							
							DM.modify_DeliveryTo_STH_QO_Module(hInputData);
							break;
						case 18:
							
							DM.modify_DeliveryTo_ISP_QO_Module(hInputData);
							break;	
						case 19:
							
							DM.modify_ISPToDelivery_QO_Module(hInputData);
							break;
						case 20:
							
							DM.modify_STHToDelivery_QO_Module(hInputData);
							break;	
						case 21:
							
							DM.modify_ZipCodeOverride_QO_Module(hInputData);
							break;
			
							
						
							
						default:
							System.out.println("no method available");
							break;
					}
			}
		else
		{
		}
		
		}
		catch (Exception e) {
			System.out.println(""+e.getMessage());
			throw new Exception(e);
		}
	}
	

}
