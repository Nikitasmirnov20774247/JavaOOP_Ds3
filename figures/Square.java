package JavaOOP_Ds3.figures;

public class Square extends Rectangle
{
    public Square(double side, double sidecopy)
    {
        super(side, side, sidecopy, sidecopy);
    }

    @Override
    public String toString()
    {
        return String.format("Квадрат. Сторона: %.2f, Периметр: %.2f, Площадь: %.2f", 
        this.sides[0], this.getPerimeter(), this.getArea());
    }
}