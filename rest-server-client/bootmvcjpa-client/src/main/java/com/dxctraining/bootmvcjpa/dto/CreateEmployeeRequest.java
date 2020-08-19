package com.dxctraining.bootmvcjpa.dto;

public class CreateEmployeeRequest {

    private String name;

    private double salary;

    private int age;

    private String password;

    public CreateEmployeeRequest(){

    }

    public CreateEmployeeRequest(String name, String password, int age, double salary){
        this.name=name;
        this.salary=salary;
        this.age=age;
        this.password=password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
