package com.itheima.product.service;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

import com.itheima.product.dao.ProductDao;

import com.itheima.product.domain.Order;
import com.itheima.product.domain.PageBean;
import com.itheima.product.domain.Product;

public class ProductService {
	//����һ��Dao����
	ProductDao productDao = new ProductDao();
	
	public List<Product> findAllBooks(){
		try {
			return productDao.findAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//���ͼ��
	public void addBook(Product product){
		try {
			productDao.addBook(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Product findBookById(String id) {
		try {
			return productDao.findBookById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateBook(Product product) {
		try {
			productDao.updateBook(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(String id) {
		try {
			productDao.delBook(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleAllBooks(String[] ids) {
		try {
			productDao.deleAllBooks(ids);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> searchBooks(String id, String category, String name,
			String minprice, String maxprice) {
		try {
			return productDao.searchBooks(id,category,name,minprice,maxprice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//��ҳ��ѯ
	public PageBean findBooksPage(int currentPage, int pageSize,String category) {
		
		try {
			int count  = productDao.count(category);//�õ��ܼ�¼��
			int totalPage = (int)Math.ceil(count*1.0/pageSize); //�����ҳ��
			List<Product> products= productDao.findBooks(currentPage,pageSize,category);
			
			//��5��������װ��PageBean�У���Ϊ����ֵ
			PageBean pb = new PageBean();
			pb.setProducts(products);
			pb.setCount(count);
			pb.setCurrentPage(currentPage);
			pb.setPageSize(pageSize);
			pb.setTotalPage(totalPage);
			//��pageBean��������ԣ����ڵ����һҳ����һҳʱʹ��
			pb.setCategory(category);
			
			return pb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Object> searchBookByName(String name) {
		try {
			return productDao.searchBookByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
public void addOrder(Order order)
{


}

	

	
	
	
}
