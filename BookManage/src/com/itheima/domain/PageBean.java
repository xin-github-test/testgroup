package com.itheima.domain;

import java.util.List;

public class PageBean {

    private int currentPage;
    private int pageSize;
    private int count;
    private int totalPage;
    private List<Book> books;

    public PageBean(int currentPage, int pageSize, int count, int totalPage, List<Book> books) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.count = count;
        this.totalPage = totalPage;
        this.books = books;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
