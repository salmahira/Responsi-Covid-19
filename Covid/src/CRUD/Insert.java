package CRUD;

import Pendukung.Koneksi;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;

public class Insert {
		Scanner input = new Scanner(System.in);
		public void tambahNegara(){
				System.out.println("==== [ INPUT NEGARA ] ====");
				System.out.print("ID Negara : ");
				String id = input.next();
				System.out.print("Nama Negara : ");
				String negara = input.next();
				Koneksi koneksi = new Koneksi();
				try {
						try {
								Statement statement = koneksi.getConnection().createStatement();
								statement.executeUpdate("INSERT INTO negara VALUES('" + id + "','" + negara + "')");
								System.out.println("Data Berhasil Disimpan!");
								statement.close();
						} catch (ClassNotFoundException | SQLException ex) {
								java.util.logging.Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
						}
				} catch (NumberFormatException ex) {
						System.out.println("Tipe Data Salah");
				}catch (Error ext){
						System.out.println("SALAH!!");
				}
		}
}