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
        boolean swingMode = true;

        for (String param: args) {
            if (param.equals("--debug")) {
                debugMode = true;
            }
            if (param.equals("--console")) {
                swingMode = false;
            }
        }
        mastermind = new Mastermind(debugMode, swingMode);
        mastermind.runGame();
    }
}
