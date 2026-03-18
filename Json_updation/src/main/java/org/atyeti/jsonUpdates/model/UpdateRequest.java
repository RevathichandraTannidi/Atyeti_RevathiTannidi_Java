package org.atyeti.jsonUpdates.model;


public class UpdateRequest {

    private int id;
    private String name;
    private Integer age;
    private String city;
    private String department;
    private  Address address;



    public UpdateRequest() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getDepartment() {
        return department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}