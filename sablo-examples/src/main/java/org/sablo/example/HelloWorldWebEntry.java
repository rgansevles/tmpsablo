package org.sablo.example;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig; 
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.sablo.WebEntry;
import org.sablo.example.endpoint.HelloWorldWebsocketSession;
import org.sablo.websocket.IWebsocketSession;
import org.sablo.websocket.IWebsocketSessionFactory;

@WebFilter(urlPatterns = { "/sablo-examples/helloworld/*" })
public class HelloWorldWebEntry extends WebEntry
{
	public HelloWorldWebEntry( ) {
		super("helloworld");
	}

	public static final String PATH = "examples/"; // derived from WebFilter annotation pattern
	public static final String FORMS_PATH = "forms/";

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
	{
//		try
//		{
////			if (Utils.getAsBoolean(Settings.getInstance().getProperty("servoy.internal.reloadSpecsAllTheTime", "false")))
////			{
////				WebComponentSpecProvider.reload();
////			}
//			
//
//			HttpServletRequest request = (HttpServletRequest)servletRequest;
//			String uri = request.getRequestURI();
//			if (uri != null && (uri.endsWith(".html") || uri.endsWith(".js")))
//			{
//				int solutionIndex = uri.indexOf(PATH);
//				int formIndex = uri.indexOf(FORMS_PATH);
//				if (solutionIndex > 0)
//				{
//					String solutionName = uri.substring(solutionIndex + SOLUTIONS_PATH.length(), uri.indexOf("/", solutionIndex + SOLUTIONS_PATH.length() + 1));
//					FlattenedSolution fs = null;
//					String clientUUID = request.getParameter("uuid");
//					INGClientWebsocketSession wsSession = null;
//					if (clientUUID != null)
//					{
//						wsSession = (INGClientWebsocketSession)WebsocketSessionManager.getSession(WebsocketSessionFactory.CLIENT_ENDPOINT, clientUUID);
//						if (wsSession != null) fs = wsSession.getClient().getFlattenedSolution();
//					}
//					if (fs == null)
//					{
//						try
//						{
//							IApplicationServer as = ApplicationServerRegistry.getService(IApplicationServer.class);
//							fs = new FlattenedSolution((SolutionMetaData)ApplicationServerRegistry.get().getLocalRepository().getRootObjectMetaData(
//								solutionName, IRepository.SOLUTIONS), new AbstractActiveSolutionHandler(as)
//							{
//								@Override
//								public IRepository getRepository()
//								{
//									return ApplicationServerRegistry.get().getLocalRepository();
//								}
//							});
//						}
//						catch (RepositoryException e)
//						{
//							Debug.error(e);
//						}
//					}
//
//					if (fs != null && formIndex > 0)
//					{
//						String formName = uri.substring(formIndex + FORMS_PATH.length());
//						formName = formName.replace(".html", "");
//						formName = formName.replace(".js", "");
//						Form f = fs.getForm(formName);
//						if (f == null && wsSession != null) f = wsSession.getClient().getFormManager().getPossibleForm(formName);
//						Form form = (f != null) ? fs.getFlattenedForm(f) : null;
//						if (form != null)
//						{
//							if (HTTPUtils.checkAndSetUnmodified(((HttpServletRequest)servletRequest), ((HttpServletResponse)servletResponse),
//								fs.getLastModifiedTime() / 1000 * 1000)) return;
//
//							boolean html = uri.endsWith(".html");
//							boolean tableview = (form.getView() == IFormConstants.VIEW_TYPE_TABLE || form.getView() == IFormConstants.VIEW_TYPE_TABLE_LOCKED);
//							if (!tableview && html && form.getLayoutGrid() != null)
//							{
//								((HttpServletResponse)servletResponse).setContentType("text/html");
//								PrintWriter w = servletResponse.getWriter();
//								FormWithInlineLayoutGenerator.generate(form, wsSession != null ? new ServoyDataConverterContext(wsSession.getClient())
//									: new ServoyDataConverterContext(fs), w);
//								w.flush();
//							}
//							else
//							{
//								String view = (tableview ? "tableview" : "recordview");
//								((HttpServletResponse)servletResponse).setContentType("text/" + (html ? "html" : "javascript"));
//								PrintWriter w = servletResponse.getWriter();
//								new FormTemplateGenerator(wsSession != null ? new ServoyDataConverterContext(wsSession.getClient()) : new ServoyDataConverterContext(fs),
//									false).generate(form, formName, "form_" + view + "_" + (html ? "html" : "js") + ".ftl", w);
//								w.flush();
//							}
//							return;
//						}
//					}
//				}
//			}
//
			super.doFilter(servletRequest, servletResponse,filterChain);
//		}
//		catch (RuntimeException | Error e)
//		{
//			throw e;
//		}
	}

	@Override
	public String[] getWebComponentBundleNames() 
	{
		return new String[] {"components/mycomp"};
	}

//	@Override
//	public String[] getWebServiceBundleNames() 
//	{
//		return null;
//	}

	@Override
	protected IWebsocketSessionFactory createSessionFactory() {
		
		return new IWebsocketSessionFactory(){

			public IWebsocketSession createSession(
					String uuid) throws Exception {
				return new HelloWorldWebsocketSession(uuid);
			}};
	}

	
//    @Override
//    public Class<WebApplication>[] getWebApplications() 
//    {
//        return new Class[]{HelloWorld.class};
//    }
}
