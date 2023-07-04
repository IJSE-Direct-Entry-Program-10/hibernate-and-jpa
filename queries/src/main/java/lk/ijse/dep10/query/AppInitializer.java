package lk.ijse.dep10.query;

import lk.ijse.dep10.query.util.HibernateUtil;
import lk.ijse.dep10.query.entity.Car;
import lk.ijse.dep10.query.entity.Employee;
import lk.ijse.dep10.query.entity.EmployeeCar;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class AppInitializer {

    public static void main(String[] args) {
        try (var sf = HibernateUtil.getSessionFactory();
             var session = sf.openSession()) {
            session.beginTransaction();

            Employee kasun = new Employee("E001", "Kasun");
            Employee john = new Employee("E002", "John");
            Employee martin = new Employee("E003", "Matrin");

            Car bugati = new Car("CAR001", "Bugati");
            Car ferari = new Car("CAR002", "Ferari");
            Car prius = new Car("CAR003", "Prius");

            EmployeeCar ec1 = new EmployeeCar(ferari, kasun, Date.valueOf(LocalDate.now()));
            EmployeeCar ec2 = new EmployeeCar(prius, martin, Date.valueOf(LocalDate.now()));

            List.of(kasun, john, martin, bugati, ferari, prius, ec1, ec2)
                            .forEach(session::persist);

            session.getTransaction().commit();
        }
    }
}
