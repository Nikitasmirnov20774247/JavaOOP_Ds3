package JavaOOP_Ds3;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import JavaOOP_Ds3.figures.*;

class CollectionFigures
{
    public static double getPerimeters(List<Figure> figures)
    {
        double perimeter = 0;
        for (Figure figure : figures)
        {
            if (figure instanceof Perimeter)
            {
                perimeter += figure.getPerimeter();
            }
        }
        return perimeter;
    }

    public static double getAreas(List<Figure> figures)
    {
        double area = 0;
        for (Figure figure : figures)
        {
            area += figure.getArea();
        }
        return area;
    }

    public static void showFigure(List<Figure> figures)
    {
        int count = 1;
        System.out.println();
        for (Figure figure : figures)
        {
            System.out.printf("%d. ", count);
            System.out.println(figure);
            count++;
        }
    }

    public static void showInfoFigure (List<Figure> figures)
    {
        System.out.printf("\n* Периметр всех фигур = %.2f\n", getPerimeters(figures));
        System.out.printf("* Площадь всех фигур = %.2f\n", getAreas(figures));
    }

    public static void sortFigure(List<Figure> figures)
    {
        Collections.sort(figures);
        showFigure(figures);
    }

    public static void replaceFigure(List<Figure> figures, Scanner iScanner)
    {
        System.out.print("\nМеню изменения фигур");
        showFigure(figures);
        System.out.print("Введите номер фигуры, чтобы изменить её: ");
        try
        {
            int size = figures.size()+1;
            int choice = iScanner.nextInt();
            if (choice < size && choice > 0)
            {
                System.out.print("\nВыберите фигуру (на которую меняем)\n1. Круг\n2. Квадрат\n3. Треугольник\n4. Прямоугольник\nВведите номер фигуры: ");
                int newFigure = iScanner.nextInt();
                if (newFigure > 0 && newFigure < 5)
                {
                    if (newFigure == 1)
                    {
                        System.out.print("Введите радиус круга: ");
                        double radius = iScanner.nextDouble();
                        if (radius > 0)
                        {
                            figures.set(choice - 1, new Cicle(radius));
                            System.out.print("\n* Фигура изменена *\n");
                        }
                        else
                        {
                            System.out.print("\n!! Радиус не может быть отрицательным или равняться нулю !!\n");
                        }
                    }
                    if (newFigure == 2)
                    {
                        System.out.print("Введите длину сторон: ");
                        double sideSquare = iScanner.nextDouble();
                        if (sideSquare > 0)
                        {
                            figures.set(choice - 1, new Square(sideSquare, sideSquare));
                            System.out.print("\n* Фигура изменена *\n");
                        }
                        else
                        {
                            System.out.print("\n!! Длина не может быть отрицательной или равняться нулю !!\n");
                        }
                    } 
                    if (newFigure == 3)
                    {
                        System.out.print("Введите длину стороны 1: ");
                        double sideTriangle1 = iScanner.nextDouble();
                        System.out.print("Введите длину стороны 2: ");
                        double sideTriangle2 = iScanner.nextDouble();
                        System.out.print("Введите длину стороны 3: ");
                        double sideTriangle3 = iScanner.nextDouble();
                        if (sideTriangle1 > 0 && sideTriangle2 > 0 && sideTriangle3 > 0)
                        {
                            if (sideTriangle1 + sideTriangle2 >= sideTriangle3 && sideTriangle2 + sideTriangle3 >= sideTriangle1 && sideTriangle1 + sideTriangle3 >= sideTriangle2)
                            {
                                figures.set(choice - 1, new Triangle(sideTriangle1, sideTriangle2, sideTriangle3));
                                System.out.print("\n* Фигура изменена *\n");
                            }
                            else
                            {
                                System.out.print("\n!! Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей !!\n");
                            }
                        }
                        else
                        {
                            System.out.print("\n!! Длина не может быть отрицательной или равняться нулю !!\n");
                        }
                    } 
                    if (newFigure == 4)
                    {
                        System.out.print("Введите длину сторон a: ");
                        double sideRectangle1 = iScanner.nextDouble();
                        System.out.print("Введите длину сторон b: ");
                        double sideRectangle2 = iScanner.nextDouble();
                        if (sideRectangle1 > 0 && sideRectangle2 > 0)
                        {
                            if (sideRectangle1 != sideRectangle2)
                            {
                                figures.set(choice - 1, new Rectangle(sideRectangle1, sideRectangle1, sideRectangle2, sideRectangle2));
                                System.out.print("\n* Фигура изменена *\n");
                            }
                            else
                            {
                                System.out.print("\n!! У прямоугольника только противоположные стороны равны !!\n");
                            }
                        }
                        else
                        {
                            System.out.print("\n!! Длина не может быть отрицательной или равняться нулю !!\n");
                        }
                    }
                }
                else
                {
                    System.out.printf("\n!! Фигуры: %s нет !!\n", newFigure);
                }
            }
            else
            {
                System.out.print("\n!! Введеного пункта меню нет !!\n");
            }
        }
        catch (Exception e)
        {
            System.out.print("\n!! Введено некорректное значение !!\n");
        }
    }

    public static void addNew(List<Figure> figures, Scanner iScanner) {
        try
        {
            System.out.print("\nВыберите фигуру (которую добавим)\n1. Круг\n2. Квадрат\n3. Треугольник\n4. Прямоугольник\nВведите номер фигуры: ");
            int newFigure = iScanner.nextInt();
            if (newFigure > 0 && newFigure < 5)
            {
                if (newFigure == 1)
                {
                    System.out.print("Введите радиус круга: ");
                    double radius = iScanner.nextDouble();
                    if (radius > 0)
                    {
                        figures.add(new Cicle(radius));
                        System.out.print("\n* Фигура добавлена *\n");
                    }
                    else
                    {
                        System.out.print("\n!! Радиус не может быть отрицательным или равняться нулю !!\n");
                    }
                } 
                if (newFigure == 2)
                {
                    System.out.print("Введите длину стороны: ");
                    double sideSquare = iScanner.nextDouble();
                    if (sideSquare > 0)
                    {
                        figures.add(new Square(sideSquare, sideSquare));
                        System.out.print("\n* Фигура добавлена *\n");
                    }
                    else
                    {
                        System.out.print("\n!! Длина не может быть отрицательной или равняться нулю !!\n");
                    }
                }
                if (newFigure == 3)
                {
                    System.out.print("Введите длину стороны 1: ");
                    double sideTriangle1 = iScanner.nextDouble();
                    System.out.print("Введите длину стороны 2: ");
                    double sideTriangle2 = iScanner.nextDouble();
                    System.out.print("Введите длину стороны 3: ");
                    double sideTriangle3 = iScanner.nextDouble();
                    if (sideTriangle1 > 0 && sideTriangle2 > 0 && sideTriangle3 > 0)
                    {
                        if (sideTriangle1 + sideTriangle2 >= sideTriangle3 && sideTriangle2 + sideTriangle3 >= sideTriangle1 && sideTriangle1 + sideTriangle3 >= sideTriangle2)
                        {
                            figures.add(new Triangle(sideTriangle1, sideTriangle2, sideTriangle3));
                            System.out.print("\n* Фигура добавлена *\n");
                        }
                        else
                        {
                            System.out.print("\n!! Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей !!\n");
                        }
                    }
                    else
                    {
                        System.out.print("\n!! Длина не может быть отрицательной или равняться нулю !!\n");
                    }
                } 
                if (newFigure == 4)
                {
                    System.out.print("Введите длину сторон a: ");
                    double sideRectangle1 = iScanner.nextDouble();
                    System.out.print("Введите длину сторон b: ");
                    double sideRectangle2 = iScanner.nextDouble();
                    if (sideRectangle1 > 0 && sideRectangle2 > 0 )
                    {
                        if (sideRectangle1 != sideRectangle2)
                        {
                            figures.add(new Rectangle(sideRectangle1, sideRectangle1, sideRectangle2, sideRectangle2));
                            System.out.print("\n* Фигура добавлена *\n");
                        }
                        else
                        {
                            System.out.print("\n!! У прямоугольника только противоположные стороны равны !!\n");
                        }
                    }
                    else
                    {
                        System.out.print("\n!! Длина не может быть отрицательной или равняться нулю !!\n");
                    }
                }
            }
            else
            {
                System.out.printf("\n!! Фигуры: %s нет !!\n", newFigure);
            }
        } 
        catch (Exception e)
        {
            System.out.print("\n!! Введено некорректное значение !!\n");
        }
    }

    public static void deleteFigure(List<Figure> figures, Scanner iScanner)
    {
        showFigure(figures);
        System.out.print("\nВведите номер фигуры, которую вы хотите удалить: ");
        try
        {
            int num = iScanner.nextInt(); 
            figures.remove(num - 1);
            System.out.printf("\nФигура: %s \n* удалена *\n", num);
        } 
        catch (Exception e)
        {
            System.out.printf("\n!! Фигура не найдена (введено некорректное значение) !!\n");
        }
    }
}
