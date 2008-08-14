package br.ufma.deinf.laws.ncl;

import java.util.Vector;

public class AttributeValues {
	public static Vector<String> getValues(int type){
		Vector <String> ret = new Vector<String>(); 
		if(type == DataType.XMLNS){
			ret.add("http://www.ncl.org.br/NCL3.0/LanguageProfile");
			ret.add("http://www.ncl.org.br/NCL3.0/EDTVProfile");
			ret.add("http://www.ncl.org.br/NCL3.0/BDTVProfile");
			ret.add("http://www.ncl.org.br/NCL3.0/CausalConnectorProfile");
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
		if(type == DataType.INSTANCE){
			ret.add("new");
			ret.add("instSame");
			ret.add("gradSame");
		}
		if(type == DataType.DEVICE){
			ret.add("systemScreen(i)");
			ret.add("systemAudio(i)");
		}
		if(type == DataType.COMPARATOR){
			ret.add("eq");
			ret.add("ne");
			ret.add("gt");
			ret.add("ge");
			ret.add("lt");
			ret.add("le");
		}
		if(type == DataType.SIMPLEACTION_ROLE){
			ret.add("start");
			ret.add("stop");
			ret.add("abort");
			ret.add("pause");
			ret.add("resume");
			ret.add("set");
		}
		if(type == DataType.SIMPLECONDITION_ROLE){
			ret.add("onBegin");
			ret.add("onEnd");
			ret.add("onAbort");
			ret.add("onPause");
			ret.add("onResume");
			ret.add("onSelection");
			ret.add("onBeginAttribution");
			ret.add("onEndAttribution");
		}
		if(type == DataType.COLOR){
			ret.add("white");
			ret.add("black");
			ret.add("silver");
			ret.add("gray");
			ret.add("red");
			ret.add("marron");
			ret.add("fuchsia");
			ret.add("purple");
			ret.add("lime");
			ret.add("green");
			ret.add("yellow");
			ret.add("olive");
			ret.add("blue");
			ret.add("navy");
			ret.add("aqua");
			ret.add("teal");
		}
		return ret;
	}
}
