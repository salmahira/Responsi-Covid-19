package CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
		Scanner input = new Scanner(System.in);
		Statement statement = null;
		ResultSet resultSet = null;
		List<Data>negara = new ArrayList<>();

		public Main(){
				while(true) {
						int menu = menu();
						switch (menu) {
								case 1:
										Insert insert = new Insert();
										insert.tambahNegara();
										break;
								case 2:
										int menu2 = menuTampil();
										int index = menu2-1;
										Show show = new Show(negara.get(index).getId());
										int menu4 = pilihan();
										switch (menu4){
												case 1:
														show.tampilDataTerkini();
														negara.clear();
														break;
												case 2:
														show.tampilHistory();
														negara.clear();
														break;
												default:
														System.out.println("Menu Tidak Tersedia!");
										}
										break;
								case 3:
										int menu3 = menuTampil();
										int index2 = menu3-1;
										Update update = new Update(negara.get(index2).getId());
										update.updateData();
										negara.clear();
										break;
								case 4:
										System.out.println("Anda berhasil keluar!");
										System.exit(0);
										break;
								default:
										System.out.println("Menu Tidak Tersedia!");
						}
				}
		}

		public int menu(){
				System.out.println("[MENU]");
				System.out.println("[1] Input Negara");
				System.out.println("[2] Output Data Covid-19");
				System.out.println("[3] Update Data Covid-19");
				System.out.println("[4] EXIT");
				System.out.print("Pilih : ");
				return input.nextInt();
		}

		public int menuTampil() {
				Koneksi koneksi = new Koneksi();
				try {
						statement = koneksi.getConnection().createStatement();
						String sql = "SELECT * FROM negara";
						resultSet = statement.executeQuery(sql);
						while (resultSet.next()) {
								Data datanegara = new Data();
								datanegara.setId(resultSet.getString("id_negara"));
								datanegara.setNegara(resultSet.getString("nama_negara"));
								negara.add(datanegara);
						}
						statement.close();
				} catch (SQLException sqlError) {
						System.out.println("Data Gagal Ditampilkan " + sqlError);
				} catch (ClassNotFoundException classError) {
						System.out.println("Driver tidak ditemukan !!");
				}
				System.out.println("\n\n[MENU TAMPIL DATA]");
				for(int j= 0; j<negara.size();j++){
						System.out.println("["+(j+1)+"] "+negara.get(j).getNegara());
				}
				System.out.print("Pilih Negara : ");
				return input.nextInt();
		}

		public int pilihan(){
				System.out.println("\n\n[MENU DATA COVID-19]");
				System.out.println("[1] Data COVID-19 Terkini");
				System.out.println("[2] History Data COVID-19");
				System.out.print("Pilihan : ");
				return input.nextInt();
		}


		public static void main(String args[]){
				new Main();
		}
}

