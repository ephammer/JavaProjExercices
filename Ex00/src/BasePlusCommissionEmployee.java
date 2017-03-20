/**
 * Created by Admin on 19/03/2017.
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee()
    {
        super("plony","almony",0,0,0);
        setBaseSalary(0);
    }

    public BasePlusCommissionEmployee(String firstName, String lastName, int id, int grossSales, double commision, float baseSalary)
    {
        super(firstName,lastName,id,grossSales,commision);

        try
        {
            setBaseSalary(baseSalary);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void setBaseSalary(double baseSalary)
    {
        try
        {
            this.baseSalary = baseSalary;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public double getBaseSalary()
    {
        return this.baseSalary;
    }

    public String toString()
    {
        return super.toString() + "," + "Base salary: " + String.valueOf(this.baseSalary);
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;

        if (!(obj instanceof BasePlusCommissionEmployee))
            return false;

        BasePlusCommissionEmployee basePlusCommissionEmployee = (BasePlusCommissionEmployee)obj;
        return (super.equals(obj) && (this.baseSalary == basePlusCommissionEmployee.baseSalary));
    }

    public double earnings()
    {
        return this.baseSalary + super.earnings();
    }
}
