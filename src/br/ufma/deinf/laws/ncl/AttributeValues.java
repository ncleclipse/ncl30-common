/*******************************************************************************
 * This file is part of the NCL authoring environment - NCL Eclipse.
 *
 * Copyright (C) 2007-2012, LAWS/UFMA.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License version 2 as published by
 * the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License version 2 for
 * more details. You should have received a copy of the GNU General Public 
 * License version 2 along with this program; if not, write to the Free 
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
 * 02110-1301, USA.
 *
 * For further information contact:
 * - ncleclipse@laws.deinf.ufma.br
 * - http://www.laws.deinf.ufma.br/ncleclipse
 * - http://www.laws.deinf.ufma.br
 *
 ******************************************************************************/
package br.ufma.deinf.laws.ncl;

import java.util.Vector;

/**
 * Contains the defaults values of basics data types of NCL.
 * 
 * @author Roberto Azevedo
 * 
 */
public class AttributeValues {
	public static Vector<String> getValues(int type) {
		Vector<String> ret = new Vector<String>();
		if (type == DataType.XMLNS) {
			// ret.add("http://www.ncl.org.br/NCL3.0/LanguageProfile");
			ret.add("http://www.ncl.org.br/NCL3.0/EDTVProfile");
			ret.add("http://www.ncl.org.br/NCL3.0/BDTVProfile");
			ret.add("http://www.ncl.org.br/NCL3.0/CausalConnectorProfile");
		}
		if (type == DataType.SYNCHRONISM_OPERATOR) {
			ret.add("par");
			ret.add("seq");
		}
		if (type == DataType.BOOLEAN_OPERATOR) {
			ret.add("and");
			ret.add("or");
		}
		if (type == DataType.MIME_TYPE) {
			ret.add("text/html");
			ret.add("text/plain");
			ret.add("text/css");
			ret.add("text/xml");
			ret.add("image/bmp");
			ret.add("image/png");
			ret.add("image/mng");
			ret.add("image/gif");
			ret.add("image/jpeg");
			ret.add("audio/basic");
			ret.add("audio/mp3");
			ret.add("audio/mp2");
			ret.add("audio/mpeg");
			ret.add("audio/mpeg4");
			ret.add("video/mpeg");
			ret.add("applications/x-ginga-NCL");
			ret.add("application/x-ncl-NCL");
			ret.add("application/x-ginga-NCLua");
			ret.add("application/x-ncl-NCLua");
			ret.add("application/x-ginga-NCLet");
			ret.add("application/x-ncl-NCLet");
			ret.add("application/x-ginga-settings");
			ret.add("application/x-ncl-settings");
			ret.add("application/x-ginga-time");
			ret.add("application/x-ncl-time");
		}

		if (type == DataType.INSTANCE) {
			ret.add("new");
			ret.add("instSame");
			ret.add("gradSame");
		}

		if (type == DataType.DEVICE) {
			ret.add("systemScreen(i)");
			ret.add("systemAudio(i)");
		}
		if (type == DataType.COMPARATOR) {
			ret.add("eq");
			ret.add("ne");
			ret.add("gt");
			ret.add("gte");
			ret.add("lt");
			ret.add("lte");
		}
		if (type == DataType.SIMPLEACTION_ROLE) {
			ret.add("start");
			ret.add("stop");
			ret.add("abort");
			ret.add("pause");
			ret.add("resume");
			ret.add("set");
		}
		if (type == DataType.SIMPLECONDITION_ROLE) {
			ret.add("onBegin");
			ret.add("onEnd");
			ret.add("onAbort");
			ret.add("onPause");
			ret.add("onResume");
			ret.add("onSelection");
			ret.add("onBeginAttribution");
			ret.add("onEndAttribution");
		}
		if (type == DataType.EVENT) {
			ret.add("presentation");
			ret.add("selection");
			ret.add("attribution");
		}
		if (type == DataType.ACTION) {
			ret.add("start");
			ret.add("stop");
			ret.add("abort");
			ret.add("resume");
			ret.add("pause");
		}
		if (type == DataType.COLOR || 
				type == DataType.TRANSITION_BORDER_COLOR) {
			ret.add("white");
			ret.add("black");
			ret.add("silver");
			ret.add("gray");
			ret.add("red");
			ret.add("maroon");
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
		if(type == DataType.TRANSITION_BORDER_COLOR){
			ret.add("blend");
		}
		if (type == DataType.TRANSITION) {
			ret.add("starts");
			ret.add("stops");
			ret.add("aborts");
			ret.add("pauses");
			ret.add("resumes");
		}
		if (type == DataType.KEY) {
			ret.add("0");
			ret.add("1");
			ret.add("2");
			ret.add("3");
			ret.add("4");
			ret.add("5");
			ret.add("6");
			ret.add("7");
			ret.add("8");
			ret.add("9");
			ret.add("A");
			ret.add("B");
			ret.add("C");
			ret.add("D");
			ret.add("E");
			ret.add("F");
			ret.add("G");
			ret.add("H");
			ret.add("I");
			ret.add("J");
			ret.add("K");
			ret.add("L");
			ret.add("M");
			ret.add("N");
			ret.add("O");
			ret.add("P");
			ret.add("Q");
			ret.add("R");
			ret.add("S");
			ret.add("T");
			ret.add("U");
			ret.add("V");
			ret.add("W");
			ret.add("X");
			ret.add("Y");
			ret.add("Z");
			ret.add("*");
			ret.add("#");
			ret.add("MENU");
			ret.add("INFO");
			ret.add("GUIDE");
			ret.add("CURSOR_DOWN");
			ret.add("CURSOR_LEFT");
			ret.add("CURSOR_RIGHT");
			ret.add("CURSOR_UP");
			ret.add("CHANNEL_DOWN");
			ret.add("CHANNEL_UP");
			ret.add("VOLUME_DOWN");
			ret.add("VOLUME_UP");
			ret.add("ENTER");
			ret.add("RED");
			ret.add("GREEN");
			ret.add("YELLOW");
			ret.add("BLUE");
			ret.add("BACK");
			ret.add("EXIT");
			ret.add("POWER");
			ret.add("REWIND");
			ret.add("STOP");
			ret.add("EJECT");
			ret.add("PLAY");
			ret.add("RECORD");
			ret.add("PAUSE");
		}
		if (type == DataType.TRANSITION_TYPE) {
			ret.add("barWipe");
			ret.add("irisWipe");
			ret.add("clockWipe");
			ret.add("snackWipe");
			ret.add("fade");
		}
		if (type == DataType.TRANSITION_SUBTYPE) {
			// TODO: implementar validacao de subtype
		}
		if (type == DataType.DIRECTION) {
			ret.add("forward");
			ret.add("reverse");
		}
		if (type == DataType.BOOLEAN_VALUE) {
			ret.add("true");
			ret.add("false");
		}
		
		//TODO: Split property and settings values
		if (type == DataType.PROPERTY_NAME) {					
			ret.add("background");
			ret.add("balanceLevel");
			ret.add("bassLevel");
			ret.add("bottom");
			ret.add("bounds");
			ret.add("explicitDur");
			ret.add("fit");
			ret.add("focusIndex");
			ret.add("fontColor");
			ret.add("fontFamily");
			ret.add("fontSize");
			ret.add("fontStyle");
			ret.add("fontVariant");
			ret.add("fontWeight");
			ret.add("height");
			ret.add("left");
			ret.add("location");
			ret.add("plan");
			ret.add("playerLife");
			ret.add("reusePlayer");
			ret.add("right");
			ret.add("scroll");
			ret.add("size");
			ret.add("soundLevel");
			ret.add("style");
			ret.add("top");
			ret.add("transparency");
			ret.add("trebleLevel");
			ret.add("visible");
			ret.add("width");
			ret.add("zIndex");
		}
		
		if(type == DataType.SETTINGS_PROPERTY || 
				type == DataType.PROPERTY_NAME) {
			ret.add("channel.keyboardBounds");
			ret.add("channel.keyCapture");
			ret.add("channel.virtualKeyboard");
			
			ret.add("default.focusBorderColor");
			ret.add("default.focusBorderTransparency");
			ret.add("default.focusBorderWidth");
			ret.add("default.selBorberColor");
			
			ret.add("service.currentFocus");
			ret.add("service.currentKeyMaster");
			
			ret.add("si.channelNumber");
			ret.add("si.numberOfPartialServices");
			ret.add("si.numberOfServices");
			
			ret.add("system.audioType");
			ret.add("system.audioType(i)");
			ret.add("system.caption");
			ret.add("system.classNumber");
			ret.add("system.classType(i)");
			ret.add("system.CPU");
			ret.add("system.devNumber(i)");
			ret.add("system.info(i)");
			ret.add("system.javaConfiguration");
			ret.add("system.javaProfile");
			ret.add("system.language");
			ret.add("system.luaVersion");
			ret.add("system.memory");
			ret.add("system.operatingSystem");
			ret.add("system.returnBitRate(i)");
			ret.add("system.screenGraphicSize");
			ret.add("system.screenGraphicSize(i)");
			ret.add("system.screenSize");
			ret.add("system.screenSize(i)");
			ret.add("system.subtitle");
			
			ret.add("user.age");
			ret.add("user.genre");
			ret.add("user.location");
		}

		if (type == DataType.FIT_VALUE) {
			ret.add("fill");
			ret.add("hidden");
			ret.add("meet");
			ret.add("meetBest");
			ret.add("slice");
		}

		if (type == DataType.SCROLL) {
			ret.add("none");
			ret.add("horizontal");
			ret.add("vertical");
			ret.add("both");
			ret.add("automatic");
		}

		if (type == DataType.FONT_VARIANT) {
			ret.add("normal");
			ret.add("small-caps");
		}

		if (type == DataType.FONT_WEIGHT) {
			ret.add("normal");
			ret.add("bold");
		}

		if (type == DataType.PLAYER_LIFE) {
			ret.add("keep");
			ret.add("close");
		}
		
		// FIXME: Why have we two type DESCRIPTOR_PARAM and PROPERTY with almost
		// the same content?
		// In theory the properties and descriptor params values accept the 
		// same values.
		if (type == DataType.DESCRIPTOR_PARAMS) {
			ret.add("background");
			ret.add("balanceLevel");
			ret.add("baseDeviceRegion");
			ret.add("bassLevel");
			ret.add("bottom");
			ret.add("bounds");
			ret.add("deviceClass");
			ret.add("fit");
			ret.add("fontColor");
			ret.add("fontFamily");
			ret.add("fontStyle");
			ret.add("fontSize");
			ret.add("fontVariant");
			ret.add("fontWeight");
			ret.add("height");
			ret.add("left");
			ret.add("location");
			ret.add("plan");
			ret.add("player");
			ret.add("playerLife");
			ret.add("reusePlayer");
			ret.add("right");
			ret.add("scroll");
			ret.add("size");
			ret.add("soundLevel");
			ret.add("style");
			ret.add("top");
			ret.add("transInBorderColor");
			ret.add("transInBorderWidth");
			ret.add("transInDirection");
			ret.add("transInDur");
			ret.add("transInEndProgress");
			ret.add("transInFadeColor");
			ret.add("transInHorRepeat");
			ret.add("transInStartProgress");
			ret.add("transInSubtype");
			ret.add("transInType");
			ret.add("transInVertRepeat");
			ret.add("transBorderColor");
			ret.add("transOutBorderWidth");
			ret.add("transOutDirection");
			ret.add("transOutDur");
			ret.add("transOutEndProgress");
			ret.add("transOutFadeColor");
			ret.add("transOutHorRepeat");
			ret.add("transOutType");
			ret.add("transOutStartProgress");
			ret.add("transOutSubtype");
			ret.add("transOutVertRepeat");
			ret.add("transparency");
			ret.add("trebleLevel");
			ret.add("visible");
			ret.add("width");
			ret.add("zIndex");
		}
		
		if (type == DataType.MIN_QUANTITY || type == DataType.MAX_QUANTITY) {
			ret.add("unbounded");
		}
		
		if (type == DataType.PLAN) {
			ret.add("video");
			ret.add("graphic");
			ret.add("background");
		}
		return ret;
	}

	/**
	 * @param name
	 * @return
	 */
	public static Vector<String> getValuesFromProperty(String property) {
		Vector<String> suggest = new Vector <String> ();
		
		if (property.equals("background"))
			suggest = AttributeValues.getValues(DataType.COLOR);

		else if (property.equals("visible"))
			suggest = AttributeValues.getValues(DataType.BOOLEAN_VALUE);

		else if (property.equals("fit"))
			suggest = AttributeValues.getValues(DataType.FIT_VALUE);

		else if (property.equals("scroll"))
			suggest = AttributeValues.getValues(DataType.SCROLL);

		else if (property.equals("fontColor"))
			suggest = AttributeValues.getValues(DataType.COLOR);

		else if (property.equals("fontVariant"))
			suggest = AttributeValues.getValues(DataType.FONT_VARIANT);

		else if (property.equals("fontWeight"))
			suggest = AttributeValues.getValues(DataType.FONT_WEIGHT);

		else if (property.equals("playerLife"))
			suggest = AttributeValues.getValues(DataType.PLAYER_LIFE);

		else if (property.equals("reusePlayer"))
			suggest = AttributeValues.getValues(DataType.BOOLEAN_VALUE);
		
		else if(property.equals("plan"))
			suggest = AttributeValues.getValues(DataType.PLAN);
					
		return suggest;
	}
}
