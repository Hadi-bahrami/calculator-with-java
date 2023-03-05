package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class Controller {
    @FXML
    private TextField field_result;

    String inputNumbers;
    int inputLength;
    @FXML
    public void numbersClicked(MouseEvent event){
        inputNumbers = ((Button)event.getSource()).getText();
        field_result.setText(field_result.getText()+inputNumbers);
    }

    @FXML
    public void clearClicked(){
        field_result.setText("0");
    }

    @FXML
    public void operatorsClicked(MouseEvent event){
        inputNumbers = ((Button)event.getSource()).getText();
        field_result.setText(field_result.getText()+inputNumbers);
        System.out.println(((Button) event.getSource()).getAccessibleText());

    }

    @FXML
    public void equalClicked(){
        inputNumbers = field_result.getText();
        //if-statement to counter the  Dangling meta character '+' near index 0
        if (inputNumbers.contains("+")){
            inputNumbers=  inputNumbers.replace("+", "plus");
            System.out.println("field_result.getText()::"+inputNumbers);
        }

        String[] operatorsArr = {"-", "plus", "X", "/"};
        for (String s : operatorsArr) {
            int indexof = inputNumbers.indexOf(s);
            if (indexof > 0 && indexof < inputNumbers.length()) {
                String[] splittingnumbers = inputNumbers.split(s);
                calculate(Long.parseLong(splittingnumbers[0]), Long.parseLong(splittingnumbers[1]), s);

            }
        }
    }

    public void calculate(long n1, long n2, String field_op){
        switch (field_op){
        case "-":
            field_result.setText(String.valueOf(n1-n2));
            break;
        case "plus":
            field_result.setText(String.valueOf(n1+n2));
            break;
        case "X":
            field_result.setText(String.valueOf(n1*n2));
            break;
        case "/":
            field_result.setText(String.valueOf(n1/n2));
            break;
        default:
            break;

    }
    }
}
