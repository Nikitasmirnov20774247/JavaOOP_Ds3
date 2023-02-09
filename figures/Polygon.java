package JavaOOP_Ds3.figures;

public abstract class Polygon extends Figure implements Perimeter
{
    protected double[] sides;

    public Polygon(double[] sides)
    {
        this.sides = sides;
    }

    public Polygon()
    {
        this.sides = null;
    }

    public double getPerimeter()
    {
        double result = 0;
        for (double side : sides)
        {
            result += side;
        }
        return result;
    }
}