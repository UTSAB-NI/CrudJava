public class Employee {
    private int ID;
    private String name;
    private String Address;


    private int salary;

    public String getName() {

        return name;
    }

    @Override
    public String toString() {
        return

         "  "+ID +"       "+name+"         "+Address+"            "+salary


                ;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}


