<<<<<<< HEAD
package pkg.game;

public class AlphabetCheck {
    /**
     * TableCheck which checks the correctness of the given coordinate point.
     * @param helper the given coordinate point, what we check.
     * @return {@code true}, if the coordinate is not a number.
     */
    public static boolean alphabetCheck(String helper){
        boolean fool=false;
        for (int i = 0; i < helper.length(); i++) {
            if(Character.isAlphabetic(helper.charAt(i))||!Character.isDigit(helper.charAt(i))) {
                fool = true;
            }else{
                if(helper.length()>2)
                    fool=true;
            }
        }
        return fool;
    }
}
=======
package pkg.game;

public class AlphabetCheck {
    /**
     * TableCheck which checks the correctness of the given coordinate point.
     * @param helper the given coordinate point, what we check.
     * @return {@code true}, if the coordinate is not a number.
     */
    public static boolean alphabetCheck(String helper){
        boolean fool=false;
        for (int i = 0; i < helper.length(); i++) {
            if(Character.isAlphabetic(helper.charAt(i))||!Character.isDigit(helper.charAt(i))) {
                fool = true;
            }else{
                if(helper.length()>2)
                    fool=true;
            }
        }
        return fool;
    }
}
>>>>>>> game/master
