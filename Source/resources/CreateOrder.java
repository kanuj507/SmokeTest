package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


import constants.Constant_Class;

public class CreateOrder {
	

			
	public void  createOrder(String testcase)
	{
		try{
		String XMLType="Dotcom_ISP";

		   String workingDir = System.getProperty("user.dir");
		   System.out.println("Current working directory : " + workingDir);
		   String filepath=workingDir+ "\\TestScripts\\OrderXML\\"+XMLType+".txt";
		   File file=new File(filepath);
		   BufferedReader br = new BufferedReader(new FileReader(filepath));
		   while ((Constant_Class.XMLContent = br.readLine()) != null) {
				System.out.println(Constant_Class.XMLContent );
			}
		   
		    
		   /*
		   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			if (doc.hasChildNodes()) {

				printNote(doc.getChildNodes());

			}

*/		    } catch (Exception e) {
			System.out.println(e.getMessage());
		    }
	}
	
	
	  
	  public void replaceXMLValues()
	  {
		  
	  }
	
	public static void main(String g[])
	{
		//new CreateOrder.createOrder();
		
		CreateOrder CO=new CreateOrder();
	//	CO.createOrder();
		   /*String workingDir = System.getProperty("user.dir");
		   System.out.println("Current working directory : " + workingDir);
	*/}
	
	
	
	//// unused code 
	/*  private static void printNote(org.w3c.dom.NodeList nodeList) {

		    for (int count = 0; count < nodeList.getLength(); count++) {

			org.w3c.dom.Node tempNode = nodeList.item(count);

			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

				// get node name and value
				System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
				System.out.println("Node Value =" + tempNode.getTextContent());

				if (tempNode.hasAttributes()) {

					// get attributes names and values
					org.w3c.dom.NamedNodeMap nodeMap = tempNode.getAttributes();

					for (int i = 0; i < nodeMap.getLength(); i++) {

						org.w3c.dom.Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());

					}

				}

				if (tempNode.hasChildNodes()) {

					// loop again if has child nodes
					printNote(tempNode.getChildNodes());

				}

				System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

			}

		    }

		  }
	  */
	
}
