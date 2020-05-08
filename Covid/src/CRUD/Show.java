package CRUD;

import Pendukung.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Show {
		String id;
		Scanner input = new Scanner(System.in);
		Koneksi koneksi = new Koneksi();
		public Show(String vid){
				id = vid;
		}


		public void tampilDataTerkini(){
				try{
						Statement statement = koneksi.getConnection().createStatement();
						String query = "SELECT a.id,a.id_negara,a.terkonfirmasi,a.aktif,a.sembuh,a.meninggal,MAX(a.tanggal) as tanggal,b.id_negara,b.nama_negara FROM data_statik a  INNER JOIN negara b ON a.id_negara = b.id_negara WHERE a.id_negara='"+id+"'";
						ResultSet resultSet = statement.executeQuery(query);
						while (resultSet.next()) {
								if(resultSet.getString("terkonfirmasi") == null || resultSet.getString("aktif") == null){
										String pesan = "====[ "+resultSet.getString("nama_negara")+" belum melaporkan data COVID-19 ]====";
										String PESAN = pesan.toUpperCase();
										System.out.println("\t\033[0;1m\u001B[31m "+PESAN+"\n\u001B[0m");
								}else {
										System.out.println("\n==== [ DATA COVID-19 TERKINI( " + resultSet.getString("nama_negara") + " ) ] ====");
										System.out.println("\tTerkonfirmasi\t: " + resultSet.getString("terkonfirmasi") + " Jiwa");
										System.out.println("\tKasus Aktif\t\t: " + resultSet.getString("aktif") + " Jiwa");
										System.out.println("\tSembuh\t\t\t: " + resultSet.getString("sembuh") + " Jiwa");
										System.out.println("\tMeninggal\t\t: " + resultSet.getString("meninggal") + " Jiwa");
										System.out.println("\t\033[3m\u001B[33mTerakhir Dilaporkan Pada Tanggal " + resultSet.getString("tanggal") + "\033[0m\u001B[0m\n");
								}
						}
						statement.close();
				} catch (
						SQLException sqlError) {
						System.out.println("Data Gagal Ditampilkan " + sqlError);
				} catch (ClassNotFoundException classError) {
						System.out.println("Driver tidak ditemukan !!");
				}
		}
		public void tampilHistory() {
				try {
						Statement statement = koneksi.getConnection().createStatement();
						String query = "SELECT * FROM data_statik a INNER JOIN negara b ON a.id_negara=b.id_negara WHERE a.id_negara ='" + id + "'";
						ResultSet resultSet = statement.executeQuery(query);
						while (resultSet.next()) {
								if(resultSet.getString("terkonfirmasi") == null || resultSet.getString("aktif") == null){
										String pesan = "====[ "+resultSet.getString("nama_negara")+" belum melaporkan data COVID-19 ]====";
										String PESAN = pesan.toUpperCase();
										System.out.println("\t\033[0;1m\u001B[31m "+PESAN+"\n\u001B[0m");
								}else {
										System.out.println("\n==== [ HISTORY DATA COVID-19 ( " + resultSet.getString("nama_negara") + " ) ] ====");
										System.out.println("\nPada Tanggal " + resultSet.getString("tanggal"));
										System.out.println("\tID Negara\t\t: " + resultSet.getString("id_negara"));
										System.out.println("\tNegara\t\t\t: " + resultSet.getString("nama_negara"));
										System.out.println("\tTerkonfirmasi\t: " + resultSet.getString("terkonfirmasi") + " Jiwa");
										System.out.println("\tKasus Aktif\t\t: " + resultSet.getString("aktif") + " Jiwa");
										System.out.println("\tSembuh\t\t\t: " + resultSet.getString("sembuh") + " Jiwa");
										System.out.println("\tMeninggal\t\t: " + resultSet.getString("meninggal") + " Jiwa\n");
								}
						}
						statement.close();
				} catch (
								SQLException sqlError) {
						System.out.println("Data Gagal Ditampilkan " + sqlError);
				} catch (ClassNotFoundException classError) {
						System.out.println("Driver tidak ditemukan !!");
				}
		}

}