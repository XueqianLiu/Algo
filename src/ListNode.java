import javax.swing.tree.TreeNode;

  class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
      this.value = value;
      next = null;
    }

    public void add(int newdata){
      ListNode newNode = new ListNode(newdata);
      if (this.next == null) {
        this.next = newNode;
      }
      else {
        this.next.add(newdata);
      }
    }
  }
