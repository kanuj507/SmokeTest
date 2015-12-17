package general;

import java.util.HashMap;

import common.OrderStatusMovement;
import constants.Constant_Class;
import resources.CreateOrder;

public class Business_Process {
	CreateOrder CO=new CreateOrder();
	
	OrderStatusMovement OSM=new OrderStatusMovement();
	public void business_Process_Flow(HashMap<String, String> hInputData) {
		// TODO Auto-generated method stub
		
		

		try
		{
			HashMap<String, Integer> hBusines_Process=new HashMap<String, Integer>();
			{
				hBusines_Process.put("CreateOrder", 1);
				hBusines_Process.put("Move Order Status", 2);	
				hBusines_Process.put("Modify", 3);
				hBusines_Process.put("Cancel", 4);
				hBusines_Process.put("Fulfill", 5);
				hBusines_Process.put("DBValidation",10);
				hBusines_Process.put("Check_Order_Status",12);
				 
			}
		
		

			switch (hBusines_Process.get(hInputData.get("BUSINESS_PROCESS"))) 
				{
			
				          	case 1:	
							
							 CO.createOrder(hInputData.get("TCID"));
							break;
				         	case 2:
				         		OSM.orderStatusMovement(hInputData);
						break;
						case 3:
							MM.orderModifyModule(hInputData);
						MM.verifyStatusHold(hInputData);
						break;
					case 4:
						CM.CancelModule(hInputData);
						break;
					case 5: 
					C.VerifyOrderStatus(hInputData);
						break;
									
					case 10:
						SOP.DBValidation(hInputData);
					break;	
					case 12:
						SOP.Check_Order_Status_Module(hInputData);
						
					break;
				 	default:
						System.out.println("no method   available ");
						break;
				}

			
		}
		catch (Exception e) {
		
			System.out.println(e.getMessage());
			throw new Exception(e);
		}

	}

}
