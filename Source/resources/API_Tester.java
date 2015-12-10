package resources;

public class API_Tester {

	public String api_Tester(String service_Name,String inXML,String environment)
	{
		String result="";
		
		try
		{
			if(environment.equals("01")) 
			{
				result=invoke(service_Name, inXML, true,"ptl01omsap01a",30180);
			}
			else if(environment.equals("02"))
			{
				result=invoke(service_Name, inXML,true,"ptl01omsap01a",30280);
			}
			else if(environment.equals("03"))
			{
				result=invoke(service_Name, inXML, true,"ptl01omsap01a",30380);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public String invoke(String apiName,String inXML, boolean isFlow, String host,int port) throws Exception {
		System.out.println("Inside invoke");
		return invoke(apiName, inXML,null, isFlow,host,port);
	}
	
	public String invoke(String apiName,String inXML,String templateXML, boolean isFlow,String host,int port) throws Exception {
				
		java.net.URL url = new java.net.URL("http",host,port,"/yantra/interop/InteropHttpServlet");
	       System.out.println("URL: "+url.toString());
	        java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        java.io.OutputStream out = conn.getOutputStream();
	        java.io.Writer wr = new java.io.OutputStreamWriter(out);
	        /*YFSEnvironment.progId=YantraHTTPApiCaller&InteropApiName=getOrderList&IsFlow=N&YFSEnvironment.userId=impl&InteropApiData=%3COrder+OrderHeaderKey%3D%2720110119061551583429280%27%3E%3C%2FOrder%3E
	         * 
	         * 
	         */
	        wr.write("YFSEnvironment.progId=&");
	        //wr.write("YFSEnvironment.progId=YantraHTTPApiCaller&");
	        wr.write("InteropApiName="+apiName+"&");
	        wr.write("IsFlow="+(isFlow?"Y":"N")+"&");
	       // wr.write("YFSEnvironment.userId=admin&");
	        wr.write("InteropApiData=");
	        wr.write(java.net.URLEncoder.encode(inXML));
	      //System.out.println(java.net.URLEncoder.encode(inXML));
	        if ( templateXML != null ) {
	            wr.write("&TemplateData=");
	            wr.write(java.net.URLEncoder.encode(templateXML));
	        }
	        wr.close();
	        java.io.InputStream in = conn.getInputStream();
	        java.io.Reader reader = new java.io.InputStreamReader(in);
	        java.io.StringWriter sw = new java.io.StringWriter();
	        char[]buf = new char[500];
	        int bread = 0;
	        while ( (bread=reader.read(buf))!= -1 ) {
	            sw.write(buf,0,bread);
	        }
	        reader.close();
	        System.out.println("Response:------"+sw);
	        return sw.toString();

	
	}


}
