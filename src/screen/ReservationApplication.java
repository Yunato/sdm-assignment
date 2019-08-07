package screen;

import java.util.Scanner;

import entity.Reservation;

/**
 * 予約申請画面クラス<br>
 * ユーザが予約申請を行う際に描画する．
 */
public class ReservationApplication {

    /**
     * ユーザから予約申請情報の入力を得る．
     * @param cardNum 診察券番号
     * @return 入力された予約情報
     */
    public Reservation getInputInformation(Long cardNum) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input date (Type is Number)");
        long date;
        while(true) {
            String strDate = scanner.next();
            try {
                date = Long.parseLong(strDate);
                break;
            }catch (NumberFormatException e) {
                System.out.println("Invalid input (Type is incorrect)");
            }
        }

        System.out.println("Input time (Type is Number)");
        long time;
        while(true) {
            String strTime = scanner.next();
            try {
                time = Long.parseLong(strTime);
                break;
            }catch (NumberFormatException e) {
                System.out.println("Invalid input (Type is incorrect)");
            }
        }

        System.out.println("Input doctor name");
        String name = scanner.next();

        return new Reservation(date, time, name, cardNum);
    }
}
