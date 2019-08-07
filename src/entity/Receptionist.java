package entity;

/**
 * 予約受け付け担当者クラス<br>
 * 予約受け付け担当者を表す．
 */
public class Receptionist extends User {

    /**
     * 職員ID(職員を判別するための識別子．本実装には職員は予約受け付け担当者しか存在しない．)
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
     * 職員を判別するための識別子である職員IDを返す．
     * @return 職員ID
     */
    @Override
    public long getIdentifier() {
        return id;
    }

    /**
     * 予約管理プロセスにアクセスする．
     * (簡易的な実装であるため，本メソッドに状態管理クラスのメソッドを呼び出すステートメントを記述する)
     */
    @Override
    public void access() { }
}
