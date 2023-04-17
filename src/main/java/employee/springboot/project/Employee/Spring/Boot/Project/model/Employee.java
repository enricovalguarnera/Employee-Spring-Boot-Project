package employee.springboot.project.Employee.Spring.Boot.Project.model;

public class Employee {

    private int id;
    private int employee_id;
    private String name;
    private String surname;
    private int dept_id;

    public Employee(int id, int employee_id, String name, String surname, int dept_id) {
        this.id = id;
        this.employee_id = employee_id;
        this.name = name;
        this.surname = surname;
        this.dept_id = dept_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employee_id=" + employee_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dept_id=" + dept_id +
                '}';
    }
}
