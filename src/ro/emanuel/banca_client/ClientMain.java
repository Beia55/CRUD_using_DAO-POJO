package ro.emanuel.banca_client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import ro.emanuel.dao.BancaDAO;
import ro.emanuel.dao.ClientDAO;
import ro.emanuel.pojo.Banca;
import ro.emanuel.pojo.Client;

public class ClientMain {

	public static void main(String[] args) throws SQLException {

		ArrayList<Client> clienti = ClientDAO.getClienti();
		
		Scanner sc = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		System.out.println("Scrieti 1 - pentru a vedea tabelul client, \n"
						  +"Scrieti 2 - pentru a adauga un nou client, \n"
						  +"Scrieti 3 - pentru a modifica clienti in tabel,	\n"
						  +"Scrieti 4 - pentru a sterge clienti din tabel, \n"
						  +"Scrieti 5 - pentru a selecta clienti dupa ID, \n"
						  +"Scrieti 6 - pentru a cauta clienti dupa nume (Like), \n");
		int alegere = scan.nextInt();
		
		if(alegere == 1) {
			System.out.println("Ati introdus 1!");
			for (Client c : clienti) {
				System.out.println(c.getId() + " || " + c.getNume() + " || " + c.getPrenume() + " || " + c.getVarsta() + " || " + c.getCont() + " || " + c.getSold());						
			}
		} else if (alegere == 2) {
			System.out.println("Ati introdus 2!");
			System.out.println("Cati clienti doriti sa introudceti?");
			int nr = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < nr; i++) {
				System.out.println("Dati nume");
					String nume = sc.nextLine();
				System.out.println("Dati prenume");
					String prenume = sc.nextLine();
				System.out.println("Dati varsta");
					int varsta = sc.nextInt();
					sc.nextLine();
				System.out.println("Dati cont");
					String cont = sc.nextLine();
				System.out.println("Dati sold");
					double  sold = sc.nextDouble();
					sc.nextLine();
				
				Client client = new Client (0,nume, prenume,varsta, cont, sold);
				ClientDAO.createClient(client);
			}
			System.out.println("Inserare efectuata ! ");
		} else if (alegere == 3) {
			System.out.println("Ati introdus 3!");
			System.out.println("Introduceti Id-ul clientului pe care doriti sa il modificati.");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Dati nume");
				String nume = sc.nextLine();
			System.out.println("Dati prenume");
				String prenume = sc.nextLine();
			System.out.println("Dati varsta");
				int varsta = sc.nextInt();
				sc.nextLine();
			System.out.println("Dati cont");
				String cont = sc.nextLine();
			System.out.println("Dati sold");
				double  sold = sc.nextDouble();
				sc.nextLine();
				
			for(Client c : clienti) {
				if(c.getId() == id) {
					c.setNume(nume);
					c.setPrenume(prenume);
					c.setVarsta(varsta);
					c.setCont(cont);
					c.setSold(sold);
					ClientDAO.updateClient(c);
				}
			}
			System.out.println("Modificarea a fost efectuata ! ");

		} else if (alegere == 4) {
			System.out.println("Ati introdus 4!");
			System.out.println("Introduceti Id-ul clientului pe care doriti sa il stergeti !");
			int id = sc.nextInt();
			sc.nextLine();
			for(Client c : clienti) {
				if(c.getId() == id) {
					ClientDAO.deleteClient(c);
				}
			}
			System.out.println("Stergerea a fost efectuata ! ");

		} else if (alegere == 5) {
			System.out.println("Ati introdus 5!");
			System.out.println("Introduceti Id-ul clientului pe care doriti sa il selectati.");
			int nr = 0;
			int id = sc.nextInt();
			sc.nextLine();
			for(Client c : clienti) {
				if(c.getId() == id) {
					System.out.println(c.getId() + " || " + c.getNume() + " || " + c.getPrenume() + " || " + c.getVarsta() + " || " + c.getCont() + " || " + c.getSold());						
					nr++;
				} 
			}
			if(nr==0) {
				System.out.println("NULL");
			}
		} else if (alegere == 6) {
			System.out.println("Ati introdus 6!");
			System.out.println("Introduceti numele (Like) clientului pe care doriti sa il selectati.");
			String numeQuery = sc.nextLine();
			ArrayList<Client> clientByNume = ClientDAO.getClientiByNume(numeQuery);
			for (Client c : clientByNume) {
				System.out.println(c.getId() + " || " + c.getNume() + " || " + c.getPrenume() + " || " + c.getVarsta() + " || " + c.getCont() + " || " + c.getSold());						
			}
			if(clientByNume.size() == 0) {
				System.out.println("NULL");
			}
		} else {
			System.out.println("Nu ati introdus un numar valid!");
		}
	}	
}
