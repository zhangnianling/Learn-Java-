package com.znl.p2.service;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.znl.p2.bean.Customer;

public class CustomerList {
    private Customer[] customers;//保存客户对象的数组
    private int total = 0;//记录已保存的客户对象总数

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];

    }

    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        } else {
            customers[total] = customer;
            total++;
            return true;
        }

    }

    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index >= total) {
            return false;
        } else {
            customers[index] = cust;
            return true;
        }
    }

    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        } else {
            for (int i = index; i < total - 1; i++) {
                customers[i] = customers[i + 1];
            }
            customers[total - 1] = null;
            total--;
            return true;
        }


    }

    public Customer[] getAllCustomers() {
        Customer[] customers = new Customer[total];
        for (int i = 0; i < total; i++) {
            customers[i] = this.customers[i];
        }
        return customers;

    }

    public Customer getCustomers(int index) {
        if (index < 0 || index >= total) {
            return null;
        } else {
            return customers[index];
        }
    }

    public int getTotal() {
        return total;
    }
}
