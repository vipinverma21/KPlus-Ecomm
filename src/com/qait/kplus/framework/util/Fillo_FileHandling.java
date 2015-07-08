package com.qait.kplus.framework.util;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;

public class Fillo_FileHandling {

	public static void main(String[] args) throws FilloException {
		Fillo fill = new Fillo();
		Connection fillconnect = fill.getConnection("C:/Users/vipinverma/Desktop/KplusTestData.xlsx");
		String Setquery = "Select * from Internal_Medicine";
		Recordset recordset=fillconnect.executeQuery(Setquery);
		
		int i=0;
			System.out.println(recordset.getField(i++));
			recordset.close();
			fillconnect.close();

	}

}
