class AddTwoListNodeNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int nextval = 0;
        ListNode prev = new ListNode(0);
        ListNode curr = new ListNode(0);
        while(l1 != null || l2 != null) {

            curr.next = prev;
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = nextval + x + y;
            nextval = sum / 10;
            curr.val = sum % 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            prev = curr;
        }
        if (nextval > 0) {
            curr.next = new ListNode(nextval);
        }
        return curr;
    }

    public static void main(String args[]) {
        ListNode listNode11 = new ListNode(3);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(2);

        listNode12.next = listNode13;
        listNode11.next = listNode12;

        ListNode listNode21 = new ListNode(4);
        ListNode listNode22 = new ListNode(6);
        ListNode listNode23 = new ListNode(5);

        listNode22.next = listNode23;
        listNode21.next = listNode22;

        final AddTwoListNodeNumbers addTwoListNodeNumbers = new AddTwoListNodeNumbers();
        addTwoListNodeNumbers.addTwoNumbers(listNode11, listNode21);

    }
}