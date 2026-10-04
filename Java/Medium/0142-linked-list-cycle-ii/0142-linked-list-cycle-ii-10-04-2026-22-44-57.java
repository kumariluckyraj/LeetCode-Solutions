/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
ListNode slow = head;
ListNode fast = head;

while(fast != null && fast.next != null){
    slow = slow.next;
    fast = fast.next.next;
ListNode entry = head;
   if(slow == fast){
while(entry != slow){
    entry = entry.next;
    slow = slow.next;
}
return entry;
   }
   
}
return null;
    }
}