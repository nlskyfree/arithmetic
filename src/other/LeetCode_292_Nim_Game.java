package other;

/**
 * 题目：Nim Game
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 * Example:
 * Input: 4
 * Output: false 
 * Explanation: If there are 4 stones in the heap, then you will never win the game;
             No matter 1, 2, or 3 stones you remove, the last stone will always be 
             removed by your friend.
 * 思路：为1,2,3时候能一次拿完，为4的时候必输，因为你拿任意个，剩下的对手都能一次拿完
 *       为5,6,7时候能保证对手为4，必赢，为8的时候，对手能保证你一定为4，必输。同理类推，只要石头数目不为4的倍数，则必赢
 * @author 倪路
 */
public class LeetCode_292_Nim_Game {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
