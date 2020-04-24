package com.itheima.product.web.filter;

import javax.servlet.*;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 * ????? get ?? post?????????
 * 
 * 
 * 
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ????????????
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletRequest myRequest = new MyRequest(httpServletRequest);

		// ???????????
		response.setContentType("text/html;charset=utf-8");

		chain.doFilter(myRequest, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}

// ?????request????
class MyRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	private boolean hasEncode;

	public MyRequest(HttpServletRequest request) {
		super(request);// super????д
		this.request = request;
	}

	// ???????????? ???и???
	@Override
	public Map getParameterMap() {
		// ?????????
		String method = request.getMethod();
		if (method.equalsIgnoreCase("post")) {
			// post????
			try {
				// ????post????
				request.setCharacterEncoding("utf-8");
				return request.getParameterMap();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else if (method.equalsIgnoreCase("get")) {
			// get????
			Map<String, String[]> parameterMap = request.getParameterMap();
			if (!hasEncode) { // ???get??????????????????
				for (String parameterName : parameterMap.keySet()) {
					String[] values = parameterMap.get(parameterName);
					if (values != null) {
						for (int i = 0; i < values.length; i++) {
							try {
								// ????get????
								values[i] = new String(values[i]
										.getBytes("ISO-8859-1"), "utf-8");
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						}
					}
				}
				hasEncode = true;
			}
			return parameterMap;
		}

		return super.getParameterMap();
	}

	@Override
	public String getParameter(String name) {
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		if (values == null) {
			return null;
		}
		return values[0]; // ?????????????
	}

	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		return values;
	}

}
