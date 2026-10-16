/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque <Integer> stack = new ArrayDeque<>();

        for(ListNode curr = head; curr!=null; curr = curr.next){
            stack.push(curr.val);
        }
        for(ListNode curr = head; curr != null; curr = curr.next){
            if(stack.pop() != curr.val){
                return false;
            }
        }

        return true;

    }
}