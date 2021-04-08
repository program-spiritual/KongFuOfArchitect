package com.learnjava.www.structPatterns.facade;

public class Facade {

  private AdminOfIndustry admin;
  private Bank bank;
  private Taxation taxation;

  public Company openCompany(String name) {
    Company c = this.admin.register(name);
    String bankAccount = this.bank.openAccount(c.getId());
    c.setBankAccount(bankAccount);
    String taxCode = this.taxation.applyTaxCode(c.getId());
    c.setTaxCode(taxCode);
    return c;
  }
}
