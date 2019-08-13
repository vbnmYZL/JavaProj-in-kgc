package com.yzl.work12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class DaoToFile {

	public static void writeobject(Map<String, Vip> vipMap, String path) {
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(vipMap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static Map<String, Vip> readobject(String path) {
		
		ObjectInputStream ois = null;
		Map<String, Vip> vipMap = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			vipMap = (Map<String, Vip>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return vipMap;
	}
}
