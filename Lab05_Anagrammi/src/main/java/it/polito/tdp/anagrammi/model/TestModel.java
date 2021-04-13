package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Model m=new Model();
     List anagrammi=new ArrayList();
     anagrammi=m.anagrammi("eat");
     System.out.println(anagrammi);
     
	}

}
