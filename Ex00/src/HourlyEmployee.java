/**
 * Created by kid0n on 19/03/2017.
 */
public class HourlyEmployee extends Employee {

    private double hours;
    private double wage;

    public HourlyEmployee(String firstName, String lastName, int id, double hours, double wage)
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

    public void setHours(double hours) {
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

    public double getHours() {
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

        return  super.equals(hourlyEmployee) &&
                Double.compare(getHours(), hourlyEmployee.getHours())==0 &&
                Double.compare(getWage(), hourlyEmployee.getWage())==0;
    }

    @Override
    public String toString() {
        return super.toString() + Double.toString(getHours()) + " " +
                Double.toString(getWage());
    }

    @Override
    public double earnings() {
        return hours * wage;
    }

}
