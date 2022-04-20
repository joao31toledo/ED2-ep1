// implementação do livro do Sedgewick;

public class Pilha<Item> {
    private Node first; // topo da stack
    private int N; // número de itens

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node antigo = first;
        first = new Node();
        first.item = item;
        first.next = antigo;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

}