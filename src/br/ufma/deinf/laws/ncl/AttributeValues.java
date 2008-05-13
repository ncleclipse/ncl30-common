package br.ufma.deinf.laws.ncl;

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
		if(type == DataType.MEDIA_DESCRIPTION){
			ret.add("text/html");
			ret.add("text/plain");
			ret.add("text/css");
			ret.add("text/xml");
			ret.add("image/bmp");
			ret.add("image/png");
			ret.add("image/gif");
			ret.add("image/jpeg");
			ret.add("audio/basic");
			ret.add("audio/mp3");
			ret.add("audio/mp2");
			ret.add("audio/mpeg");
			ret.add("audio/mpeg4");
			ret.add("video/mpeg");
			ret.add("application/x-ginga-NCLua");
			ret.add("application/x-ginga-NCLet");
			ret.add("application/x-ginga-settings");
			ret.add("application/x-ginga-time");
		}
		return ret;
	}
}
