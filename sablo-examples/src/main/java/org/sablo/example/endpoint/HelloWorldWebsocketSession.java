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

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sablo.Container;
import org.sablo.WebComponent;
import org.sablo.example.forms.MainForm;
import org.sablo.specification.WebComponentSpecification;
import org.sablo.websocket.BaseWebsocketSession;
import org.sablo.websocket.WebsocketEndpoint;

/**
 *
 * @author rgansevles
 *
 */
public class HelloWorldWebsocketSession extends BaseWebsocketSession
{
//	private static final WebComponentSpecification EDITOR_SERVICE_SPECIFICATION = new WebComponentSpecification(EDITOR_SERVICE, "", EDITOR_SERVICE, null, null,
//		"", null);

	private static final class FormSpecification extends WebComponentSpecification
	{
		private FormSpecification()
		{
			super("form_spec", "", "", null, null, "", null);
			//putProperty("size", new PropertyDescription("size", TypesRegistry.getType("dimension")));
		}
	}

	private static final WebComponentSpecification FORM_SPEC = new FormSpecification();

	protected final ConcurrentMap<String, Container> createdForms = new ConcurrentHashMap<>();

	public HelloWorldWebsocketSession(String uuid)
	{
		super(uuid);
	}

	public boolean isValid()
	{
		return true;
	}

	public void handleMessage(final JSONObject obj)
	{
		// TODO: move to superclass
		startHandlingEvent();
//		if (client != null) J2DBGlobals.setServiceProvider(client);
		try
		{
			// TODO: move these commands to services
			// always just try to set the current window name
			String event = obj.getString("cmd");
			switch (event)
			{
//				case "datapush" :
//				{
//					pushChanges(obj, false);
//					break;
//				}
//				case "svypush" :
//				{
//					pushChanges(obj, true);
//					break;
//				}
				case "event" :
				{
					getEventDispatcher().addEvent(new Runnable()
					{
						@Override
						public void run()
						{
							try
							{
								Container form = getForm(obj.getString("formname"));
								WebComponent webComponent = form.getComponent(obj.getString("beanname"));
								JSONArray jsargs = obj.getJSONArray("args");
								String eventType = obj.getString("event");
								Object[] args = new Object[jsargs == null ? 0 : jsargs.length()];
								for (int i = 0; jsargs != null && i < jsargs.length(); i++)
								{
									args[i] = jsargs.get(i);
								}

								//	pushChanges(obj);
								Object result = null;
								String error = null;
								try
								{
									result = webComponent.executeEvent(eventType, args);
								}
								catch (Exception e)
								{
									e.printStackTrace();
//										Debug.error(e);
									error = e.getMessage();
								}
								if (obj.has("cmsgid")) // client wants response
								{
									WebsocketEndpoint.get().sendResponse(obj.get("cmsgid"), error == null ? result : error, null, error == null);
								}
							}
							catch (JSONException | IOException e)
							{
								e.printStackTrace();
//								Debug.error(e);
//								sendInternalError(e);
							}
						}
					});

					break;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
//			Debug.error(e);
//			sendInternalError(e);
		}
		finally
		{
			stopHandlingEvent();
		}
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

				return new MainForm(formName, FORM_SPEC);
		}
		throw new IllegalArgumentException("unkown form: " + formName);
	}
}
