package utils;

public class LinkedList
{
    private Node head;
    public class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    public void insertInOrder(Node new_node)
    {
        Node current;
        if (head == null || head.data >= new_node.data)
        {
            new_node.next = head;
            head = new_node;
        }
        else {
            current = head;

            while (current.next != null &&
                    current.next.data < new_node.data)
                current = current.next;

            new_node.next = current.next;
            current.next = new_node;
        }
    }
    public Node newNode(int data)
    {
        Node x;
        x = new Node(data);
        return x;
    }

    public int getFromList() {
        if(head == null)
            return -1;
        else {
            int number = head.data;
            head = head.next;
            return number;
        }
    }

    public void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}