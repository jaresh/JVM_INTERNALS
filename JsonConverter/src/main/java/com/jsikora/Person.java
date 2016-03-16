package com.jsikora;

public class Person{
	
	public String firstName;
	public String lastName;
	public int age;
	private String[] adress = new String[3];
	private String telefone;
	
	Person(){
		String adress[] = {"Gdansk", "Słowackiego 234", "54-373 Gdańsk"};
		
		this.firstName = "Jacek";
		this.lastName = "Sikora";
		this.age = 68;
    	this.setAdress(adress);
    	this.setTelefone("681-00-00");
	}
	
	public String[] getAdress() {
		return adress;
	}
	public void setAdress(String[] adress) {
		this.adress = adress;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void printOutData(){
		System.out.println("First name: " + this.firstName);
		System.out.println("Last name: " + this.lastName);
		System.out.println("Age : " + this.age);
		System.out.println("Adress: ");
		
		for(int i=0; i<adress.length; i++)
			System.out.println("	" + this.adress[i]);
		
		System.out.println("Telefone: " + this.telefone);
	}
}