/**
 * @author wuting
 * @date 2023/03/01
 */
public class TestLink {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.add(2);
        listNode.add(3);
        listNode.add(2);
        ListNode resultNode = reverseList(listNode);
        //ListNode resultNode = removeElements(listNode, 2);
        while (resultNode != null) {
            System.out.print(resultNode.val + " ");
            resultNode = resultNode.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;// 保存下一个节点
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void add(int newVal) {
            ListNode listNode = new ListNode(newVal);
            if (this.next == null) {
                this.next = listNode;
            } else {
                this.next.add(newVal);
            }
        }

    }

}
