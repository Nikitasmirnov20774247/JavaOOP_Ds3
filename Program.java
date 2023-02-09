package JavaOOP_Ds3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import JavaOOP_Ds3.figures.*;

public class Program
{
    private static void showMenu(List<Figure> figures, Scanner iScanner)
    {
        try
        {
            System.out.print("\nГлавное меню фигур\n1. Показать информацию о всех фигурах\n2. Отсортировать фигуры по площади\n3. Изменить фигуру\n4. Добавить фигуру\n5. Удалить фигуру\n6. Выйти из меню\nВыберите пункт меню: ");
            iScanner = new Scanner(System.in);
            int choice = iScanner.nextInt();

            if (choice > 0 && choice < 7)
            {
                if (choice == 1)
                {
                    CollectionFigures.showFigure(figures);
                    CollectionFigures.showInfoFigure(figures);
                    showMenu(figures, iScanner);
                }
                if (choice == 2)
                {
                    CollectionFigures.sortFigure(figures);
                    showMenu(figures, iScanner);
                }
                if (choice == 3)
                {
                    CollectionFigures.replaceFigure(figures, iScanner);
                    showMenu(figures, iScanner);
                }
                if (choice == 4)
                {
                    CollectionFigures.addNew(figures, iScanner);
                    showMenu(figures, iScanner);
                }
                if (choice == 5)
                {
                    CollectionFigures.deleteFigure(figures, iScanner);
                    showMenu(figures, iScanner);
                }
                if (choice == 6)
                {
                    return;
                }
            }
            else
            {
                System.out.print("\n!! Введеного пункта меню нет !!\n");
                showMenu(figures, iScanner);
            }
        }
        catch (Exception e)
        {
            System.out.print("\n!! Введено не целое значение пункта меню !!\n");
            showMenu(figures, iScanner);
        }
    }

    public static void main(String[] args)
    {
        List<Figure> figures = new ArrayList<Figure>();
        Scanner iScanner = new Scanner(System.in);
        figures.add(new Cicle(87));
        figures.add(new Square(65, 65));
        figures.add(new Triangle(34, 29, 41));
        figures.add(new Rectangle(55, 55, 68, 68));
        showMenu(figures, iScanner);
        iScanner.close();
    }
}