public class Q1155_NumberofDiceRollsWithTargetSum {
public static void main(String[] args) {
    var result =  new Q1155_NumberofDiceRollsWithTargetSum().new Solution().numRollsToTarget(0, 0, 0);
}


class Solution {
    int target = 8 ;
    int count = 0;
    int sides = 6 ;
    public int numRollsToTarget(int n, int k, int target) {
        this.target = target;
        this.sides = k;
        // 2 dies , 6 side each , target 8;
        // Start with minimum value on each dies all dies must be rolled
        helper(1,1,2);
        return count;
    }

    public void helper(int die1, int die2, int currentsum){
        System.out.println(die1 + "+" + die2 + " = " +  currentsum);
        if (currentsum == target){
            count++;
            System.out.println("target = currentsum");
            return;
        }else if (currentsum > target){
            return;
        }
        if  (die1<sides)
            helper(die1+1,die2,currentsum+1);
       
        if  (die2<sides)
            helper(die1,die2+1,currentsum+1);
    }


   
}
}
