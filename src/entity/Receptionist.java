package entity;

/**
 * 予約受け付け担当者クラス<br>
 * 予約受け付け担当者を表す．
 */
public class Receptionist extends User {

    /**
     * 職員ID
     */
    private long id;

    /**
     * 予約受け付け担当者クラスのコンストラクタ
     * @param id 職員ID
     */
    public Receptionist(long id) {
        this.id = id;
    }

    /**
     * 識別子である職員IDを返す．
     * @return 職員ID
     */
    @Override
    public long getIdentifier() {
        return id;
    }

    /**
     * 予約管理プロセスにアクセスする．
     */
    @Override
    public void access() { }
}
