package entity;

/**
 * 予約情報クラス<br>
 * ユーザが申請する予約情報を示す．
 */
public class Reservation {

    /**
     * 予約日
     */
    private long date;

    /**
     * 予約時刻
     */
    private long time;

    /**
     * 担当医師名
     */
    private String drName;

    /**
     * 診察券番号
     */
    private long cardNum;

    /**
     * 予約情報クラスのコンストラクタ
     * @param date 予約日
     * @param time 予約時刻
     * @param drName 担当医師名
     * @param cardNum 診察券番号
     */
    public Reservation(long date, long time, String drName, long cardNum) {
        this.date = date;
        this.time = time;
        this.drName = drName;
        this.cardNum = cardNum;
    }

    /**
     * 予約日を取得する．
     * @return 予約日
     */
    public long getDate() {
        return date;
    }

    /**
     * 予約時刻を取得する．
     * @return 予約時刻
     */
    public long getTime() {
        return time;
    }

    /**
     * 担当医師名を取得する．
     * @return 担当医師名
     */
    public String getDrName() {
        return drName;
    }

    /**
     * 診察券番号を取得する．
     * @return 診察券番号
     */
    public long getCardNum() {
        return cardNum;
    }

    /**
     * 与えられるオブジェクトと一致するかどうかを判定する．
     * @param obj 判定対象オブジェクト
     * @return 一致するかどうか
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Reservation reservation = (Reservation)obj;
        return date == reservation.date && time == reservation.time &&
                drName.equals(reservation.drName) && cardNum == reservation.cardNum;
    }
}
