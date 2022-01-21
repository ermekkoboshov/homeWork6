package com.peaksoft.dao;

import com.peaksoft.Classes.Cities;
import com.peaksoft.Classes.Countries;
import com.peaksoft.Classes.ThePresident;
import org.postgresql.util.PSQLException;

import javax.xml.transform.Result;
import java.awt.*;
import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Jdbc {

    static Scanner scanner = new Scanner(System.in);
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user = "postgres";
    private final static String postgres = "200130";

    java.util.List<Cities> cities = new ArrayList<>();
    java.util.List<Countries> countries = new ArrayList<>();
    List<ThePresident> thePresidents = new ArrayList<>();

    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, postgres);
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    //GetCitiesCount
    public static int getCitiesCount() {
        String SQL = "select count(*) from cites";
        int count = 0;
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
    //AddCountries
    public static void addCities() {
        String SQL = "insert into cities (name, district, street, length) values (?, ?, ?, ?)";
        try (Connection conn = connection(); PreparedStatement statement = conn.prepareStatement(SQL)) {
            System.out.println("Введите количество городов которые хотите ввести: ");
            int number = scanner.nextInt();
            for (int i = 1; i <= number; i++) {
                scanner.nextLine();
                System.out.println(i + " Введите название города: ");
                String name = scanner.nextLine();
                statement.setString(1, name);
                System.out.println(i + " Введите название районы: ");
                String district = scanner.nextLine();
                statement.setString(2, district);
                System.out.println(i + " Введите название улицы: ");
                String street = scanner.nextLine();
                statement.setString(3, street);
                System.out.println(i + " Введите длину улицы: ");
                String length = scanner.nextLine();
                statement.setString(4, length);
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //GetAllCities
    public void getAllCities() {

        String sql = "Select * from cities;";
        try {
            Connection conn = DriverManager.getConnection(url, user, postgres);
            Statement st = conn.createStatement();
            st.executeQuery(sql);
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                Cities city = new Cities();
                city.setId(rs.getInt("id"));
                System.out.println("ID:         " + rs.getInt("id"));
                city.setName(rs.getString("name"));
                System.out.println("Name:       " + rs.getString("name"));
                city.setDistrict(rs.getString("district"));
                System.out.println("District:   " + rs.getString("district"));
                city.setStreet(rs.getString("street"));
                System.out.println("Street:     " + rs.getString("street"));
                city.setLength(rs.getString("length"));
                System.out.println("Length:     " + rs.getString("length"));
                this.cities.add(city);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //GetCityById
    public static void getCityById() {
        String sql = "Select * from cities;";
        try {
            Connection conn = DriverManager.getConnection(url, user, postgres);
            Statement st = conn.createStatement();
            st.executeQuery(sql);
            ResultSet rs = st.getResultSet();
            System.out.println("Введите id города: ");
            int id = scanner.nextInt();
            while (rs.next()) {
                if(rs.getInt("id")==id){
                    System.out.println("ID:         " + rs.getInt("id"));
                    System.out.println("Name:       " + rs.getString("name"));
                    System.out.println("District:   " + rs.getString("district"));
                    System.out.println("Street:     " + rs.getString("street"));
                    System.out.println("Length:     " + rs.getString("length"));
                }
            }
    } catch(
    SQLException throwables)

    {
        throwables.printStackTrace();
    }
}

    //GetCountriesCount
    public static int getCountriesCount(){
        String SQL = "select count(*) from countries";
        int count = 0;
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
    //AddCountries
    public static void addCountries(){
        String SQL = "insert into countries (name, length, number_of_people) values (?, ?, ?)";
        try (Connection conn = connection(); PreparedStatement statement = conn.prepareStatement(SQL)) {
            System.out.println("Введите количество старн которые хотите ввести: ");
            int number = scanner.nextInt();
            for (int i = 1; i <= number; i++) {
                scanner.nextLine();
                System.out.println(i + " Введите название страны: ");
                String name = scanner.nextLine();
                statement.setString(1, name);
                System.out.println(i + " Введите площадь страны: ");
                String size = scanner.nextLine();
                statement.setString(2, size);
                System.out.println(i + " Введите количество популяции: ");
                String  population = scanner.nextLine();
                statement.setString(3, population);

                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //GetAllCountries
    public void getAllCountries(){
        String sql = "Select * from countries;";
        try {
            Connection conn = DriverManager.getConnection(url, user, postgres);
            Statement st = conn.createStatement();
            st.executeQuery(sql);
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                Countries country = new Countries();
                country.setId(rs.getInt("id"));
                System.out.println("ID:             " + rs.getInt("id"));
                country.setName(rs.getString("name"));
                System.out.println("Name:           " + rs.getString("name"));
                country.setLength(rs.getString("length"));
                System.out.println("Length:         " + rs.getString("length"));
                country.setNumber_of_people(rs.getString("number_of_people"));
                System.out.println("Population:     " + rs.getString("number_of_people"));
                this.countries.add(country);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //GetCountryByID
    public static void getCountryById() {
        String sql = "Select * from countries;";
        try {
            Connection conn = DriverManager.getConnection(url, user, postgres);
            Statement st = conn.createStatement();
            st.executeQuery(sql);
            ResultSet rs = st.getResultSet();
            System.out.println("Введите id страны: ");
            int id = scanner.nextInt();
            while (rs.next()) {
                if(rs.getInt("id")==id){
                    System.out.println("ID:         " + rs.getInt("id"));
                    System.out.println("Name:       " + rs.getString("name"));
                    System.out.println("Length:   " + rs.getString("length"));
                    System.out.println("Population:     " + rs.getString("population"));
                }
            }
        } catch(
                SQLException throwables)

        {
            throwables.printStackTrace();
        }
    }

    //GetThePresidentCount
    public static int getPresidentCount(){
        String SQL = "select count(*) from the_president";
        int count = 0;
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
    //AddPresidents
    public static void addPresidents(){
        String SQL = "insert into the_presidents (first_name, last_name, year_of_birth, woman_name ) values (?, ?, ?, ?)";
        try (Connection conn = connection(); PreparedStatement statement = conn.prepareStatement(SQL)) {
            System.out.println("Введите количество Президентов которые хотите ввести: ");
            int number = scanner.nextInt();
            for (int i = 1; i <= number; i++) {
                scanner.nextLine();
                System.out.println(i + " Введите имя президентов: ");
                String name = scanner.nextLine();
                statement.setString(1, name);
                System.out.println(i + " Введите фамилию президента: ");
                String surname = scanner.nextLine();
                statement.setString(2, surname);
                System.out.println(i + " Введите дату рождения президента: ");
                String  year_of_birth = scanner.nextLine();
                statement.setString(3, year_of_birth);
                System.out.println(i+ "  Введите имя жены президента");
                String woman_name = scanner.nextLine();
                statement.setString(4, woman_name);
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //GetAllPresidents
    public void getAllPresident(){
        String sql = "Select * from the_president;";
        try {
            Connection conn = DriverManager.getConnection(url, user, postgres);
            Statement st = conn.createStatement();
            st.executeQuery(sql);
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                ThePresident president = new ThePresident();
                president.setId(rs.getInt("id"));
                System.out.println("ID:                " + rs.getInt("id"));
                president.setFirst_name(rs.getString("first_name"));
                System.out.println("First_name:        " + rs.getString("first_name"));
                president.setLast_name(rs.getString("last_name"));
                System.out.println("Last_name:         " + rs.getString("last_name"));
                president.setYear_of_birth(rs.getString("year_of_birth"));
                System.out.println("YearOfBirth:       " + rs.getString("year_of_birth"));
                president.setWoman_name(rs.getString("woman_name"));
                System.out.println("Woman_name:        "+rs.getString("woman_name"));
                this.thePresidents.add(president);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //GetPresidentByID
    public static void getPresidentById(){
        String sql = "Select * from the_president;";
        try {
            Connection conn = DriverManager.getConnection(url, user, postgres);
            Statement st = conn.createStatement();
            st.executeQuery(sql);
            ResultSet rs = st.getResultSet();
            System.out.println("Введите id  президента: ");
            int id = scanner.nextInt();
            while (rs.next()) {
                if(rs.getInt("id")==id){
                    System.out.println("ID:                " + rs.getInt("id"));
                    System.out.println("first_name:        " + rs.getString("first_name"));
                    System.out.println("last_name:         " + rs.getString("last_name"));
                    System.out.println("year_of_birth:     " + rs.getString("year_of_birth"));
                    System.out.println("woman_name:     " + rs.getString("woman_name"));
                }
            }
        } catch(
                SQLException throwables)

        {
            throwables.printStackTrace();
        }
    }

    public List<Cities> getCities() {
        return cities;
    }

    public List<Countries> getCountries() {
        return countries;
    }

    public List<ThePresident> getThePresidents() {
        return thePresidents;
    }

}