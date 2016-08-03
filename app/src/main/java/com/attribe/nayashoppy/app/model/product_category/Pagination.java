package com.attribe.nayashoppy.app.model.product_category;

/**
 * Created by Sabih Ahmed on 02-Aug-16.
 */

public class Pagination {

    public Integer totalPages;
    public Integer currentPage;
    public Integer nextPage;
    public Integer prevPage;
    public String totalRecords;
    public Integer recordsPerPage;


    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public void setPrevPage(Integer prevPage) {
        this.prevPage = prevPage;
    }

    public void setTotalRecords(String totalRecords) {
        this.totalRecords = totalRecords;
    }

    public void setRecordsPerPage(Integer recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }
}
