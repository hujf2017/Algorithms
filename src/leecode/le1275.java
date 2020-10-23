package leecode;

/**
 * @author Hujf
 * @title: le1275
 * @date 2020/10/8 0008下午 5:56
 * @description: TODO
 */
public class le1275 {
    int pan[][]=new int[3][3];
    public String tictactoe(int[][] moves) {

        for(int i=0;i<moves.length;i++){
            int k[] = moves[i];
            //A 0  B 1
            int s = i%2+1;
            pan[k[0]] [k[1]] = s;
            if(k[0]==0){
                if(pan[k[0]+1] [k[1]]==s&&pan[k[0]+2] [k[1]]==s){
                    return s==1?"A":"B";
                }
            }else if(k[0]==1){
                if(pan[k[0]+1] [k[1]]==s&&pan[k[0]-1] [k[1]]==s){
                    return s==1?"A":"B";
                }
            }else{
                if(pan[k[0]-1] [k[1]]==s&&pan[k[0]-2] [k[1]]==s){
                    return s==1?"A":"B";
                }
            }

            if(k[1]==0){
                if(pan[k[0]] [k[1]+1]==s&&pan[k[0]] [k[1]+2]==s){
                    return s==1?"A":"B";
                }
            }else if(k[1]==1){
                if(pan[k[0]] [k[1]+1]==s&&pan[k[0]] [k[1]-1]==s){
                    return s==1?"A":"B";
                }
            }else{
                if(pan[k[0]] [k[1]-1]==s&&pan[k[0]] [k[1]-2]==s){
                    return s==1?"A":"B";
                }
            }
        }

        if(pan[1][1]==1){
            if(pan[0][2]==1&&pan[2][0]==1){
                return "B";
            }
            if(pan[0][0]==1&&pan[2][2]==1){
                return "B";
            }
        }else{
            if(pan[0][2]==0&&pan[2][0]==0){
                return "A";
            }
            if(pan[0][0]==0&&pan[2][2]==0){
                return "A";
            }
        }

        if(moves.length<9){
            return "Pending";
        }else{
            return "Draw";
        }

    }
}
