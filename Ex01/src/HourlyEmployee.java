/**
 * Created by kid0n on 19/03/2017.
 */
public class HourlyEmployee extends Employee {

    private int hours;
    private double wage;

    public HourlyEmployee(String firstName, String lastName, int id, int hours, double wage)
    {
        super(firstName,lastName,id);

        try {
            setHours(hours);
            setWage(wage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HourlyEmployee()
    {
        super();
        try {
            setWage(0);
            setHours(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHours(int hours) {
        try {
            this.hours = hours;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setWage(double wage) {
        try {
            this.wage = wage;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getHours() {
        return hours;
    }

    public double getWage() {
        return wage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof HourlyEmployee)) {
            return false;
        }

        HourlyEmployee hourlyEmployee = (HourlyEmployee) obj;

        return  this.equals(hourlyEmployee) &&
                Integer.compare(getHours(), hourlyEmployee.getHours())==0 &&
                Double.compare(getWage(), hourlyEmployee.getWage())==0;
    }

    @Override
    public String toString() {
        return this.toString() + Integer.toString(getHours()) + " " +
                Double.toString(getWage());
    }

    @Override
    public double earnings() {
        return hours * wage;
    }

    // TODO: Continue exercies from 3. 
}
