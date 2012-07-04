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

/**
 * TODO: Description
 * 
 * @author Roberto Azevedo
 * 
 */
public class NCLReference {
	private String tagname;
	private String attribute;
	private String refTagname;
	private String refAttribute;

	public NCLReference() {
		// TODO Auto-generated constructor stub
	}

	public NCLReference(String tagname, String attribute, String refTagname,
			String refAttribute) {
		super();
		this.tagname = tagname;
		this.attribute = attribute;
		this.refTagname = refTagname;
		this.refAttribute = refAttribute;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getRefTagname() {
		return refTagname;
	}

	public void setRefTagname(String refTagname) {
		this.refTagname = refTagname;
	}

	public String getRefAttribute() {
		return refAttribute;
	}

	public void setRefAttribute(String refAttribute) {
		this.refAttribute = refAttribute;
	}

	public String getTagname() {
		return tagname;
	}
}
