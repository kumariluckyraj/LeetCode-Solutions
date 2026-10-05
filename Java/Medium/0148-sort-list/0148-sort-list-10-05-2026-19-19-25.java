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
    public ListNode sortList(ListNode head) {
        ListNode temp = head;
        ArrayList<Integer> lst = new ArrayList<>();
        while(temp != null){
            lst.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(lst);
        ListNode curr = null;
        ListNode newhead = null;
        for(int i=0; i<lst.size(); i++){
            ListNode newnode = new ListNode(lst.get(i));
            if(newhead==null){
                newhead=newnode;
                curr=newnode;
            }else{
                curr.next = newnode;
                curr = curr.next;
            }
        }
        return newhead;
    }
}