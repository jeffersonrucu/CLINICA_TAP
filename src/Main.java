import sistema.controller.*;
import sistema.model.bean.*;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
//        createPatient();
//        createEmployee();
//        createJobRole();
    }

    public static void createPatient() throws SQLException, ParseException {
        // Logradouro
        String streetNome = "Rua Nova Bassam";
        String zipCode = "08240-220";
        int number = 94;
        String neighborhood = "Jardim Norma";
        String city = "São Paulo";
        String state = "São Paulo";
        String country = "São Paulo";

        Logradouro logradouro = new Logradouro(streetNome, zipCode, number, neighborhood, city, state, country);
        logradouro = new ControllerLogradouro().create(logradouro);

        // TypePerson
        String cpf = "527.208.558-20";
        String cnpj = "0000.00000.00.000/00";

        TypePerson typePerson = new TypePerson(cpf, cnpj);
        typePerson = new ControllerTypePerson().create(typePerson);

        // Person
        String name = "Jefferson Oliveira";
        String gender = "M";

        Person person = new Person(name, gender, logradouro, typePerson);
        person = new ControllerPerson().create(person);

        // User
        String username = "jeffersonrucu";
        String email = "jefferoidtex7@gmail.com";
        String emailRecovery = "jeffersontex7@gmail.com";
        String password = "LWpass2010";

        User user = new User(username, email, emailRecovery, password, person);
        user = new ControllerUser().create(user);

        // Patient
        String healthInsurance = "Amil";
        Patient patient = new Patient(healthInsurance, user);
        patient = new ControllerPatient().create(patient);
    }

    public static void createEmployee() throws SQLException, ParseException {
        // Logradouro
        String streetNome = "Rua Lapa Jama";
        String zipCode = "33213-123";
        int number = 10;
        String neighborhood = "Jardim Juru";
        String city = "São Paulo";
        String state = "São Paulo";
        String country = "São Paulo";

        Logradouro logradouro = new Logradouro(streetNome, zipCode, number, neighborhood, city, state, country);
        logradouro = new ControllerLogradouro().create(logradouro);

        // TypePerson
        String cpf = "123.333.212-20";
        String cnpj = "123.00000.00.000/00";

        TypePerson typePerson = new TypePerson(cpf, cnpj);
        typePerson = new ControllerTypePerson().create(typePerson);

        // Person
        String name = "Leo Oliveira";
        String gender = "M";

        Person person = new Person(name, gender, logradouro, typePerson);
        person = new ControllerPerson().create(person);

        // User
        String username = "leooliveira";
        String email = "leo@gmail.com";
        String emailRecovery = "leo123@gmail.com";
        String password = "LWpass2010";

        User user = new User(username, email, emailRecovery, password, person);
        user = new ControllerUser().create(user);

        // Employee
        String hiringDate = "01/03/2003";
        Double wage = 1110.00;
        JobRole jobRole = new ControllerJobRole().read(1);
        Employee employee = new Employee(hiringDate, wage, user, jobRole);

        employee = new ControllerEmployee().create(employee);
    }

    public static void createJobRole() throws SQLException, ParseException {
      String nameJob = "gerente";
      int permission = 5;

      JobRole jobRole = new JobRole(nameJob, permission);
      jobRole = new ControllerJobRole().create(jobRole);
    }
}
