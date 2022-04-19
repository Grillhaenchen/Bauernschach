package Chessgame;

import Infrastructure.BlackFarmer;
import Infrastructure.Position;
import Infrastructure.WhiteFarmer;

import java.util.ArrayList;
import java.util.Scanner;

public class ChessGame implements IGame {
    ArrayList<WhiteFarmer> WhiteFarmers = new ArrayList<WhiteFarmer>();
    ArrayList<BlackFarmer> BlackFramers = new ArrayList<BlackFarmer>();

    boolean PlayerOneOnTurn;
    boolean firstTurn;
    boolean FirstTurnConfirmed = false;

    public ChessGame() {
        initLists();
        DrawChessBoard();
        PlayerOneOnTurn = true;
        firstTurn = true;

    }

    private void Start() {
        while (true) {
            Move();
        }
    }

    public void newGame() {
    }

    @Override
    public String[][] Move(int[][] _FígureTurn) {
        //_FígureTurn[0][0]  <--old column
        //_FígureTurn[0][1]  <--old row

        //_FígureTurn[1][0]  <--new column
        //_FígureTurn[1][1]  <--new row

        Position OldPosition = new Position(_FígureTurn[0][0]-1, _FígureTurn[0][1]-1);
        Position NewPosition = new Position(_FígureTurn[1][0]-1, _FígureTurn[1][1]-1);

        FirstTurnConfirmed = false;

        if (PlayerOneOnTurn) {

            FirstTurnConfirmed = firstTurn == true && OldPosition.getY() - NewPosition.getY() == 2;

            if (FirstTurnConfirmed) {
                WhiteFarmers.get(GetIndexFromWhiteFarmer(OldPosition)).getPosition().setY(WhiteFarmers.get(GetIndexFromWhiteFarmer(OldPosition)).getPosition().getY() + 2);
            } else if (PlayerCanKillOther(NewPosition)) {
                WhiteFarmers.get(GetIndexFromWhiteFarmer(OldPosition)).getPosition().setY(WhiteFarmers.get(GetIndexFromWhiteFarmer(OldPosition)).getPosition().getY() + 1);
                WhiteFarmers.get(GetIndexFromWhiteFarmer(OldPosition)).getPosition().setX(NewPosition.getX());
                BlackFramers.set(GetIndexFromBlackFarmer(NewPosition), null);
            } else {
                WhiteFarmers.get(GetIndexFromWhiteFarmer(OldPosition)).getPosition().setY(WhiteFarmers.get(GetIndexFromWhiteFarmer(OldPosition)).getPosition().getY() + 1);
            }
            System.out.println("Zug ausgeführt");
            PlayerOneOnTurn = false;
        } else {
            FirstTurnConfirmed = firstTurn == true && OldPosition.getY() - NewPosition.getY() == 2;

            if (FirstTurnConfirmed) {
                BlackFramers.get(GetIndexFromBlackFarmer(OldPosition)).getPosition().setY(BlackFramers.get(GetIndexFromBlackFarmer(OldPosition)).getPosition().getY() - 2);
            } else if (PlayerCanKillOther(NewPosition)) {
                int i=GetIndexFromBlackFarmer(OldPosition);

                BlackFramers.get(i).getPosition().setY(BlackFramers.get(i).getPosition().getY() -1);
                BlackFramers.get(i).getPosition().setX(NewPosition.getX());
                WhiteFarmers.get(GetIndexFromWhiteFarmer(NewPosition)).setPosition(new Position(-1,-1));
            } else {
                BlackFramers.get(GetIndexFromBlackFarmer(OldPosition)).getPosition().setY(BlackFramers.get(GetIndexFromBlackFarmer(OldPosition)).getPosition().getY() - 1);
            }
            System.out.println("Zug ausgeführt");
            PlayerOneOnTurn = true;
        }

        return initArray(BlackFramers, WhiteFarmers);
    }

    public String[][] Move() {

        Scanner scanner = new Scanner(System.in);
        int IndexOfArrayList;
        FirstTurnConfirmed = false;

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

    private String[][] initArray(ArrayList<BlackFarmer> _blackFarmers, ArrayList<WhiteFarmer> _whiteFarmers) {
        String[][] DrawArray = new String[8][8];


       /* for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                try {

                    if (j==0&&i==3){
                        System.out.println("sdf");
                    }
                    if (WhiteFarmers.get(i).getPosition().getX() == i && WhiteFarmers.get(i).getPosition().getY() == j) {
                        System.out.print(" X ");
                        DrawArray[j][i] = "X";
                    }
                    else if (BlackFramers.get(i).getPosition().getX() == i && BlackFramers.get(i).getPosition().getY() == j) {
                        System.out.print(" O ");
                        DrawArray[j][i] = "O";
                    }
                    else {
                        System.out.print(" # ");
                        DrawArray[j][i] = " ";
                    }
                }catch (NullPointerException e){
                    System.out.print(" # ");
                    DrawArray[j][i] = " ";
                }

            }
        }*/

        //Draw Empty PlayField
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                        System.out.print(" # ");
                        DrawArray[j][i] = " ";
            }
        }

        //Fill PLayField with blackFarmer
        for (BlackFarmer Farmer:
             BlackFramers) {

                if (Farmer.getPosition().getY()!=-1&&Farmer.getPosition().getX()!=-1){
                    DrawArray[Farmer.getPosition().getY()][Farmer.getPosition().getX()]="O";
                }



        }

        //Fill PLayField with WhiteFarmer
        for (WhiteFarmer Farmer:
                WhiteFarmers) {
                if (Farmer.getPosition().getY()!=-1&&Farmer.getPosition().getX()!=-1)
                {
                    DrawArray[Farmer.getPosition().getY()][Farmer.getPosition().getX()]="X";
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
        if (PlayerOneOnTurn) {
            return "Spieler 1";
        } else return "Spieler 2";
    }

    @Override
    public boolean GetFirstTurn() {
        return FirstTurnConfirmed;
    }

    private void initLists() {

        //init Farmers
        for (int i = 0; i < 8; i++) {
            WhiteFarmers.add(new WhiteFarmer(i, 0));
            BlackFramers.add(new BlackFarmer(i, 7));
        }
    }

    public String[][] DrawChessBoard() {

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
        return initArray(BlackFramers, WhiteFarmers);
    }

    public boolean PlayerCanKillOther(Position _newPosition) {
        if (PlayerOneOnTurn) {
            for (BlackFarmer Farmer : BlackFramers) {
                if ((_newPosition.getY() == Farmer.getPosition().getY() && (_newPosition.getX() - Farmer.getPosition().getX() == -1 || _newPosition.getX() - Farmer.getPosition().getX() == 1))) {
                    return true;
                }
            }
        } else {
            for (WhiteFarmer Farmer : WhiteFarmers) {
                if ((_newPosition.getY() == Farmer.getPosition().getY() && (_newPosition.getX() - Farmer.getPosition().getX() == 1 || _newPosition.getX() - Farmer.getPosition().getX() == -1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public int GetIndexFromBlackFarmer(Position _oldPosition) {
        int returnValue = 100;

        for (int i = 0; i < BlackFramers.toArray().length; i++) {

            if (BlackFramers.get(i).getPosition().getY() == _oldPosition.getY() && BlackFramers.get(i).getPosition().getX() == _oldPosition.getX()) {
                returnValue = i;
            }
        }
        return returnValue;
    }

    public int GetIndexFromWhiteFarmer(Position _oldPosition) {
        int returnValue = 100;

        for (int i = 0; i < WhiteFarmers.toArray().length; i++) {

            if (WhiteFarmers.get(i).getPosition().getY() == _oldPosition.getY() && WhiteFarmers.get(i).getPosition().getX() == _oldPosition.getX()) {
                returnValue = i;
            }
        }
        return returnValue;
    }

}