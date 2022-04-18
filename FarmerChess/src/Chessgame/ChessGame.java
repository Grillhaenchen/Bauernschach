package Chessgame;

import Infrastructure.BlackFarmer;
import Infrastructure.WhiteFarmer;

import java.util.ArrayList;
import java.util.Scanner;

public class ChessGame implements IGame {
    ArrayList<WhiteFarmer> WhiteFarmers = new ArrayList<WhiteFarmer>();
    ArrayList<BlackFarmer> BlackFramers = new ArrayList<BlackFarmer>();

    boolean PlayerOneOnTurn;
    boolean firstTurn;

    public ChessGame() {
        initLists();
        DrawChessBoard();
        PlayerOneOnTurn = true;
        firstTurn = true;

    }

    private void Start(){
        while (true){
            Move();
        }
    }

    public void newGame() {
    }

    public String[][] Move() {

        Scanner scanner = new Scanner(System.in);
        int IndexOfArrayList;
        boolean FirstTurnConfirmed = false;

        if (PlayerOneOnTurn) {
            PlayerOneOnTurn = false;
            do {
                System.out.println("Spieler 1 am zug");
                System.out.println("Geben Sie die Nummer der Spielfigur ein");
                IndexOfArrayList = scanner.nextInt();
                if (firstTurn) {
                    System.out.println("Erster zug möchten sie zwei felder ziehen");
                    System.out.println("Geben Sie J ein  um 2 felder zu ziehen");
                    scanner = new Scanner(System.in);
                    if (scanner.nextLine().contains("J")) {
                        FirstTurnConfirmed = true;
                    }
                }
            } while (CollisionDetected(IndexOfArrayList, FirstTurnConfirmed, PlayerOneOnTurn) == true);

            if (FirstTurnConfirmed) {
                WhiteFarmers.get(IndexOfArrayList).getPosition().setY(WhiteFarmers.get(IndexOfArrayList).getPosition().getY() + 2);
            } else {
                WhiteFarmers.get(IndexOfArrayList).getPosition().setY(WhiteFarmers.get(IndexOfArrayList).getPosition().getY() + 1);
            }

            System.out.println("Zug ausgeführt");

            DrawChessBoard();
        } else {
            PlayerOneOnTurn = true;
            do {
                System.out.println("Spieler 2 am zug");
                System.out.println("Geben Sie die Nummer der Spielfigur ein");
                IndexOfArrayList = scanner.nextInt();
                if (firstTurn) {
                    System.out.println("Erster zug möchten sie zwei felder ziehen");
                    System.out.println("Geben Sie J ein  um 2 felder zu ziehen");

                    scanner = new Scanner(System.in);
                    if (scanner.nextLine().contains("J")) {
                        FirstTurnConfirmed = true;
                    }
                }
            } while (CollisionDetected(IndexOfArrayList, FirstTurnConfirmed, PlayerOneOnTurn) == true);

            if (FirstTurnConfirmed) {
                BlackFramers.get(IndexOfArrayList).getPosition().setY(BlackFramers.get(IndexOfArrayList).getPosition().getY() - 2);
            } else {
                BlackFramers.get(IndexOfArrayList).getPosition().setY(BlackFramers.get(IndexOfArrayList).getPosition().getY() - 1);
            }

            System.out.println("Zug ausgeführt");

            DrawChessBoard();
        }


        return initArray(BlackFramers, WhiteFarmers);
    }

    private String[][] initArray(ArrayList<BlackFarmer> _blackFarmers, ArrayList<WhiteFarmer> _whiteFarmers){
        String[][] DrawArray=new String[8][8];


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (WhiteFarmers.get(j).getPosition().getX() == j && WhiteFarmers.get(j).getPosition().getY() == i) {
                    System.out.print(" X ");
                    DrawArray[i][j] = "O";
                } else if (BlackFramers.get(j).getPosition().getX() == j && BlackFramers.get(j).getPosition().getY() == i) {
                    System.out.print(" O ");
                    DrawArray[i][j] = "X";
                } else {
                    System.out.print(" # ");
                    DrawArray[i][j] = " ";
                }
            }
        }
        return DrawArray;
    }

    private boolean CollisionDetected(int indexOfArrayList, boolean firstTurnConfirmed, boolean playerOneOnTurn) {

        if (playerOneOnTurn) {

            if (firstTurnConfirmed) {
                return BlackFramers.get(indexOfArrayList).getPosition().getY() == WhiteFarmers.get(indexOfArrayList).getPosition().getY() + 2;
            } else {
                return BlackFramers.get(indexOfArrayList).getPosition().getY() == WhiteFarmers.get(indexOfArrayList).getPosition().getY() + 1;
            }
        } else {
            if (firstTurnConfirmed) {
                return WhiteFarmers.get(indexOfArrayList).getPosition().getY() == BlackFramers.get(indexOfArrayList).getPosition().getY() - 2;
            } else {
                return WhiteFarmers.get(indexOfArrayList).getPosition().getY() == BlackFramers.get(indexOfArrayList).getPosition().getY() - 1;
            }
        }
    }

    public String GetWinner() {
        return null;
    }

    public String GameOver() {
        return null;
    }

    public String NextGamer() {
       if (PlayerOneOnTurn){
           return "Spieler 1";
       }
       else
           return "Spieler 2";
    }

    private void initLists() {

        //init Farmers
        for (int i = 0; i < 8; i++) {
            WhiteFarmers.add(new WhiteFarmer(i, 0));
            BlackFramers.add(new BlackFarmer(i, 7));
        }
    }

    public  String[][] DrawChessBoard() {

        System.out.println(" 0  1  2  3  4  5  6  7");
        System.out.println("------------------------");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (WhiteFarmers.get(j).getPosition().getX() == j && WhiteFarmers.get(j).getPosition().getY() == i) {
                    System.out.print(" X ");
                } else if (BlackFramers.get(j).getPosition().getX() == j && BlackFramers.get(j).getPosition().getY() == i) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" # ");
                }
            }
            System.out.println();
        }
return initArray(BlackFramers,WhiteFarmers);
    }


}