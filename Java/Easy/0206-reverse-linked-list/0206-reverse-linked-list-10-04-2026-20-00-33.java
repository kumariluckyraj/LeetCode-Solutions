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
    public ListNode reverseList(ListNode head) {
        
  ArrayList<Integer> lst = new ArrayList<>();
  ListNode temp = head;
  while(temp != null){
    lst.add(temp.val);
    temp = temp.next;
  }
    int i=0;
    int j = lst.size()-1;
    while(i<=j){
         int num = lst.get(i);
            lst.set(i, lst.get(j));
            lst.set(j,num);
            i++;
            j--;
    }
      
    ListNode newhead= null;
    ListNode curr = null;
    for(int k=0; k<lst.size(); k++){
        ListNode newnode = new ListNode(lst.get(k));
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