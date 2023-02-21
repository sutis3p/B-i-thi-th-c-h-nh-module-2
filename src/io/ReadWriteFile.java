package io;

import model.Student;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteFile implements Serializable {
    public void write(File file, ArrayList<Student> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> read(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Student> list = (ArrayList<Student>) objectInputStream.readObject();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
