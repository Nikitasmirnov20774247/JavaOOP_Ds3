package JavaOOP_Ds3.figures;

public class Rectangle extends Polygon
{
    public Rectangle(double length, double length2, double width, double width2)
    {
        super(new double[]{length, width, length, width});
    }

    @Override
    public double getArea()
    {
        return this.sides[0] * this.sides[1];
    }    

    @Override
    public String toString()
    {
        return String.format("Прямоугольник. Стороны a1, a2: %.2f, Стороны b1, b2: %.2f, Периметр: %.2f, Площадь: %.2f", 
        this.sides[0], this.sides[1], this.getPerimeter(), this.getArea());
    }
}