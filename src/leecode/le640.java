package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/10 9:10
 * @Description TODO
 */
public class le640 {

    public String solveEquation(String equation) {
        char[] chars = equation.toCharArray();
        int Xnum = 0;
        int lAll = 0;
        boolean fu = false;
        boolean left = true;
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {

            switch (chars[i]) {
                case '-':
                    if (sbd.length() > 0) {
                        if (left) {
                            if (fu) {
                                lAll += Integer.valueOf(sbd.toString());
                            } else {
                                lAll -= Integer.valueOf(sbd.toString());
                            }
                        } else {
                            if (fu) {
                                lAll -= Integer.valueOf(sbd.toString());
                            } else {
                                lAll += Integer.valueOf(sbd.toString());
                            }
                        }

                    }
                    sbd = new StringBuilder();
                    fu = true;
                    break;
                case '+':

                    if (sbd.length() > 0) {
                        if (left) {
                            if (fu) {
                                lAll += Integer.valueOf(sbd.toString());
                            } else {
                                lAll -= Integer.valueOf(sbd.toString());
                            }
                        } else {
                            if (fu) {
                                lAll -= Integer.valueOf(sbd.toString());
                            } else {
                                lAll += Integer.valueOf(sbd.toString());
                            }
                        }

                    }
                    sbd = new StringBuilder();
                    fu = false;
                    break;
                case '=':
                    if (sbd.length() > 0) {
                        if (left) {
                            if (fu) {
                                lAll += Integer.valueOf(sbd.toString());
                            } else {
                                lAll -= Integer.valueOf(sbd.toString());
                            }
                        } else {
                            if (fu) {
                                lAll -= Integer.valueOf(sbd.toString());
                            } else {
                                lAll += Integer.valueOf(sbd.toString());
                            }
                        }

                    }
                    sbd = new StringBuilder();
                    fu = false;
                    left = false;
                    break;
                case 'x':
                    if (left) {
                        if (fu) {
                            Xnum -= sbd.length() == 0 ? 1 : Integer.valueOf(sbd.toString());
                        } else {
                            Xnum += sbd.length() == 0 ? 1 : Integer.valueOf(sbd.toString());
                        }
                    } else {
                        if (fu) {
                            Xnum += sbd.length() == 0 ? 1 : Integer.valueOf(sbd.toString());
                        } else {
                            Xnum -= sbd.length() == 0 ? 1 : Integer.valueOf(sbd.toString());
                        }
                    }
                    sbd = new StringBuilder();
                    break;
                default:
                    sbd.append(chars[i]);
            }
        }
        if (sbd.length() > 0) {
            if (left) {
                if (fu) {
                    lAll += Integer.valueOf(sbd.toString());
                } else {
                    lAll -= Integer.valueOf(sbd.toString());
                }
            } else {
                if (fu) {
                    lAll -= Integer.valueOf(sbd.toString());
                } else {
                    lAll += Integer.valueOf(sbd.toString());
                }
            }

        }
        if (Xnum == 0) {
            if (lAll == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            if (lAll == 0) {
                return "x=0";
            } else {
                return "x=" + (lAll / Xnum);
            }
        }
    }


    @Test
    public void t() {
        System.out.println(solveEquation("x+5-3+x=6+x-2"));
    }
}
