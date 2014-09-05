/*
 This file belongs to the Servoy development and deployment environment, Copyright (C) 1997-2014 Servoy BV

 This program is free software; you can redistribute it and/or modify it under
 the terms of the GNU Affero General Public License as published by the Free
 Software Foundation; either version 3 of the License, or (at your option) any
 later version.

 This program is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License along
 with this program; if not, see http://www.gnu.org/licenses or write to the Free
 Software Foundation,Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301
 */

package org.sablo.example.endpoint;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.json.JSONObject;
import org.sablo.Container;
import org.sablo.websocket.BaseWebsocketSession;

/**
 *
 * @author rgansevles
 *
 */
public class HelloWorldWebsocketSession extends BaseWebsocketSession
{
//	private static final WebComponentSpecification EDITOR_SERVICE_SPECIFICATION = new WebComponentSpecification(EDITOR_SERVICE, "", EDITOR_SERVICE, null, null,
//		"", null);

	protected final ConcurrentMap<String, Container> createdForms = new ConcurrentHashMap<>();

	public HelloWorldWebsocketSession(String uuid)
	{
		super(uuid);
	}

	public boolean isValid()
	{
		return true;
	}

	public void handleMessage(JSONObject obj)
	{
	}

	@Override
	public Container getForm(String formName)
	{
		Container form = createdForms.get(formName);
		if (form == null)
		{
			createdForms.put(formName, form = createForm(formName));
		}
		return form;
	}

	public Container createForm(String formName)
	{
		switch (formName)
		{
			case "mainForm" :

				return new MainForm(formName, null);
		}
		throw new IllegalArgumentException("unkown form: " + formName);
	}
}
