package JavaOOP_Ds3.figures;

public abstract class Figure implements Comparable<Figure>
{
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public int compareTo(Figure o)
    {
        if (this.getArea() > o.getArea())
            return 1;
        else if (this.getArea() < o.getArea())
            return -1;
        else
            return 0;
    }
}