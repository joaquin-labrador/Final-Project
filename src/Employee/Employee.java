package Employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Employee {
    private String name;
    private String lastName;
    private LocalDate dateOfBrith;
    private Integer id;
    private boolean isWorking = false;
    private String password;
    private String userName;

    //region CONSTRUCTORS GETTERS AND SETTERS
    public Employee() {
    }

    public Employee(String name, String lastName, LocalDate dateOfBrith, Integer id,
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

    public LocalDate getDateOfBrith() {
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

    public void setDateOfBrith(LocalDate dateOfBrith) {
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
        return (int) ChronoUnit.YEARS.between(dateOfBrith, LocalDate.now());
    }

}

