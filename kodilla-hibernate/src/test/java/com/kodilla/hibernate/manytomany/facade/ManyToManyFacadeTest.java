package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManyToManyFacadeTest {

    @Autowired
    private ManyToManyFacade manyToManyFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void searchCompaniesByAnyPartOfTheName() {

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        Company softwareGame = new Company("Software Game");
        Company softwareTeam = new Company("Software Team");
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        companyDao.save(softwareGame);
        int softwareGameId = softwareGame.getId();
        companyDao.save(softwareTeam);
        int softwareTeamId = softwareTeam.getId();

        try {
            manyToManyFacade.searchCompaniesByAnyPartOfTheName("war");
        } catch (SearchingException e) {
            // business exception - should be handled in real application
        }

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
            companyDao.deleteById(softwareGameId);
            companyDao.deleteById(softwareTeamId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void searchEmployeesByAnyPartOfTheName() {

        Employee johnSmith = new Employee("John", "Smith");
        Employee michaelSmith = new Employee("Michael", "Smith");
        Employee annSmith = new Employee("Ann", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        employeeDao.save(michaelSmith);
        int michaelSmithId = michaelSmith.getId();
        employeeDao.save(annSmith);
        int annSmithId = annSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieClarcksonId = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int lindaKovalskyId = lindaKovalsky.getId();

        try {
            manyToManyFacade.searchEmployeesByAnyPartOfTheName("mi");
        } catch (SearchingException e) {
            // business exception - should be handled in real application
        }

        //CleanUp
        try {
            employeeDao.deleteById(johnSmithId);
            employeeDao.deleteById(michaelSmithId);
            employeeDao.deleteById(annSmithId);
            employeeDao.deleteById(stephanieClarcksonId);
            employeeDao.deleteById(lindaKovalskyId);
        } catch (Exception e) {
            //do nothing
        }
    }
}
