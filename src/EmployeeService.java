import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;
import com.mysql.cj.exceptions.ConnectionIsClosedException;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.io.*;

public class EmployeeService {
    ArrayList<Employee> employeeList = new ArrayList<>();
    EmployeeService() {
        manageEmployee();

    }
    public void manageEmployee() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome to employee management Service");
            System.out.println("Select options:");
            System.out.println("1. Create");
            System.out.println("2. Display");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createEmployee();
                    break;

                case 2:
                    printData();
                    break;

                case 3:
                    System.out.println("Index   Name");
                    //updateEmployee();
                    break;

                case 4:
                    deleteDate();
                    break;

                case 5:
                    System.exit(0);

                    break;

                default:
                    System.out.println("invalid choice:");
            }
        } while (true);
    }



    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee", "root", ""
            );

            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    public static void createEmployee(){
        try {

            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement("insert into emp_detail values(?,?,?,?)");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            do{
                System.out.println("Enter id:");
                int id=Integer.parseInt(br.readLine());
                System.out.println("Enter Name:");
                String name=br.readLine();
                System.out.println("Enter Address:");
                String address=br.readLine();
                System.out.println("Enter Salary:");
                int salary=Integer.parseInt(br.readLine());

                ps.setInt(1,id);
                ps.setString(2,name);
                ps.setString(3,address);
                ps.setFloat(4,salary);
                int i=ps.executeUpdate();
                System.out.println(i+" records affected");

                System.out.println("Do you want to continue: y/n");
                String s=br.readLine();
                if(s.startsWith("n")){
                    break;
                }
            }while(true);

            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public static void printData(){

        try{
            Connection con= getConnection();
            PreparedStatement ps= con.prepareStatement("select * from emp_detail");
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {


                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"        "+rs.getString(3)+"            "+rs.getInt(4));
            }




        }catch(Exception e){
            System.out.println(e);
        }



    }

    public static void deleteDate(){
        try{
            Connection con= getConnection();
            PreparedStatement ps= con.prepareStatement("delete from emp_detail where id=?");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter id:");
            int id=Integer.parseInt(br.readLine());

            ps.setInt(1,id);
            ps.executeUpdate();



        }catch (Exception e){
            System.out.println(e);
        }





    }





    /*
    private void createEmployee() {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Enter ID :");
        employee.setID(scanner.nextInt());
        System.out.println("Enter name :");
        employee.setName(scanner.next());

        System.out.println("Enter address:");
        employee.setAddress(scanner.next());

        System.out.println("Enter salary:");
        employee.setSalary(scanner.nextInt());

        employeeList.add(employee);


    }


    public void printData() {
        System.out.println("-------------------------------------------------");
        System.out.println("|  ID   |  Name           |  Address           |   Salary  |");
        System.out.println("-------------------------------------------------");

        if (employeeList.isEmpty()) {
            System.out.println("Add employee info first");
        } else {
            employeeList.forEach(employee -> {
                System.out.println(employee);
            });
        }
    }

    public void deleteDate() {
        Scanner scanner = new Scanner(System.in);
        if (employeeList.isEmpty()) {
            System.out.println("No data to delete");
        } else {
            int index;
            System.out.println("Index   Name");
            for (int i = 0; i < employeeList.size(); i++) {
                System.out.println("  " + i + "     " + employeeList.get(i).getName());
            }

            System.out.println("Enter index to delete data");
            index = scanner.nextInt();
            Employee toDelete = employeeList.get(index);
            employeeList.remove(toDelete);
        }
        }

        public void updateEmployee(){
        Scanner scanner= new Scanner(System.in);
        int ch;
            int index;
            for (int i = 0; i < employeeList.size(); i++) {
                System.out.println("  " + i + "     " + employeeList.get(i).getName());
            }

            System.out.println("Enter index to select employee for data update:");
            index = scanner.nextInt();

            System.out.println("***EDIT MENU***");
            System.out.println("1. Edit Name");
            System.out.println("2. Edit address");
            System.out.println("3. Edit Salary");

            ch=scanner.nextInt();
        switch(ch){
            case 1:
                System.out.println("Enter new name");
                employeeList.get(index).setName(scanner.next());
                break;
            case 2:
                System.out.println("Enter new address");
                employeeList.get(index).setAddress(scanner.next());
                break;
            case 3:

                System.out.println("Enter new salary");
                employeeList.get(index).setSalary(scanner.nextInt());
                break;

            default:
                System.out.println("Invalid choice!!!");
        }





        }
*/

    }

