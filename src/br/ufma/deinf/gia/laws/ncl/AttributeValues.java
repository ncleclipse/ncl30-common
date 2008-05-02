package br.ufma.deinf.gia.laws.ncl;

import java.util.Vector;

public class AttributeValues {
	public static Vector<String> getValues(int type){
		Vector <String> ret = new Vector<String>(); 
		if(type == DataType.XMLNS){
			ret.add("http://www.ncl.org.br/NCL3.0/EDTVProfile");
			ret.add("http://www.ncl.org.br/NCL3.0/BDTVProfile");
		}
		if(type == DataType.SYNCHRONISM_OPERATOR){
			ret.add("par");
			ret.add("seq");
		}
		if(type == DataType.BOOLEAN_OPERATOR){
			ret.add("and");
			ret.add("or");
		}
		return ret;
	}
}
