package entity;

import control.StateManager;

/**
 * 患者クラス<br>
 * 患者を表す．
 */
public class Patient extends User {

    /**
     * 診察券番号
     */
    private long cardNum;

    /**
     * 患者クラスのコンストラクタ
     * @param num 診察券番号
     */
    public Patient(long num) {
        cardNum = num;
    }

    /**
     * 識別子である診察券番号を返す．
     * @return 診察券番号
     */
    @Override
    public long getIdentifier() {
        return cardNum;
    }

    /**
     * 予約管理プロセスにアクセスする．
     */
    @Override
    public void access() {
        StateManager manager = new StateManager();
    }
}
