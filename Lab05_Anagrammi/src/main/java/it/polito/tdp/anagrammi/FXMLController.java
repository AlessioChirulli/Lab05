package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
 
	Model model=new Model();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnAnagrammi;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagrammi(ActionEvent event) {
    String input=txtInput.getText();
    txtInput.setDisable(true);
    btnAnagrammi.setDisable(true);
    if(input.length()==0) {
    	System.out.println("Inserisci una parola!");
    	return ;
    }
    else {
    	List<List<String>>risultato=model.anagrammi(input);
    	for(String s: risultato.get(0)) {
    	txtCorretti.appendText(s+"\n");	
    	}
    	for(String s: risultato.get(1)) {
        	txtErrati.appendText(s+"\n");	
        	}
    }
    }

    @FXML
    void doReset(ActionEvent event) {
    txtInput.clear();
    txtCorretti.clear();
    txtErrati.clear();
    txtInput.setDisable(false);
    btnAnagrammi.setDisable(false);
    }
    
    public void setModel(Model m) {
    	this.model = m ;
    }
    
    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}