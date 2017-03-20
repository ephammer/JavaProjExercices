/**
 * Created by Admin on 20/03/2017.
 */
public class Payroll {

    public static void main(String[] args){
        Employee[] employeeArray = new Employee[3];

        HourlyEmployee hourlyEmployee =
                new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40 );

        CommissionEmployee commissionEmployee =
                new CommissionEmployee( "Sue", "Jones", "333-33-3333", 10000, .06 );

        BasePlusCommissionEmployee basePlusCommissionEmployee =
                new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300 );

        employeeArray[ 0 ] = hourlyEmployee;
        employeeArray[ 1 ] = commissionEmployee;
        employeeArray[ 2 ] = basePlusCommissionEmployee;

        for ( Employee currentEmployee : employeeArray )
        {
            System.out.println( currentEmployee.toString() ); // invokes toString

            // determine whether element is a BasePlusCommissionEmployee
            if ( currentEmployee instanceof BasePlusCommissionEmployee )
            {
                // downcast Employee reference to
                // BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employee =
                        ( BasePlusCommissionEmployee ) currentEmployee;

                employee.setBaseSalary( 1.10 * employee.getBaseSalary() );

                System.out.printf(
                        "new base salary with 10%% increase is: $%,.2f\n",
                        employee.getBaseSalary() );
            } // end if

            System.out.printf(
                    "earned $%,.2f\n\n", currentEmployee.earnings() );
        } // end for
    }
}
