package ro.emanuel.banca_client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import ro.emanuel.dao.BancaDAO;
import ro.emanuel.pojo.Banca;


public class BancaMain {

	public static void main(String[] args) throws SQLException {

		ArrayList<Banca> banci = BancaDAO.getBanca();
		
		Scanner sc = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		System.out.println("Scrieti 1 - pentru a vedea tabelul client, \n"
						  +"Scrieti 2 - pentru a adauga un nou client, \n"
						  +"Scrieti 3 - pentru a modifica clienti in tabel,	\n"
						  +"Scrieti 4 - pentru a sterge clienti din tabel, \n");
		int alegere = scan.nextInt();
		
		
		if(alegere == 1) {
			System.out.println("Ati introdus 1!");
			for (Banca b : banci) {
				System.out.println(b.getId() + " || " + b.getNume() + " || " + b.getAdresa() + " || " + b.getTelefon());						
			}
		} else if (alegere == 2) {
			System.out.println("Ati introdus 2!");
			System.out.println("Cati clienti doriti sa introudceti?");
			int nr = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < nr; i++) {
				System.out.println("Dati nume");
					String nume = sc.nextLine();
				System.out.println("Dati adresa");
					String adresa = sc.nextLine();
				System.out.println("Dati telefon");
					String telefon = sc.nextLine();
				
				Banca banca = new Banca (0,nume, adresa, telefon);
				BancaDAO.createBanca(banca);
			}
			System.out.println("Inserare efectuata ! ");
		} else if (alegere == 3) {
			System.out.println("Ati introdus 3!");
			System.out.println("Introduceti Id-ul bancii pe care doriti sa o modificati.");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Dati nume");
				String nume = sc.nextLine();
			System.out.println("Dati adresa");
				String adresa = sc.nextLine();
			System.out.println("Dati telefon");
				String telefon = sc.nextLine();
				
			for(Banca b : banci) {
				if(b.getId() == id) {
					b.setNume(nume);
					b.setAdresa(adresa);
					b.setTelefon(telefon);
					BancaDAO.updateBanca(b);
				}
			}
			System.out.println("Modificarea a fost efectuata ! ");

		} else if (alegere == 4) {
			System.out.println("Ati introdus 4!");
			System.out.println("Introduceti Id-ul bancii pe care doriti sa o stergeti !");
			int id = sc.nextInt();
			sc.nextLine();
			for(Banca b : banci) {
				if(b.getId() == id) {
					BancaDAO.deleteBanca(b);
				}
			}
			System.out.println("Stergerea a fost efectuata ! ");

		} else {
			System.out.println("Nu ati introdus un numar valid!");
		}
	}	
}
