package screen;

import java.util.ArrayList;
import java.util.Scanner;

import database.Dao;
import entity.Reservation;

/**
 * 取り消し用予約一覧画面クラス<br>
 * ユーザが申請した予約を取り消す際に描画する．
 */
public class RemoveReservationList {

    /**
     * 予約を選択する．
     * @param cardNum 診察券番号
     * @return 選択された予約情報
     */
    public Reservation selectReservation(Long cardNum) {
        Dao dao = new Dao();
        ArrayList<Reservation> reservations = dao.getRecords(cardNum);

        int index = 0;
        for (Reservation r : reservations) {
            System.out.println("===================================================================");
            System.out.println("Index: " + index);
            System.out.println("Date: " + r.getDate());
            System.out.println("Time: " + r.getTime());
            System.out.println("DrName: " + r.getDrName());
            System.out.println("CardNum: " + r.getCardNum());
            System.out.println("===================================================================");
            ++index;
        }

        Scanner scanner = new Scanner(System.in);
        int input;
        while(true) {
            System.out.println("Input index (Type is Number)");
            String strIndex = scanner.next();
            try {
                input = Integer.parseInt(strIndex);
                if (0 <= input && input < reservations.size())
                    break;
                else
                    System.out.println("Invalid range: [ " + 0 + " - " + (reservations.size() - 1) + " ]\n");
            }catch (NumberFormatException e) {
                System.out.println("Invalid input (Type is incorrect)");
            }
        }

        return reservations.get(input);
    }
}
