package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;

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



    }
}
