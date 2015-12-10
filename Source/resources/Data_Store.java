package resources;


public class Data_Store
{
	String[][] strData_Store;
	int intDsSize = 0;
	int intSize=0;
	{
		strData_Store = new String[2][];
	}
  

//---------------------------------------------- FUNCTION DEFINITIONS ------------------------------------
	 /**
	  * This function stores (add), or changes the value of a variable in the array
	  * 
	  * @param   strVariable 	Variable to be stored/changed
	  * @param   strValue  		Value to be stored
	  * @return    0 for OK, other value when it fails
	  */
	 public int put(String strVariable, String strValue)
	 {
		  // Try to find the variable in the array
		  for (int i=0; i<intDsSize; i++)
		  if (strData_Store[i][0].equals(strVariable.toUpperCase()))
		  {
			    strData_Store[i][1] = strValue;
			    return 0;
		  }
		  
		  // Value not found in array
		  if (intDsSize == strData_Store.length)
		  {
			   // Make array grow
			   String temp[][] = new String[intDsSize+4][];
			   System.arraycopy(strData_Store, 0, temp, 0, intDsSize);
			   strData_Store = temp;
			   strData_Store[intDsSize] = new String[2];
			   strData_Store[intDsSize][0] = new String(strVariable.toUpperCase());
			   strData_Store[intDsSize][1] = new String(strValue);
			   intDsSize++;
		  }
		  else
		  {
			   strData_Store[intDsSize] = new String[2];
			   strData_Store[intDsSize][0] = new String(strVariable.toUpperCase());
			   strData_Store[intDsSize][1] = new String(strValue);
			   intDsSize++;
		  }
		  intSize++;
		  return 0;
	  }
	 
	 
	 /**
	  * This function returns the value of a variable
	  * @param      strVariable 	Variable which value has to be returned 
	  * @return     The variable value is returned or "" 
	  *       		(empty string) in case the variable isn't found
	  */
	  public String Get(String strVariable)
	  {
		  for (int i=0; i<intDsSize; i++)
		  if (strData_Store[i][0].equalsIgnoreCase(strVariable))
		  {
			  return strData_Store[i][1];
		  }
			  
		  return "&*#%";
	  } 
	 
	 public int getSize()
	 {
		return intSize; 
	 }
	 
	 public void clear()
	 {
		String[][] temp = new String[2][];
		temp=null;
		strData_Store = temp;
		intSize=0;
	 }
	 
	 public String getValueStore(int intPos)
	 {
		 return strData_Store[intPos][1];
	 }	 
}
