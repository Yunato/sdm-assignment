package screen;

import java.util.Scanner;

import entity.Reservation;

/**
 * 条件入力画面クラス<br>
 * 既に申請済みである予約状況を確認する際に描画する．
 */
public class InputConditionForSearch {

    /**
     * 入力情報を得る．これにより確認したい予約状況を明確化する．
     * @return 入力された条件
     */
    public Reservation getInputInformation() {
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

        System.out.println("Input doctor name");
        String name = scanner.next();

        return new Reservation(date, -1, name, -1);
    }
}
