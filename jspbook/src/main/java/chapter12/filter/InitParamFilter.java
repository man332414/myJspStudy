package chapter12.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class InitParamFilter implements Filter 
{
	private FilterConfig filterConfig = null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
		System.out.println("Filter02 초기화");
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException 
	{
		System.out.println("filter02 수행...");
		String id_f = request.getParameter("id");
		String passwd_f = request.getParameter("passwd");
		
		String param1_f = filterConfig.getInitParameter("param1");
		String param2_f = filterConfig.getInitParameter("param2");
		
		String message;
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/HTML; charset = utf-8");
		PrintWriter writer = response.getWriter();
		
		if(id_f.equals(param1_f) && passwd_f.equals(param2_f))
		{
			message = "로그인 성공";
		}
		else
		{
			message = "로그인 실패";
		}
		
		writer.println(message);
		
		filterchain.doFilter(request, response);
	}

	@Override
	public void destroy() 
	{
		
	}
}
