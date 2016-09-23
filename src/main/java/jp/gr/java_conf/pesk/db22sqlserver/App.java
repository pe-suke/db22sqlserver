package jp.gr.java_conf.pesk.db22sqlserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class App {
    public static void main( String[] args ) {
    	System.out.println("1: HOGE_TABLE");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = br.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("処理開始" + new Date(System.currentTimeMillis()));
		boolean res = false;
		try {
			if ("1".equals(input)) {
				HogeTable hogeTable = new HogeTable();
				res = hogeTable.execute();
			} 
			

			if (res) {
				System.out.println("成功");
			} else {
				System.out.println("失敗");
			}
			System.out.println("処理終了" + new Date(System.currentTimeMillis()));
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
}
