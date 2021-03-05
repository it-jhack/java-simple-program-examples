package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
/*

DAO = Data Access Object

General Idea of DAO standard:
- For each entity, there is an object responsible for accessing the data
related to this entity. For Example:
    - Customer - CustomerDao
    - Product - ProductDao
    - Order - OrderDao

- Each DAO will be defined by an Interface, because projects can migrate
to different technologies, and using Interfaces will keep them flexible.

- The Dependency Injection can be done in many ways. One of them (when
not using frameworks) is using the Factory project standard. Meaning,
the object Factory will be responsible for instantiating DAO implementations.

*/
        // DAO PROJECT
        // -> See dao_project_diagram.png in the root dir of this project.

        // QUESTION:
        // Couldn't we do a "Generic Dao" instead of creating two different
        // ClientDao/ProductDao interfaces?
        // Yes, but for (beginner) learning purposes we'll do one for each.

        // ClientDaoJDBC and ProductDaoJDBC: classes responsible for implementing
        // respective Interfaces. Instead of JDBC could be another technology.

        // DaoFactory: responsible for instantiating the DAOs


        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===== TEST 1: seller findById() =====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);


        System.out.println("\n===== TEST 2: seller findByDepartment() =====");
        // Beware to NOT instantiate a department for each seller
        // Instead the department should be instantiated only once,
        // and then sellers point to that department.

        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }


        System.out.println("\n===== TEST 3: seller findAll() =====");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }


        System.out.println("\n===== TEST 4: seller insert() =====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Seller inserted! New seller's id = " + newSeller.getId());

    }
}
