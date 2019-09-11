package com.example3.demo3;

import java.io.*;
import java.util.ArrayList;

public class Drink {
    private int id;
    private String name;
    //private String[] nameList = new String[] {"Cola", "Sprite", "Orange juice", "Grape juice", "M150", "RedBull"};
    private ArrayList<String> nameList = new ArrayList<>();
    private String line;


    public Drink(int id) {
        try {
            FileReader fileReader =
                    new FileReader("drinkList.txt");
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                nameList.add(line);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("drinkList.txt", "UTF-8");
                writer.println("Cola");
                writer.println("Sprite");
                writer.println("Orange juice");
                writer.println("Grape juice");
                writer.println("M150");
                writer.println("RedBull");
                writer.close();
                FileReader fileReader =
                        new FileReader("drinkList.txt");
                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    nameList.add(line);
                }
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //System.out.println("Unable to open file '" + "drinkList.txt" + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + "drinkList.txt" + "'");
        }
        if (id < 0 || id > 5) {
            this.id = 0;
            this.name = nameList.get(0);
        } else {
            this.id = id;
            this.name = nameList.get(id);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0 || id > 5) {
            this.id = 0;
            this.name = nameList.get(0);
        } else {
            this.id = id;
            this.name = nameList.get(id);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
