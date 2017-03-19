import java.util.DoubleSummaryStatistics;

/**
 * Created by kid0n on 19/03/2017.
 */
public class CommissionEmployee extends Employee {

    // TODO: Continue exercies from 4.

    private int grossSales;
    private double commision;

    public CommissionEmployee(String firstName, String lastName, int id, int grossSales, double commision)
    {
        super(firstName,lastName,id);

        try {
            setCommision(commision);
            setGrossSales(grossSales);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CommissionEmployee()
    {
        super();
        setGrossSales(0);
        setCommision(0);
    }
    public void setCommision(double commision) {
        try {
            this.commision = commision;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGrossSales(int grossSales) {
        try {
            this.grossSales = grossSales;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getGrossSales() {
        return grossSales;
    }

    public double getCommision() {
        return commision;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                Integer.toString(grossSales) + " " +
                Double.toString(commision);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof CommissionEmployee)) {
            return false;
        }

        CommissionEmployee commissionEmployee = (CommissionEmployee) obj;

        return super.equals(obj) &&
                Integer.compare( getGrossSales(), commissionEmployee.getGrossSales())==0 &&
                Double.compare(getCommision(), commissionEmployee.getCommision())==0;
    }

    @Override
    public double earnings() {
        return commision/100 * grossSales;
    }

}
