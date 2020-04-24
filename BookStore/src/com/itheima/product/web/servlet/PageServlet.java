package com.itheima.product.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.product.domain.PageBean;
import com.itheima.product.service.ProductService;

public class PageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//������ť�Ĳ�ѯ����
		String category = request.getParameter("category");
		if(category==null){
			category="";
		}
		//��ʼ��ÿҳ��ʾ�ļ�¼��
		int pageSize = 4;
		
		int currentPage = 1;//��ǰҳ
		String currPage = request.getParameter("currentPage");//����һҳ����һҳ�õ�������
		if(currPage!=null&&!"".equals(currPage)){//��һ�η�����Դʱ��currPage������null
			currentPage = Integer.parseInt(currPage);
		}
		
		ProductService bs = new ProductService();
		//��ҳ��ѯ��������PageBean����
		PageBean pb = bs.findBooksPage(currentPage,pageSize,category);
		
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
