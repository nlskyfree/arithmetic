package other;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：Hand of Straights
 * Alice has a hand of cards, given as an array of integers.
 * 
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 * Return true if and only if she can.
 * Example 1:
 * 
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 * Example 2:
 * 
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 * Note:
 * 
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 * @author 倪路
 */
public class LeetCode_846_Hand_Of_Straights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            if (map.containsKey(hand[i])) {
                map.put(hand[i], map.get(hand[i]) + 1);
            } else {
                map.put(hand[i], 1);
            }
        }

        for (int i = 0; i < hand.length; i += W) {
            int min = findMin(map);
            for (int j = 0; j < W; j++) {
                if (map.containsKey(min) && map.get(min) != 0) {
                    map.put(min, map.get(min) - 1);
                    min++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public int findMin(Map<Integer, Integer> map) {
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0 && entry.getKey() < min) {
                min = entry.getKey();
            }
        }

        return min;
    }
}
