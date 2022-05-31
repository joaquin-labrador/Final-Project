package Employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;


public abstract class Employee {
    private String name;
    private String lastName;
    private String dateOfBrith;
    private Integer id;
    private boolean isWorking = false;
    private String password;
    private String userName;

    //region CONSTRUCTORS GETTERS AND SETTERS
    public Employee() {
    }

    public Employee(String name, String lastName, String dateOfBrith, Integer id,
                    String userName, String password) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBrith = dateOfBrith;
        this.id = id;
        this.password = password;
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBrith() {
        return dateOfBrith;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBrith(String dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    //endregion

    private void startDay() {
        this.isWorking = true;
    }

    protected abstract void finishDay(); //Here finish day and upload the salary of that working day, depends of position

    private int getAge() {
        LocalDate dateOfBirth = LocalDate.parse(this.dateOfBrith);
        return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBrith=" + dateOfBrith +
                ", id=" + id +
                ", isWorking=" + isWorking +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}


