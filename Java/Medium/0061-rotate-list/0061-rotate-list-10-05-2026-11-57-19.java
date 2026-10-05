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
    public ListNode rotateRight(ListNode head, int k) {
        ArrayList<Integer> lst = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(head == null || head.next == null){
    return head;
}
        ListNode temp = head;
        while(temp != null){
            lst.add(temp.val);
            temp = temp.next;
        }
        k = k %lst.size();
int n = lst.size();
for(int i=0; i<n; i++){
    ans.add(0);
}
        for(int i=0; i<lst.size(); i++){
            int idx = (i+k)%n;
            ans.set(idx,lst.get(i));
        }
        ListNode curr= null;
        ListNode newhead = null;
        for(int i=0; i<n; i++){
            ListNode newnode =new ListNode(ans.get(i));
            if(newhead==null){
                newhead = newnode;
                curr = newnode;
            }else{
                curr.next = newnode;
                curr = curr.next;
            }
        }
        return newhead;
    }
}