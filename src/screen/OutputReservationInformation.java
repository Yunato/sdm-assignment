package screen;

import java.util.ArrayList;

import entity.Reservation;

/**
 * 予約状況出力画面クラス<br>
 * 入力された条件に合致する予約情報を出力する．
 */
public class OutputReservationInformation {

    /**
     * 条件に合う予約情報群を出力する．
     * @param reservations 予約情報群
     */
    public void show(ArrayList<Reservation> reservations) {
        for (Reservation r : reservations) {
            System.out.println("===================================================================");
            System.out.println("Date: " + r.getDate());
            System.out.println("Time: " + r.getTime());
            System.out.println("DrName: " + r.getDrName());
            System.out.println("CardNum: " + r.getCardNum());
            System.out.println("===================================================================");
        }
    }
}
