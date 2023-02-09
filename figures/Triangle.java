package JavaOOP_Ds3.figures;

public class Triangle extends Polygon
{
    public Triangle(double side1, double side2, double side3)
    {
        super(new double[]{side1, side2, side3});
    }

    @Override
    public double getArea()
    {
        double p = this.getPerimeter() / 2;
        double side1 = this.sides[0];
        double side2 = this.sides[1];
        double side3 = this.sides[2];
        double square = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        return square;
    }  
    
    @Override
    public String toString()
    {
        return String.format("Треугольник. Сторона 1: %.2f, Сторона 2: %.2f, Сторона 3: %.2f, Периметр: %.2f, Площадь: %.2f", 
        this.sides[0], this.sides[1], this.sides[2], this.getPerimeter(), this.getArea());
    }
}