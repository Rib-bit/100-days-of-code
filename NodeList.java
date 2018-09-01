package masterclass;

public interface NodeList {
    ListItem getRoot(); //head or root of the list. necessary starting node
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}
