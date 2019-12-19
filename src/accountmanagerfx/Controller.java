package accountmanagerfx;

import gcubank.Account;
import gcubank.Customer;
import gcubank.Transaction;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Controller {
    Account account ;
    @FXML private TableView<Transaction> tableView;
    @FXML private TextField amountField;
    @FXML private TextField typeField;
    @FXML private TextField referenceField;
    @FXML private Label customer;
    @FXML private Label heading;


    public void initialize (){
        createAccount();
// set up data for data table in view
        ObservableList<Transaction> data = tableView.getItems();
        data.setAll(getData());

// show heading information
        customer.setText(account.getCustomerName());


    }
    public  void createAccount(){
        Customer customer = new Customer("Fernando","Alonso");
        Account account = new Account(customer,"123");
        Transaction transact1 = new Transaction(200.00,"CREDIT","ref1", "23/11/14");
        Transaction transact2 = new Transaction(500.00,"DEBIT","ref2", "24/11/14");
        Transaction transact3 = new Transaction(200.00,"CREDIT","ref3", "02/12/14");
        account.addTransaction(transact1);
        account.addTransaction(transact2);
        account.addTransaction(transact3);
        System.out.println("Created account");


    }
    public List<Transaction> getData(){
        return Arrays.asList(
                Arrays.copyOfRange(account.getTransactions(),
                        0,
                        account.getNumberOfTransactions())
        );
    }

    private String currentDateString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yy" );
        String dateString = formatter.format(new Date());
        return dateString;
    }

    private String formatAsCurrency(double amount){
        NumberFormat currencyFormatter;
        currencyFormatter = NumberFormat.getCurrencyInstance();
        return currencyFormatter.format(amount);
    }

    public void addTransaction(){
        ObservableList<Transaction> data = tableView.getItems();

// add new transaction to account and to data for view
        Transaction newTransaction = new Transaction(Double.parseDouble(amountField.getText()),
                typeField.getText(),
                referenceField.getText(),
                currentDateString()
        );
        data.add(newTransaction);
        account.addTransaction(newTransaction);

// update controls
        amountField.setText("");
        typeField.setText("");
        referenceField.setText("");


    }
    private void updateHeading(){
        heading.setText(String.format("Account: %s Balance: %s ",
                account.getAccountNumber(),
                formatAsCurrency(account.getBalance()))
        );
    }

}
