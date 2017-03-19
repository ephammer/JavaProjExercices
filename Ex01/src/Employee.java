/**
 * Created by kid0n on 19/03/2017.
 */
public  class  Employee {

    private String firstName;
    private String lastName;
    private int id;

    public Employee(String firstName, String lastName, int id)
    {
        try {
            setFirstName(firstName);
            setLastName(lastName);
            setId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee()
    {
        try {
            setFirstName("plony");
            setLastName("almony");
            setId(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        try {
            this.firstName = firstName;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLastName(String lastName) {
        try {
            this.lastName = lastName;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setId(int id) {
        try {
            this.id = id;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return firstName + " " +
                lastName + " " +
                Integer.toString(id);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this)
            return true;

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee employee = (Employee) obj;

        return firstName.equals(employee.getFirstName()) &&
                lastName.equals(employee.getLastName()) &&
                Integer.compare(id,employee.getId())==0;
    }

    public double earnings()
    {
        return 0;
    }
}
