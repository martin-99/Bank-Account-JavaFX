
package accountmanagerfx;




//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

import gcubank.Account;
import gcubank.Customer;
import gcubank.Transaction;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;







public class Controller implements Initializable {

    @FXML private TableView<Transaction> tableView;

    @FXML private TextField amountField;

    @FXML private TextField typeField;

    @FXML private TextField referenceField;

    @FXML private Label customer;

    @FXML private Label heading;




    private Account account;







    @FXML

    protected void addTransaction(ActionEvent event) {

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

        updateHeading();




    }




    @Override

    public void initialize(URL url, ResourceBundle
            rb) {

// set up account to view

        createAccount();




// set up data for data table in view

        ObservableList<Transaction> data = tableView.getItems();

        data.setAll(getData());




// show heading information

        customer.setText(account.getCustomerName());

        updateHeading();

    }




    public List<Transaction> getData(){

        return Arrays.asList(

                Arrays.copyOfRange(account.getTransactions(),

                        0,

                        account.getNumberOfTransactions())

        );

    }




    private void createAccount(){

// create some transactions in code for demo - in a real app would be data

// retrieved from a database or service

        this.account = new Account(new Customer("Fernando",
                "Alonso"), "123");

        account.addTransaction(new Transaction(200.0 , "CREDIT",
                "ref1", "23/11/14"));

        account.addTransaction(new Transaction(500.0 , "DEBIT",
                "ref2", "24/11/14"));

        account.addTransaction(new Transaction(100.0,"CREDIT",
                "ref3", "02/12/14"));

    }




    private void updateHeading(){

        heading.setText(String.format("Account: %s Balance: %s ",

                account.getAccountNumber(),

                formatAsCurrency(account.getBalance()))

        );

    }

    private String currentDateString(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YY HH:mm" );

        String dateString = formatter.format(new Date());

        return dateString;

    }




    private String formatAsCurrency(double amount){

        NumberFormat currencyFormatter;

        currencyFormatter = NumberFormat.getCurrencyInstance();

        return currencyFormatter.format(amount);

    }

}


