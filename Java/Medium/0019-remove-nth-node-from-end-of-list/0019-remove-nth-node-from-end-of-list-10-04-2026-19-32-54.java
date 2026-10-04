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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode temp = head;
      int len =0;
      while(temp != null){
        temp = temp.next;
        len++;
      }
      if(len == n){
        return head.next;
      }

      ListNode prev = get( head, len-n-1);
      prev.next = prev.next.next;
      return head;
    }
      
   public ListNode get(ListNode node, int n){
    ListNode temp = node;
    for(int i=0; i<n; i++){
        temp = temp.next;
    }
    return temp;
   }
}