package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManyToManyFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManyToManyFacade.class);
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    public ManyToManyFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public void searchCompaniesByAnyPartOfTheName(final String partOfTheName) throws SearchingException {
        LOGGER.info("Searching for companies by part of the name: " + partOfTheName);
        List<Company> companyList = companyDao.searchCompaniesByAnyPartOfTheName("%" + partOfTheName + "%");
        if(companyList.size() > 0) {
            LOGGER.info("Number of companies matching the parameter: " + companyList.size());
            LOGGER.info("List of companies:");
            for (Company company : companyList) {
                System.out.println(company);
            }
        } else {
            LOGGER.error(SearchingException.ERR_NOT_FOUND);
            throw new SearchingException(SearchingException.ERR_NOT_FOUND);
        }
        LOGGER.info("Search completed");
        }

    public void searchEmployeesByAnyPartOfTheName(final String partOfTheName) throws SearchingException {
        LOGGER.info("Searching for employees by part of the name: " + partOfTheName);
        List<Employee> employeeList = employeeDao.searchEmployeesByAnyPartOfTheName("%" + partOfTheName + "%");
        if(employeeList.size() > 0) {
            LOGGER.info("Number of employees matching the parameter: " + employeeList.size());
            LOGGER.info("List of employees:");
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        } else {
            LOGGER.error(SearchingException.ERR_NOT_FOUND);
            throw new SearchingException(SearchingException.ERR_NOT_FOUND);
        }
        LOGGER.info("Search completed");
    }
}
