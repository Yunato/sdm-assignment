package entity;

/**
 * ユーザクラス<br>
 * 予約管理システムを用いるユーザを表す．
 */
public abstract class User {

    /**
     * ユーザを判別するための識別子を返す．
     * @return 識別子
     */
    abstract public long getIdentifier();

    /**
     * 予約管理プロセスにアクセスする．
     */
    abstract public void access();
}
