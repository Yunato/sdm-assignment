package screen;

import java.util.Scanner;

import entity.Reservation;

/**
 * 入力情報確認画面クラス<br>
 * 予約申請もしくは予約取り消しにおける確認画面を描画する．
 */
public class ConfirmInputInformation {

    /**
     * システムが処理する対象の情報に対して，それが正しいのかどうかを利用者に確認する．
     * 本メソッドは確認が得られたら true，確認が得られなかったら false を返す．
     * @param reservation 確認対象情報
     * @return 確認ボタンが押されたかどうか
     */
    public boolean getAccept(Reservation reservation) {
        System.out.println("Are you sure want to apply for the following information ? [Yes/No]");
        System.out.println("===================================================================");
        System.out.println("Date: " + reservation.getDate());
        System.out.println("Time: " + reservation.getTime());
        System.out.println("DrName: " + reservation.getDrName());
        System.out.println("CardNum: " + reservation.getCardNum());
        System.out.println("===================================================================");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        input = input.toLowerCase();
        if (input.equals("yes") || input.equals("y")) {
            return true;
        } else {
            return false;
        }
    }
}
