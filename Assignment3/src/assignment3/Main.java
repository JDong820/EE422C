/* Nishant Raman ()
 * Joshua Dong (jid295)
 *
 * Xavier Salazar
 * section 16005
 */

package assignment3;


class Main {
    public static void main(String[] args) {
        final Mastermind mastermind;
        boolean debugMode = false;
        GameMode mode = GameMode.JOPTIONPANEL;

        for (String param: args) {
            if (param.equals("--debug")) {
                debugMode = true;
            }
            if (param.equals("--console")) {
                mode = GameMode.CONSOLE;
            }
        }
        mastermind = new Mastermind(debugMode, mode);
        mastermind.runGame();
    }
}
