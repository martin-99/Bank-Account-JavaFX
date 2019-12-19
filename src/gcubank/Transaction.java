package gcubank;

// imports needed for use in JavaFX binding
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * represents a transaction
 * 
 */
public class Transaction
{
    // properties in form needed for JavaFX binding
    private final SimpleDoubleProperty amount = new SimpleDoubleProperty(0.0);
    private final SimpleStringProperty type = new SimpleStringProperty("");
    private final SimpleStringProperty reference = new SimpleStringProperty("");
    private final SimpleStringProperty date = new SimpleStringProperty("");   // use String for date to keep it simple

    /**
     * Constructor for objects of class Transaction
     */
    public Transaction()
    {
       this(0.0, "", "", "");
    }
    
    
    /**
     * Constructor for objects of class Transaction
     * 
     * @param amount    the transaction amount
     * @param type      the transaction type         
     * @param reference the transaction reference
     * @param date      the transaction date
     */
    public Transaction(double amount, String type, String reference, String date)
    {
        setAmount(amount);
        setType(type);
        setReference(reference);
        setDate(date);
    }
    
    // getters and setters in form needed for JavaFX binding
    
    /**
     * returns the amount
     * 
     * @return  the transaction amount
     */
    public double getAmount()
    {
        return amount.get();
    }
    
    /**
     * sets the value of amount
     * 
     * @param amnt 
     */
    public void setAmount(double amnt)
    {
        amount.set(amnt);
    }
    
    /**
     * 
     * @return  the transaction type
     */
    public String getType()
    {
        return type.get();
    }
    
    /**
     * sets the value of amount
     * 
     * @param typ 
     */
    public void setType(String typ)
    {
        type.set(typ);
    }
    
    /**
     * returns the transaction reference
     * 
     * @return  the transaction reference
     */
    public String getReference()
    {
        return reference.get();
    }
    
    /**
     * sets the value of reference
     * 
     * @param ref 
     */
    public void setReference(String ref)
    {
        reference.set(ref);
    }
    
    /**
     * returns the transaction date
     * 
     * @return  the transaction date
     */
    public String getDate()
    {
        return date.get();
    }
    
    /**
     * sets the value of date
     * 
     * @param dat 
     */
    public void setDate(String dat)
    {
        date.set(dat);
    }
    
    public String toString()
    {
        return String.format("Amount: £%4.2f, Type: %s, Ref: %s,Date: %s",
            amount, type, reference, date);
    }
}
