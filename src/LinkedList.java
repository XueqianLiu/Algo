import java.util.List;

public class LinkedList {
    public static void main(String[] args){
        ListNode head = new ListNode(0);
        head.add(1);
        head.add(2);
        head.add(5);
        head.add(10);
        head.add(20);



        ListNode head2 = head;
        while(head2 != null){
            System.out.print(head2.value+" ");
            head2 = head2.next;
        }


        // reverse LinkedList
//        ListNode res = reverseLinkedList(head);
//        System.out.println("reverse the LinkedList: ");
//        while(res != null){
//            System.out.print(res.value+" ");
//            res = res.next;
//        }

        // find a middle point in the linkedlist
//        ListNode mid = findMidLinkedList(head);
//        System.out.println("The middle node of this LinkedList is: " + mid.value);

        // insert a sorted
        int target = -1;
//        ListNode newHead = insertNode(head, target);
//        System.out.println("After inserting element, The LinkedList is: ");
//        while( newHead != null){
//            System.out.print(newHead.value + " ");
//            newHead = newHead.next;
//        }

        // merge two sorted linked list
        ListNode headTwo = new ListNode(0);
        headTwo.add(3);
        headTwo.add(4);
        headTwo.add(8);
        headTwo.add(25);
//        System.out.println();
//        ListNode head3 = headTwo;
//        while(head3 != null){
//            System.out.print(head3.value+" ");
//            head3 = head3.next;
//        }
//        ListNode mergeList = mergeLinkedList(head, headTwo);
//
//        System.out.println('\n' +"After merge two linked lists, The LinkedList is: ");
//        while( mergeList != null){
//            System.out.print(mergeList.value + " ");
//            mergeList = mergeList.next;
//        }


        // reorder a linked list.
        // n1 -> n2 -> n3 -> n4 -> null
        // n1 -> n4 -> n2 -> n3 -> null
//        ListNode reorderlist = reorderLinkedList(head);
//        System.out.println( '\n' + "the result of reordering the LinkedList is： ");
//        while ( reorderlist != null){
//            System.out.print( reorderlist.value + " ");
//            reorderlist = reorderlist.next;
//        }


        // partition list
        // given a linked list and a target value x
        // partition it such that all node less than target x are listed before the nodes
        // larger than or equal to target value x.

        //build a linkedlist
        ListNode partition = new ListNode(10);
        partition.add(3);
        partition.add(8);
        partition.add(1);
        partition.add(9);
        partition.add(0);

        ListNode partition2 = partition;
        System.out.println();
        while(partition2 != null){
            System.out.print(partition2.value + " ");
            partition2 = partition2.next;
        }
        int target_value = 5;
//        ListNode resPartition = partitionLinkedList(partition, target_value);
//        System.out.println("Partition result: ");
//        while(resPartition != null) {
//            System.out.println(resPartition.value + " ");
//            resPartition = resPartition.next;
//        }


        // merge sort in linkedlist
        System.out.println('\n'+ "mergesort this linkedlist:");
        ListNode mergeRes = mergeSortLinkedList(partition);
        while(mergeRes != null){
            System.out.print(mergeRes.value +" ");
            mergeRes = mergeRes.next;
        }




    }

    // time complexity: O(n logn)
    //This is because the mergeSortLinkedList() function recursively divides the linked list
    // into two halves until each sublist has only one element, which takes log(n) time,
    // where 'n' is the number of elements in the original list. After that,
    // the mergeLinkedList() function is called log(n) times to merge the sublists back together,
    // each merge operation takes O(n) time in the worst case, so the total time complexity becomes O(nlogn).
    // space complexity: O(logn)
    //
    public static ListNode mergeSortLinkedList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;

        ListNode left = mergeSortLinkedList(head);
        ListNode right = mergeSortLinkedList(midNext);

        return mergeLinkedList(left ,right);

    }

    // time complexity: O(N)
    // space complexity: O(N)
    // step 1 allocate two new linkedlist head (small(dummy 1) and large(dummy 2))
    // step 2 Iterate over every single element in the list, and compare between
    // the current node's value with the target values
    //     case1: if current value < target value: add this node to tail of the first
    //     case2: otherwise, add the current node to the tail of the second
    //     case3: concatenate(连接) the tail of the first half to the head of the 2nd linked list

    public static ListNode partitionLinkedList(ListNode partition, int target){
        // corner case
        if (partition == null || partition.next == null) {
            return partition;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode dummy2 = new ListNode(0);
        ListNode largerNode = dummy2;

        while (partition != null) {
            if (partition.value < target){
                cur.next = partition;
                cur = cur.next;
                partition = partition.next;
            } else {
                largerNode.next = partition;
                largerNode = largerNode.next;
                partition = partition.next;
            }

        }
        largerNode.next= null;
        cur.next = dummy2.next;

        return dummy.next;

    }

    // time complexity : O(n)
    // space complexity: O(n)
    public static ListNode reorderLinkedList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid( head );
        ListNode firstHalf = head;
        ListNode secondHalf = reverse(mid.next);
        mid.next = null;   // important!!!!!: get tail of reverse mid linkedlist

        while (firstHalf != null && secondHalf != null) {
            cur.next = firstHalf;
            firstHalf = firstHalf.next;
            cur.next.next = secondHalf;
            secondHalf = secondHalf.next;
            cur = cur.next.next;
        }
        if (firstHalf != null) {
            cur.next = firstHalf;
        } else {
            cur.next = secondHalf;
        }

        while(cur.next != null){
            System.out.println(cur.value);
            cur = cur.next;
        }
        return  dummy.next;

    }
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode getMid(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode quick = head;
        ListNode slow = head;
        while (quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    // time complexity: O(m+n)
    // space complexity: O(1)
    public static ListNode mergeLinkedList(ListNode firHead, ListNode secHead){
        if (firHead == null){
            return secHead;
        }
        if (secHead == null){
            return firHead;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (firHead != null && secHead != null) {
            if (firHead.value <= secHead.value){
                cur.next = firHead;
                firHead = firHead.next;
            } else {
                cur.next = secHead;
                secHead = secHead.next;
            }
            cur = cur.next;
        }

        if (firHead != null) {
            cur.next = firHead;
        } else {
            cur.next = secHead;
        }
        return dummyHead.next;
    }

    // time complexity: O(N)
    // space complexity: O(1)
    //Initialize two pointers, called "slow" and "fast", to the first node in the list.
    //Move the slow pointer one step forward and the fast pointer two steps forward.
    // If there is a cycle in the list, the fast pointer will eventually
    // catch up to the slow pointer and both pointers will be pointing to the same node.
    //If the fast pointer reaches the end of the list (i.e., it encounters a null pointer),
    // then the list does not contain a cycle.
    //If a cycle is detected, we can return true to indicate that the list contains a cycle.

    public static boolean hasCycle(ListNode head){
         if (head == null || head.next == null) {
             return false;
         }
         ListNode slow = head;
         ListNode fast = head;
         while(fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
             if (slow == fast) {
                 return true;
             }
         }

         return false;
    }


    // insert a node in a sorted linked list
    // time complexity: O(N)
    // space complexity: O(1)
    public static ListNode insertNode(ListNode head, int target) {
        ListNode targetNode = new ListNode(target);
        if ( head == null || target < head.value){
            targetNode.next = head;
            return targetNode;
        }
        ListNode cur = head;
        while (cur.next != null && cur.next.value < target){
            cur = cur.next;
        }
        targetNode.next = cur.next;
        cur.next = targetNode;
        return head;
    }

    // reverse method
    // time complexity: O(N)
    // space complexity: O(1)
    public static ListNode reverseLinkedList(ListNode head){
        //Lterative way

//        ListNode prev = null;
//        while(head != null){
//            ListNode next = head.next;
//            head.next = prev;
//            prev = head;
//            head = next;
//        }
//        return prev;

        // recursive way
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // find middle point in the linked list
    // time complexity: O(N)
    // space: O(1)
    public static ListNode findMidLinkedList(ListNode head){
        if (head == null ||  head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }




    }

