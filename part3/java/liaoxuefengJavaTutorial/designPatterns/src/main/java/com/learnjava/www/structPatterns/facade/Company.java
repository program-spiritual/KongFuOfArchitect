package com.learnjava.www.structPatterns.facade;

public class Company {

  public String name;
  public String address;
  public String id;
  private String bankAccount;
  private String taxCode;

  public Company(String name, String address, String id) {
    this.name = name;
    this.address = address;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setBankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }
}
