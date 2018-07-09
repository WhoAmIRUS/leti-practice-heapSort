package heapsort.model;

public class Node  implements Cloneable{
    private int value;
    private Point position;
    private boolean color = false;

    private Node(int value, Point position) {
        this.value = value;
        this.position = position;
    }

    static Node restore(int value, int x, int y){
        Point position = new Point(x,y);
        return new Node(value, position);
    }

    public int getValue() {
        return value;
    }

    public Point getPosition() {
        return position;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getClr () { return color; }

    public void setClr (boolean color) { this.color = color; }

    @Override
    public Node clone(){
        try {
            return (Node)super.clone();
        } catch (CloneNotSupportedException e){
            System.out.println("Error");
            return null;
        }

    }
}
