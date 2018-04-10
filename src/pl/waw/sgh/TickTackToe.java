package pl.waw.sgh;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TickTackToe {
    final static String FILE = "ticktacktoe.csv";

    public static void main(String[] args) {

        File myFile = new File(FILE);
        int[][] Array = new int[3][3];
        try {
            Scanner scanner = new Scanner(myFile);
            int i = 0;
            int j = 0;

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] cells = line.split(",");
                for (String el : cells) {
                    System.out.println("El: " + el);

                    Array[i][j] = Integer.parseInt(el);
                    j++;
                }
                System.out.println("New line");
                j = 0;
                i++;
                System.out.println("Line " + i + " : " + line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean IsDecided = false;

            for (int r = 0; r < Array.length; r++) {
                if (Array[r][0] == Array[r][1] && Array[r][1] == Array[r][2]) {
                    if (Array[r][0] == 1) {
                        System.out.println("The game is one by X");
                        IsDecided = true;
                        return;

                    } else if (Array[r][0] == -1) {
                        System.out.println("The game is wone by O");
                        IsDecided = true;
                        return;

                    } else if (Array[r][0] ==0){
                        System.out.println("The game is in progress");
                        IsDecided = true;
                        return;
                    }
                }

            }



            for (int c = 0; c < Array.length; c++) {
                if (Array[0][c] == Array[1][c] && Array[1][c] == Array[2][c]) {
                    if (Array[0][c] == 1) {
                        System.out.println("The game is one by X");
                        IsDecided=true;
                        return;
                    }
                    else if (Array[0][c] == -1) {
                        System.out.println("The game is wone by O");
                        IsDecided=true;
                        return;
                    }
                    else if(Array[0][c]==0){
                        System.out.println("The game is in progress");
                        IsDecided=true;
                        return;
                    }
                }

            }




                if (Array[0][0] == Array[1][1] && Array[1][1] == Array[2][2]) {
                    if (Array[0][0] == 1) {
                        System.out.println("The game is one by X");
                        return;
                    }
                    else if (Array[0][0] == -1) {
                        System.out.println("The game is wone by O");
                        return;
                    }
                    else if(Array[0][0]==0){
                        System.out.println("The game is in progress");
                       return;
                    }
                }
            else if(Array[0][2] == Array[1][1] && Array[1][1] == Array[2][0]) {
                    if (Array[0][2] == 1) {
                        System.out.println("The game is one by X");
                        return;
                    }
                    else if (Array[0][2] == -1) {
                        System.out.println("The game is wone by O");
                        return;
                    }
                    else if(Array[0][2]==0){
                        System.out.println("The game is in progress");
                        return;
                    }
                }

    for (int r = 0; r < Array.length; r++) {

        for (int c = 0; c < Array[r].length; c++) {

            if (Array[r][c] == 0) {
                System.out.print("The game is still in progress");
                return;
            }
        }
        }
if(IsDecided==false){
    System.out.println("Nobody won");
}

}
}
