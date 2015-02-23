/* Nishant Raman ()
 * Joshua Dong (jid295)
 *
 * Xavier Salazar
 * section 16005
 */

package assignment3;

class Main {
    public static void main(String[] args) {
        Mastermind mastermind = null;
        if (args.length == 1) {
            if (args[0].equals("debug"))
                mastermind = new Mastermind(true);
        } else {
            mastermind = new Mastermind(false);
        }
        mastermind.runGame();
    }
}
