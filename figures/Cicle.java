package JavaOOP_Ds3.figures;

public class Cicle extends Figure implements CircleLengther
{
    protected double radius;

    public Cicle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double getPerimeter()
    {
        return 0;
    }

    @Override
    public double CircleLength()
    {
        return 2 * 3.1415926535 * this.radius;
    }

    @Override
    public double getArea()
    {
        return 3.1415926535 * this.radius * this.radius;
    }

    @Override
    public String toString()
    {
        return String.format("Круг. Радиус: %.2f, Длина окружности: %.2f, Площадь: %.2f", 
        this.radius, this.CircleLength(), this.getArea());
    }
}