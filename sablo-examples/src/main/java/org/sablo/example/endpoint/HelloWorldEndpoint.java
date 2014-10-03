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


import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.sablo.websocket.WebsocketEndpoint;

/**
 * RAGTEST doc
 * @author rgansevles
 *
 */

@ServerEndpoint(value = "/websocket/{sessionid}")
public class HelloWorldEndpoint extends WebsocketEndpoint
{
	public static final String HELLO_WORLD_ENDPOINT = "helloworld";

	public HelloWorldEndpoint()
	{
		super(HELLO_WORLD_ENDPOINT);
	}

	@OnOpen
	public void start(Session newSession, @PathParam("sessionid")
	String sessionid) throws Exception
	{
		start(newSession, sessionid, null, null);
	}

	@Override
	@OnMessage
	public void incoming(String msg, boolean lastPart)
	{
		super.incoming(msg, lastPart);
	}

	@Override
	@OnClose
	public void onClose()
	{
		super.onClose();
	}

	@OnError
	public void onError(Throwable t)
	{
		log.error("IOException happened", t);
	}
}
