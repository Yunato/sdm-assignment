package control;

import java.util.ArrayList;

import database.Dao;
import entity.Patient;
import entity.Reservation;
import entity.User;
import screen.CompleteAcceptReservation;
import screen.CompleteRemoveReservation;
import screen.ConfirmInputInformation;
import screen.InputConditionForSearch;
import screen.OutputReservationInformation;
import screen.QuestAndAnswer;
import screen.RemoveReservationList;
import screen.ReservationApplication;

/**
 * 状態管理クラス<br>
 * 予約情報における各種状態や操作を管理する．
 */
public class StateManager {

    public static final int STATE_RESERVE = 0;
    public static final int STATE_REMOVE  = 1;
    public static final int STATE_QA      = 2;
    public static final int STATE_CHECK   = 3;

    /**
     * 状態変数
     */
    private int state;

    /**
     * 引数の状態識別子を基に画面を切り替える．
     * 画面を切り替えることで，予約申請，予約取り消し，Q&amp;A確認，予約状況確認処理を行える．
     * 予約申請と予約取り消しを行う場合，患者の診察券番号が必要となるため第2引数に患者オブジェクトを渡す．
     * 予約受け付け担当者オブジェクトが渡された場合は，予約申請と予約取り消しは行えない．
     * @param state 状態識別子
     * @param user ユーザ情報
     */
    public void switchScreen(int state, User user) {
        this.state = state;
        switch (this.state) {
            case STATE_RESERVE: {
                if (!(user instanceof Patient)) {
                    break;
                }
                while (true) {
                    ReservationApplication firstScreen = new ReservationApplication();
                    Reservation reservation = firstScreen.getInputInformation(user.getIdentifier());

                    ConfirmInputInformation secondScreen = new ConfirmInputInformation();
                    boolean hasAccepted = secondScreen.getAccept(reservation);
                    if (!hasAccepted) {
                        break;
                    }

                    Dao dao = new Dao();
                    boolean success = dao.addReservation(reservation);
                    if (success) {
                        CompleteAcceptReservation thirdScreen = new CompleteAcceptReservation();
                        thirdScreen.show();
                        break;
                    } else {
                        System.out.println("Conflict reservation");
                    }
                }
                break;
            } case STATE_REMOVE: {
                if (!(user instanceof Patient)) {
                    break;
                }
                RemoveReservationList firstScreen = new RemoveReservationList();
                Reservation reservation = firstScreen.selectReservation(user.getIdentifier());

                ConfirmInputInformation secondScreen = new ConfirmInputInformation();
                boolean hasAccepted = secondScreen.getAccept(reservation);
                if (!hasAccepted) {
                    break;
                }

                Dao dao = new Dao();
                dao.removeReservation(reservation);

                CompleteRemoveReservation thirdScreen = new CompleteRemoveReservation();
                thirdScreen.show();
                break;
            } case STATE_QA: {
                QuestAndAnswer firstScreen = new QuestAndAnswer();
                firstScreen.show();
                break;
            }case STATE_CHECK: {
                InputConditionForSearch firstScreen = new InputConditionForSearch();
                Reservation condition = firstScreen.getInputInformation();

                Dao dao = new Dao();
                ArrayList<Reservation> reservations =
                        dao.getRecords(condition.getDate(), condition.getDrName());

                OutputReservationInformation secondScreen = new OutputReservationInformation();
                secondScreen.show(reservations);
                break;
            }default:
                System.out.println("Invalid state");
                break;
        }
    }
}
