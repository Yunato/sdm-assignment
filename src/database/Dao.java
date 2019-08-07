package database;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import entity.Reservation;

/**
 * Daoクラス<br>
 * データベースへの操作を提供するクラスである．
 */
public class Dao {

    /**
     * 保存中の予約情報群(データベース再現用フィールド)
     */
    static private ArrayList<Reservation> reservations = new ArrayList<>();

    /**
     * レコード(新規予約情報)を追加する．
     * @param reservation 新規レコード
     * @return データベースに追加できたか
     */
    public synchronized boolean addReservation(Reservation reservation) {
        boolean result = true;
        Set<Reservation> checkHash = new HashSet<>(reservations);
        for (Reservation r : reservations) {
            if (r.equals(reservation)) result = false;
        }
        if (result) {
            reservations.add(reservation);
        }
        return result;
    }

    /**
     * レコード(申請済み予約情報)を削除する．
     * @param reservation 削除対象予約情報
     */
    public synchronized void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    /**
     * 診察券番号からレコード(申請済み予約情報)を取得する．
     * @param cardNum 診察券番号
     * @return 取得したレコード群
     */
    public synchronized ArrayList<Reservation> getRecords(long cardNum) {
        ArrayList<Reservation> result = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getCardNum() == cardNum)
                result.add(r);
        }
        return result;
    }

    /**
     * 日付と担当医師名からレコード(申請済み予約情報)を取得する．
     * @param date 予約日
     * @param drName 担当医師名
     * @return 取得したレコード群
     */
    public synchronized ArrayList<Reservation> getRecords(long date, String drName) {
        ArrayList<Reservation> result = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getDate() == date && r.getDrName().equals(drName))
                result.add(r);
        }
        return result;
    }
}
