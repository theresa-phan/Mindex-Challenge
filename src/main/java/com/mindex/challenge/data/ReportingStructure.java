package com.mindex.challenge.data;

public class ReportingStructure {

    private String employee;

    //equal the total number of reports under a given employee
    private Integer numberOfReports;


    public ReportingStructure(){
    }

    public ReportingStructure(String employee, Integer numberOfReports) {
        this.employee = employee;
        this.numberOfReports = numberOfReports;
    }


    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Integer getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(Integer numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    @Override
    public String toString() {
        return "ReportingStructure{" +
                "employee='" + employee + '\'' +
                ", numberOfReports=" + numberOfReports +
                '}';
    }
}
