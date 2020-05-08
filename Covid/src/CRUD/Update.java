package CRUD;

import Pendukung.Koneksi;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;

public class Update {
		String id;
		Scanner input = new Scanner(System.in);
		private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		public Update(String vid){
				id = vid;
		}

		public void updateData(){
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				System.out.println("==== [ UPDATE DATA COVID NEGARA ] ====");
				System.out.print("Terkonfirmasi : ");
				int konfirmasi = input.nextInt();
				System.out.print("Kasus Aktif : ");
				int aktif = input.nextInt();
				System.out.print("Sembuh : ");
				int sembuh = input.nextInt();
				System.out.print("Meninggal : ");
				int meninggal = input.nextInt();

				Koneksi koneksi = new Koneksi();
				try {
						try {
								Statement statement = koneksi.getConnection().createStatement();
								statement.executeUpdate("INSERT INTO data_statik(id_negara,terkonfirmasi,aktif,sembuh,meninggal,tanggal) VALUES('" + id + "','" + konfirmasi + "','" + aktif + "','" + sembuh + "','"+meninggal+"','" + sdf.format(timestamp) + "')");
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
