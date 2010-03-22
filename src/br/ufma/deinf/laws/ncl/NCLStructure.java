/*******************************************************************************
 * This file is part of the authoring environment in Nested Context Language -
 * NCL Eclipse.
 * 
 * Copyright: 2007-2010 UFMA/LAWS (Laboratory of Advanced Web Systems), All
 * Rights Reserved.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License version 2 as published by
 * the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License version 2 for
 * more details.
 * 
 * You should have received a copy of the GNU General Public License version 2
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,
 * USA.
 *
 * For further information contact:
 * - ncleclipse@laws.deinf.ufma.br
 * - http://www.laws.deinf.ufma.br/ncleclipse
 * - http://www.laws.deinf.ufma.br
 ******************************************************************************/
package br.ufma.deinf.laws.ncl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import br.ufma.deinf.laws.util.MultiHashMap;

/**
 * This class keep the NCL structure language. Useful for validating and
 * autocomplete.
 * 
 * @author Roberto Azevedo
 * 
 */
public class NCLStructure {
	private static NCLStructure instance = null;
	private static Map<String, Map<String, Boolean>> attributes = new HashMap<String, Map<String, Boolean>>();
	private static Map<String, Map<String, Integer>> dataTypes = new HashMap<String, Map<String, Integer>>();
	private static Map<String, Map<String, Character>> nesting = new HashMap<String, Map<String, Character>>();
	private static MultiHashMap references = new MultiHashMap();

	/**
	 * Construtor privado Singleton
	 */
	private NCLStructure() {
		// nomenclature:
		// '?' means optional (0 or 1 occurence)
		// '*' means optional repetition (0 or more occurences)
		// '+' means repetition (1 or more occureences)
		// '1' means 1 occurence
		// '#' means that all the child with '#' must have at least one
		// occurence
		// 'a' means one of the two child elements
		// 'b' means one of the two child elements

		// Extended Structure Module
		// ncl
		att("ncl", "id", true, DataType.ID);
		att("ncl", "title", false, DataType.STRING);
		att("ncl", "xmlns", false, DataType.XMLNS);
		att("ncl", "xmlns:xsi", false, DataType.URI);
		att("ncl", "xsi:schemaLocation", false);
		ct("ncl", "head", '?');
		ct("ncl", "body", '?');

		// head
		att("head", null, false);
		ct("head", "importedDocumentBase", '?');
		ct("head", "ruleBase", '?');
		ct("head", "transitionBase", '?');
		ct("head", "regionBase", '*');
		ct("head", "descriptorBase", '?');
		ct("head", "connectorBase", '?');

		// body
		att("body", "id", false, DataType.ID);
		ct("body", "port", '*');
		ct("body", "property", '*');
		ct("body", "media", '*');
		ct("body", "context", '*');
		ct("body", "switch", '*');
		ct("body", "link", '*');

		// Extended Layout Module
		// regionBase
		att("regionBase", "id", false, DataType.ID);
		att("regionBase", "device", false, DataType.DEVICE);
		att("regionBase", "region", false, DataType.ID);
		// Tem q ter pelo menos um dos dois (importBase | region)+
		ct("regionBase", "importBase", '#');
		ct("regionBase", "region", '#');

		// region
		att("region", "id", true, DataType.ID);
		att("region", "title", false, DataType.STRING);
		att("region", "left", false, DataType.SIZE);
		att("region", "right", false, DataType.SIZE);
		att("region", "top", false, DataType.SIZE);
		att("region", "bottom", false, DataType.SIZE);
		att("region", "height", false, DataType.SIZE);
		att("region", "width", false, DataType.SIZE);
		att("region", "zIndex", false, DataType.ZINDEX); // pode ser negativo
		// (não ta
		// funcionando)
		ct("region", "region", '*');

		// Extended Media Module
		// media
		att("media", "id", true, DataType.ID);
		att("media", "src", false, DataType.URI);
		att("media", "refer", false, DataType.ID);
		att("media", "instance", false, DataType.INSTANCE); // new, instSame,
		// gradSame
		att("media", "type", false, DataType.MIME_TYPE); // Não ta funcionando
		att("media", "descriptor", false, DataType.ID);
		ct("media", "area", '*');
		ct("media", "property", '*');

		// Extended Context Module
		// context
		att("context", "id", true, DataType.ID);
		att("context", "refer", false, DataType.ID);
		ct("context", "port", '*');
		ct("context", "property", '*');
		ct("context", "media", '*');
		ct("context", "context", '*');
		ct("context", "link", '*');
		ct("context", "switch", '*');

		// Extended MediaContentAnchor Module
		// area
		att("area", "id", true, DataType.ID);
		att("area", "coords", false, DataType.COORDINATE);
		att("area", "begin", false, DataType.TIME);
		att("area", "end", false, DataType.TIME);
		att("area", "text", false, DataType.STRING);
		att("area", "position", false, DataType.INTEGER);
		att("area", "first", false, DataType.STRING);
		att("area", "last", false, DataType.STRING);
		att("area", "label", false, DataType.STRING);

		// ainda nao faz parte da norma
		att("area", "clip", false, DataType.STRING);
		att("area", "beginOffset", false, DataType.STRING);
		att("area", "endOffset", false, DataType.STRING);

		// Extended CompositeNodeInterface Module
		// port
		att("port", "id", true, DataType.ID);
		att("port", "component", true, DataType.ID); // Verificar se é isso
		// mesmo
		att("port", "interface", false, DataType.ID); // Verificar se é isso
		// mesmo

		// Extended AttributeAnchor Module
		// property
		att("property", "name", true, DataType.PROPERTY_NAME);
		att("property", "value", false, DataType.STRING);

		// Extended SwitchInterface Module
		// switchPort
		att("switchPort", "id", true, DataType.ID);
		ct("switchPort", "mapping", '+');

		// mapping
		att("mapping", "component", true, DataType.ID);
		att("mapping", "interface", false, DataType.ID);

		// Extended Descriptor Module
		// descriptor
		att("descriptor", "id", true, DataType.ID);
		att("descriptor", "player", false, DataType.STRING);
		att("descriptor", "explicitDur", false, DataType.TIME);
		att("descriptor", "region", false, DataType.ID);
		att("descriptor", "freeze", false);
		att("descriptor", "moveLeft", false);
		att("descriptor", "moveRight", false);
		att("descriptor", "moveDown", false);
		att("descriptor", "moveUp", false);
		att("descriptor", "focusIndex", false);
		att("descriptor", "focusBorderColor", false, DataType.COLOR);
		att("descriptor", "focusBorderWidth", false);
		att("descriptor", "focusBorderTransparency", false);
		att("descriptor", "focusSrc", false, DataType.URI); // é isso mesmo ??
		att("descriptor", "focusSelSrc", false, DataType.URI); // é isso mesmo
		// ??
		att("descriptor", "selBorderColor", false, DataType.COLOR);
		att("descriptor", "transIn", false);
		att("descriptor", "transOut", false);
		ct("descriptor", "descriptorParam", '*');

		// descriptorParam
		att("descriptorParam", "name", true, DataType.ID);
		att("descriptorParam", "value", true, DataType.STRING);

		// descriptorBase
		att("descriptorBase", "id", false, DataType.ID);
		ct("descriptorBase", "importBase", '#');
		ct("descriptorBase", "descriptor", '#');
		ct("descriptorBase", "descriptorSwitch", '#');

		// Extended Linking Module
		// bind
		att("bind", "role", true, DataType.ID);
		att("bind", "component", true, DataType.ID);
		att("bind", "interface", false, DataType.ID);
		att("bind", "descriptor", false, DataType.ID);
		ct("bind", "bindParam", '*');

		// bindParam
		att("bindParam", "name", true, DataType.ID);
		att("bindParam", "value", true, DataType.STRING);

		// linkParam
		att("linkParam", "name", true, DataType.ID);
		att("linkParam", "value", true, DataType.STRING);

		// link
		att("link", "id", false, DataType.ID);
		att("link", "xconnector", true, DataType.XCONNECTOR);
		ct("link", "linkParam", '*');
		ct("link", "bind", '+');

		// Extended CausalConnectorFunctionality Module
		// causalConnector
		att("causalConnector", "id", true, DataType.ID);
		ct("causalConnector", "connectorParam", '*');
		ct("causalConnector", "simpleCondition", 'a');
		ct("causalConnector", "compoundCondition", 'a');
		ct("causalConnector", "simpleAction", 'b');
		ct("causalConnector", "compoundAction", 'b');

		// connectorParam
		att("connectorParam", "name", true, DataType.ID);
		att("connectorParam", "type", false);

		// simpleCondition
		att("simpleCondition", "role", true, DataType.SIMPLECONDITION_ROLE);
		att("simpleCondition", "delay", false);
		att("simpleCondition", "eventType", false, DataType.EVENT);
		att("simpleCondition", "key", false, DataType.KEY);
		att("simpleCondition", "transition", false, DataType.TRANSITION);
		att("simpleCondition", "min", false, DataType.QUANTITY);
		att("simpleCondition", "max", false, DataType.QUANTITY);
		att("simpleCondition", "qualifier", false, DataType.BOOLEAN_OPERATOR);

		// compoundCondition
		att("compoundCondition", "operator", true, DataType.BOOLEAN_OPERATOR);
		att("compoundCondition", "delay", false, DataType.TIME);
		ct("compoundCondition", "simpleCondition", '#');
		ct("compoundCondition", "compoundCondition", '#');
		ct("compoundCondition", "assessmentStatement", '*');
		ct("compoundCondition", "compoundStatement", '*');

		// simpleAction
		att("simpleAction", "role", true, DataType.SIMPLEACTION_ROLE);
		att("simpleAction", "delay", false);
		att("simpleAction", "eventType", false, DataType.EVENT);
		att("simpleAction", "actionType", false, DataType.ACTION);
		att("simpleAction", "value", false);
		att("simpleAction", "min", false, DataType.QUANTITY);
		att("simpleAction", "max", false, DataType.QUANTITY);
		att("simpleAction", "qualifier", false, DataType.SYNCHRONISM_OPERATOR);
		att("simpleAction", "repeat", false);
		att("simpleAction", "repeatDelay", false);
		att("simpleAction", "duration", false);
		att("simpleAction", "by", false);

		// compoundAction
		att("compoundAction", "operator", true, DataType.SYNCHRONISM_OPERATOR);
		att("compoundAction", "delay", false);
		ct("compoundAction", "simpleAction", '#');
		ct("compoundAction", "compoundAction", '#');

		// assessmentStatement
		att("assessmentStatement", "comparator", true, DataType.COMPARATOR);
		// TODO: attributeAssessment ( attributeAssessment | valueAssessment )
		ct("assessmentStatement", "attributeAssessment", '*');
		ct("assessmentStatement", "valueAssessment", '*');

		// attributeAssessment
		att("attributeAssessment", "role", true);
		att("attributeAssessment", "eventType", true, DataType.EVENT);
		att("attributeAssessment", "key", false, DataType.KEY);
		att("attributeAssessment", "attributeType", false); // salles disse q eh
		// opcional em
		// 21/05/2008
		att("attributeAssessment", "offset", false);

		// valueAssessment
		att("valueAssessment", "value", true);

		// compoundStatement
		att("compoundStatement", "operator", true, DataType.BOOLEAN_OPERATOR);
		att("compoundStatement", "isNegated", false, DataType.BOOLEAN_VALUE);
		ct("compoundStatement", "assessmentStatement", '#');
		ct("compoundStatement", "compoundStatement", '#');

		// Extended ConnectorBase Module
		// connectorBase
		att("connectorBase", "id", false, DataType.ID);
		ct("connectorBase", "importBase", '*');
		ct("connectorBase", "causalConnector", '*');

		// Extended TestRule Module
		// ruleBase
		att("ruleBase", "id", false, DataType.ID);
		ct("ruleBase", "importBase", '#');
		ct("ruleBase", "rule", '#');
		ct("ruleBase", "compositeRule", '#');

		// rule
		att("rule", "id", true, DataType.ID);
		att("rule", "var", true);
		att("rule", "comparator", true, DataType.COMPARATOR);
		att("rule", "value", true);

		// compositeRule
		att("compositeRule", "id", true, DataType.ID);
		att("compositeRule", "operator", true, DataType.BOOLEAN_OPERATOR);
		ct("compositeRule", "rule", '#');
		ct("compositeRule", "compositeRule", '#');

		// Extended TestRule Module
		// bindRule
		att("bindRule", "constituent", true);
		att("bindRule", "rule", true);

		// Extended ContentControl Module
		// switch
		att("switch", "id", true, DataType.ID);
		att("switch", "refer", false);
		ct("switch", "defaultComponent", '?');
		ct("switch", "switchPort", '*');
		ct("switch", "bindRule", '*');
		ct("switch", "media", '*');
		ct("switch", "context", '*');
		ct("switch", "switch", '*');

		// defaultComponent
		att("defaultComponent", "component", true);

		// Extended DescriptorControl Module
		// descriptorSwitch
		att("descriptorSwitch", "id", true, DataType.ID);
		ct("descriptorSwitch", "defaultDescriptor", '?');
		ct("descriptorSwitch", "descriptor", '*');
		ct("descriptorSwitch", "bindRule", '*');

		// defaultDescriptor
		att("defaultDescriptor", "descriptor", true);

		// Extended Import Module
		// importBase
		att("importBase", "alias", true);
		att("importBase", "documentURI", true, DataType.URI);
		att("importBase", "region", false);

		// importedDocumentBase
		att("importedDocumentBase", "id", false, DataType.ID);
		ct("importedDocumentBase", "importNCL", '+');

		// importNCL
		att("importNCL", "alias", true);
		att("importNCL", "documentURI", true, DataType.URI);

		// Extended TransitionBase Module
		// transitionBase
		att("transitionBase", "id", false, DataType.ID);
		ct("transitionBase", "importBase", '#');
		ct("transitionBase", "transition", '#');

		// Extended BasicTransition module
		// transition
		att("transition", "id", true, DataType.ID);
		att("transition", "type", true, DataType.TRANSITION_TYPE);
		att("transition", "subtype", false, DataType.TRANSITION_SUBTYPE);
		att("transition", "dur", false, DataType.TIME);
		att("transition", "startProgress", false);
		att("transition", "endProgress", false);
		att("transition", "direction", false, DataType.DIRECTION);
		att("transition", "fadeColor", false, DataType.COLOR);
		att("transition", "horRepeat", false, DataType.INTEGER);
		att("transition", "vertRepeat", false, DataType.INTEGER);
		att("transition", "borderWidth", false, DataType.INTEGER);
		att("transition", "borderColor", false, DataType.COLOR);

		// Extended Metainformation module
		// meta
		ct("head", "meta", '*');
		ct("body", "meta", '*');
		ct("context", "meta", '*');
		att("meta", "name", true);
		att("meta", "content", true);

		// metadata
		// TODO: "RDF tree" as child
		ct("head", "metadata", '*');
		ct("body", "metadata", '*');
		ct("context", "metadata", '*');
		att("metadata", null, false);

		// Referencias
		// tagname, atributo, refTagname, refTagAtributo

		// regionBase
		ref("regionBase", "region", "region", "id");

		// media
		ref("media", "descriptor", "descriptor", "id");
		ref("media", "descriptor", "descriptorSwitch", "id");
		ref("media", "refer", "media", "id");

		// context
		ref("context", "refer", "context", "id");
		ref("context", "refer", "body", "id");
		// ref("context", "refer", "ncl", "id"); // isso nao pode mais

		// descriptor
		ref("descriptor", "region", "region", "id");
		ref("descriptor", "transIn", "transition", "id");
		ref("descriptor", "transOut", "transition", "id");

		// port
		ref("port", "component", "media", "id");
		ref("port", "component", "context", "id");
		ref("port", "component", "switch", "id");
		ref("port", "interface", "area", "id");
		ref("port", "interface", "port", "id");
		// ref("port", "interface", "property", "name"); //Dúvida! Verificar
		// isto!

		// bind
		ref("bind", "component", "media", "id");
		ref("bind", "component", "context", "id");
		ref("bind", "component", "switch", "id");
		ref("bind", "role", "simpleCondition", "role");
		ref("bind", "role", "simpleAction", "role");
		ref("bind", "role", "attributeAssessment", "role");
		// ref("bind", "role", "compoundCondition", "role");
		// ref("bind", "role", "compoundAction", "role");
		ref("bind", "interface", "area", "id");
		ref("bind", "interface", "port", "id");
		ref("bind", "interface", "property", "name");
		ref("bind", "descriptor", "descriptor", "id");

		// bindParam
		// ref("bindParam", "name", "connectorParam", "name");

		// bindRule
		ref("bindRule", "constituent", "media", "id");
		ref("bindRule", "constituent", "context", "id");
		ref("bindRule", "constituent", "switch", "id");
		ref("bindRule", "constituent", "descriptor", "id");
		ref("bindRule", "rule", "rule", "id");
		ref("bindRule", "rule", "compositeRule", "id");

		// link
		ref("link", "xconnector", "causalConnector", "id");

		// linkParam
		ref("linkParam", "name", "connectorParam", "name");
		// bindParam
		ref("bindParam", "name", "connectorParam", "name");

		// switch
		ref("switch", "refer", "switch", "id");

		// mapping
		ref("mapping", "component", "media", "id");
		ref("mapping", "component", "context", "id");
		ref("mapping", "component", "switch", "id");
		ref("mapping", "interface", "area", "id");
		ref("mapping", "interface", "port", "id");
		ref("mapping", "interface", "property", "name");

		// defaultComponent
		ref("defaultComponent", "component", "media", "id");
		ref("defaultComponent", "component", "context", "id");
		ref("defaultComponent", "component", "switch", "id");

		// defaultDescriptor
		ref("defaultDescriptor", "descriptor", "descriptor", "id");

	}

	/**
	 * Retorna a instância única da classe
	 * 
	 * @return A instância de {@link NCLStructure}
	 */
	public static NCLStructure getInstance() {
		if (instance == null)
			instance = new NCLStructure();
		return instance;
	}

	/**
	 * 
	 * @return attributes
	 */
	public static Map<String, Map<String, Boolean>> getAttributes() {
		return attributes;
	}

	/**
	 * 
	 * @param attributes
	 */
	public void setAttributes(Map<String, Map<String, Boolean>> attributes) {
		this.attributes = attributes;
	}

	/**
	 * 
	 * @return nesting
	 */
	public Map<String, Map<String, Character>> getNesting() {
		return nesting;
	}

	/**
	 * 
	 * @param nesting
	 */
	public void setNesting(Map<String, Map<String, Character>> nesting) {
		this.nesting = nesting;
	}

	private void att(String elementName, String attributeName, boolean required) {
		if (!attributes.containsKey(elementName)) {
			attributes.put(elementName, new HashMap());
		}
		Map<String, Boolean> atts = instance.attributes.get(elementName);
		if (atts == null) {
			atts = new HashMap();
			attributes.put(elementName, atts);
		}
		atts.put(attributeName, required);
	}

	// Além de gravar se é requerido ou não verifica o tipo do dado
	private void att(String elementName, String attributeName,
			boolean required, int type) {
		if (!attributes.containsKey(elementName)) {
			attributes.put(elementName, new LinkedHashMap());
			dataTypes.put(elementName, new HashMap());
		}
		Map<String, Boolean> atts = instance.attributes.get(elementName);
		Map<String, Integer> dt = instance.dataTypes.get(elementName);
		if (atts == null) {
			atts = new HashMap();
			attributes.put(elementName, atts);
		}
		if (dt == null) {
			dt = new HashMap();
			dataTypes.put(elementName, dt);
		}
		atts.put(attributeName, required);
		dt.put(attributeName, type);
	}

	private void ct(String elementName, String childElementName,
			char cardinality) {
		if (!nesting.containsKey(elementName)) {
			nesting.put(elementName, new HashMap());
		}
		Map<String, Character> childElement = instance.nesting.get(elementName);
		if (childElement == null) {
			childElement = new HashMap();
			nesting.put(elementName, childElement);
		}
		childElement.put(childElementName, cardinality);
	}

	private void ref(String elementName, String attributeName,
			String refElementName, String refAttributeName) {
		NCLReference nclReference = new NCLReference(elementName,
				attributeName, refElementName, refAttributeName);
		references.put(elementName, nclReference);
	}

	/**
	 * Verifica se existe um elemento com o nome elementName na estrutura da
	 * linguagem.
	 * 
	 * @param elementName
	 * @return
	 */
	public static boolean isElement(String elementName) {
		return attributes.containsKey(elementName)
				|| nesting.containsKey(elementName);
	}

	/**
	 * @param elementName
	 * @param attributeName
	 * @return
	 */
	public static boolean isAttribute(String elementName, String attributeName) {
		if (!getAttributes().containsKey(elementName))
			return false;
		else
			return getAttributes().get(elementName).containsKey(attributeName);
	}

	public static Map<String, Map<String, Integer>> getDataTypes() {
		return dataTypes;
	}

	public static void setDataTypes(Map<String, Map<String, Integer>> dataTypes) {
		NCLStructure.dataTypes = dataTypes;
	}

	/**
	 * Retorna o dataType do atributo, conforme a classe DataType
	 * 
	 * @param elementName
	 * @param attributeName
	 * @return data type of attribute
	 */
	public static Integer getDataType(String elementName, String attributeName) {
		if (!getDataTypes().containsKey(elementName)
				|| !getDataTypes().get(elementName).containsKey(attributeName))
			return new Integer(DataType.UNKNOWN);
		else
			return getDataTypes().get(elementName).get(attributeName);
	}

	/**
	 * 
	 * @param parentElementName
	 * @param childElementName
	 * @return
	 */
	public static boolean isChild(String parentElementName,
			String childElementName) {
		if (!nesting.containsKey(parentElementName))
			return false;
		else
			return nesting.get(parentElementName).containsKey(childElementName);
	}

	/**
	 * 
	 * @param elementName
	 * @return
	 */
	public static Map<String, Character> getChildrenCardinality(
			String elementName) {
		Map<String, Character> empty = new HashMap();
		if (!nesting.containsKey(elementName))
			return empty;
		else
			return nesting.get(elementName);
	}

	/**
	 * 
	 * @param elementName
	 * @return
	 */
	public static Map<String, Boolean> getAttributes(String elementName) {
		Map<String, Boolean> empty = new HashMap();
		if (!attributes.containsKey(elementName))
			return empty;
		else
			return attributes.get(elementName);
	}

	public static Map<String, Integer> getDataTypes(String elementName) {
		Map<String, Integer> empty = new HashMap();
		if (!attributes.containsKey(elementName))
			return empty;
		else
			return dataTypes.get(elementName);
	}

	/**
	 * 
	 * @param elementName
	 * @return
	 */
	public boolean isRequiredId(String elementName) {
		if (!instance.getAttributes().containsKey(elementName))
			return false;
		if (!instance.getAttributes().get(elementName).containsKey("id"))
			return false;
		return instance.getAttributes().get(elementName).containsKey("id") == true;
	}

	public boolean isReference(String elementName, String attributeName) {
		if (references.containsKey(elementName)) {
			Collection<NCLReference> collection = references.get(elementName);
			Iterator it = collection.iterator();
			while (it.hasNext()) {
				NCLReference ref = (NCLReference) it.next();
				if (ref.getAttribute().equals(attributeName))
					return true;
			}
		}
		return false;
	}

	public Collection getNCLReference(String elementName, String attributeName) {
		if (references.containsKey(elementName)) {
			Collection<NCLReference> ret = new ArrayList();
			Collection<NCLReference> collection = references.get(elementName);
			Iterator it = collection.iterator();
			while (it.hasNext()) {
				NCLReference ref = (NCLReference) it.next();
				if (ref.getAttribute().equals(attributeName))
					ret.add(ref);
			}
			return ret;
		}
		return null;
	}

	public Collection getNCLReverseReference(String elementName,
			String attributeName) {
		Iterator it = references.keySet().iterator();
		Collection<NCLReference> ret = new ArrayList();
		while (it.hasNext()) {
			Collection<NCLReference> collection = (Collection<NCLReference>) references
					.get(it.next());
			Iterator it2 = collection.iterator();
			while (it2.hasNext()) {
				NCLReference ref = (NCLReference) it2.next();
				if (ref.getRefAttribute().equals(attributeName)
						&& ref.getRefTagname().equals(elementName))
					ret.add(ref);
			}
		}
		return ret;
	}
}
