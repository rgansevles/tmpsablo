package org.sablo.example;

import javax.servlet.annotation.WebFilter;

import org.sablo.WebEntry;
import org.sablo.example.endpoint.HelloWorldEndpoint;
import org.sablo.example.endpoint.HelloWorldWebsocketSession;
import org.sablo.websocket.IWebsocketSession;
import org.sablo.websocket.IWebsocketSessionFactory;

@WebFilter(urlPatterns = { "/sablo-examples/helloworld/*" })
public class HelloWorld extends WebEntry
{
	public HelloWorld()
	{
		super(HelloWorldEndpoint.HELLO_WORLD_ENDPOINT);
	}

	public static final String PATH = "examples/"; // derived from WebFilter annotation pattern
	public static final String FORMS_PATH = "forms/";

	@Override
	public String[] getWebComponentBundleNames()
	{
		return new String[] { "/mycomp" };
	}

	@Override
	protected IWebsocketSessionFactory createSessionFactory()
	{
		return new IWebsocketSessionFactory()
		{
			public IWebsocketSession createSession(String uuid) throws Exception
			{
				return new HelloWorldWebsocketSession(uuid);
			}
		};
	}

}
