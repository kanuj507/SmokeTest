package functionalArea;

import java.util.HashMap;

import org.testng.Reporter;

import constants.Constant_Class;

public class OrderCancellation {

	
	public void CancelModule(HashMap<String, String> hInputData) throws Exception
	{
		int line=0;
		try
		{
			HashMap<String, Integer> hBusines_Function=new HashMap<String, Integer>();
			{
			/*	hBusines_Function.put("General", 1);
				hBusines_Function.put("My Account Specific line", 2);
				hBusines_Function.put("My Account Entire Order", 3);
				hBusines_Function.put("QO Entire order", 5);
				hBusines_Function.put("QO single line", 6);
				hBusines_Function.put("QO multi line partial", 7);
				hBusines_Function.put("QO partial quantity", 8);
				hBusines_Function.put("OMS partial quantity", 9);
				hBusines_Function.put("OMS SingleLine with PSP", 10);*/
				hBusines_Function.put("ENTIREORDER", 1);
				hBusines_Function.put("SINGLELINE", 2);
				hBusines_Function.put("MULTILINE", 3);
				hBusines_Function.put("PARTIALQTY", 4);
				
			
				
				try
				{
					line=Integer.parseInt(hInputData.get("DATA"));
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		if(Constant_Class.StatusFlag)
		{
			
//			if(hInputData.get("ON_1").equalsIgnoreCase("Line"))
//			{
//				hInputData.put("FLOW_"+line, hInputData.get("WHERE_STATUS"));
//			}
					switch (hBusines_Function.get(hInputData.get("BUSINESS_FUNCTION"))) 
					{
						case 1:	
							completeOrderCancellation(hInputData);
							break;
						
							
						default:
							System.out.println("no method available");
							break;
					}
			}
		else
		{
			System.out.println("Order is not in particular Status");
		}
		
		}
		catch (Exception e) {
			System.out.println(""+e.getMessage());
			throw new Exception(e);
		}
	}

	private void completeOrderCancellation(HashMap<String, String> hInputData) {
		// TODO Auto-generated method stub
		
	}
	
	
}
