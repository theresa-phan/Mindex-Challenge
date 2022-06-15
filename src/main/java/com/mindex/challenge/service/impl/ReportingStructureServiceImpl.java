package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    private int reportTotal(Employee employee) {

        int total = 0;

        if (employee.getDirectReports() == null) {
            return 0;
        }

        for (Employee directEmployee : employee.getDirectReports()) {

            if(directEmployee.getEmployeeId() == null){
                continue;
            }
            total++;
        }

        for (Employee subEmployee : employee.getDirectReports()) {
            subEmployee = employeeRepository.findByEmployeeId(subEmployee.getEmployeeId());
            total += reportTotal(subEmployee);
        }

        return total;
    }

    public ReportingStructure read(String id) {

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            LOG.debug("Invalid employeeId: " + id);
            return new ReportingStructure();
        }

        ReportingStructure report = new ReportingStructure(employee);
        report.setNumberOfReports(reportTotal(employee));

        return report;
    }
}