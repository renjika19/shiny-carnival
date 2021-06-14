package com.revature.filters;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class CustomFilter extends ZuulFilter{
	
	/*
	 * 4 kinds of filters:
	 * -"pre": pre filters are executed before
	 * the request is routed
	 * -"route" filters can handle the acutal
	 * routing of the request
	 * -"post" filters are executed after the
	 * request has been routed
	 * -"error" filters will execute in the
	 * event of an error occurring
	 */
	
	@Override
	public boolean shouldFilter() {
//		this details whether or not we want this
//		filter to occur
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = 
				RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Method: " + request.getMethod());
		System.out.println("Request URL: " + 
				request.getRequestURL().toString());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
//		the type of filter we will use
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
