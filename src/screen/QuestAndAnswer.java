package screen;

import java.util.Scanner;

/**
 * Q&amp;A画面クラス<br>
 * 一般的な質問を列挙する．
 */
public class QuestAndAnswer {

    /**
     * 質問群を列挙する．(簡易化するため質問は1つのみ)
     */
    public void show() {
        System.out.println("Something of questions");
        System.out.println("0. Example question");

        Scanner scanner = new Scanner(System.in);
        int input;
        while(true) {
            System.out.println("Input index (Type is Number)");
            String strIndex = scanner.next();
            try {
                input = Integer.parseInt(strIndex);
                if (input == 0)
                    break;
                else
                    System.out.println("Invalid range: [ " + 0 + " ]\n");
            }catch (NumberFormatException e) {
                System.out.println("Invalid input (Type is incorrect)");
            }
        }

        DetailQuestAndAnswer nextScreen = new DetailQuestAndAnswer();
        nextScreen.show();
    }
}
