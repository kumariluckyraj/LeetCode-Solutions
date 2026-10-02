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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first = list1;
        ListNode second = list2;
        ListNode th = new ListNode(-1);
        ListNode third = th;

        while(first != null && second != null){
            if(first.val < second.val){
                third.next = new ListNode(first.val);
                first = first.next;
            }else{
                third.next = new ListNode(second.val);
                second = second.next;
            }
            third = third.next;

        }

        while(first!=null){
            third.next = new ListNode(first.val);
            first=first.next;
            third = third.next;
        }

        while(second != null){
            third.next = new ListNode(second.val);
            second = second.next;
            third= third.next;
        }
        return th.next;
            }
}