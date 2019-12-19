package gcubank;

/**
 * represents a customer
 * 
 */
public class Customer
{
    // the first name
    private String firstName;
    // the last name
    private String lastName;

    /**
     * Constructor for objects of class Customer
     * 
     * @param firstName  the first name
     * @param lastName   the last name
     */
    public Customer(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * returns the first name
     * 
     * @return the first name
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * returns the last name
     * 
     * @return the last name
     */
    public String getLastName()
    {
        return lastName;
    }
}
