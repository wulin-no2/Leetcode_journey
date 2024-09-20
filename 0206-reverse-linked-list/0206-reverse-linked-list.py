# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # 2 pointers
        curr = head
        pre = None
        # traverse
        while curr!=None:
            temp = curr.next
            curr.next = pre
            pre = curr
            curr = temp
        return pre
            