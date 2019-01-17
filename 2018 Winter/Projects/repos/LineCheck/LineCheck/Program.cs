using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LineCheck
{
    class GeometryObject
    {
        private double XAxis;
        private double YAxis;
        public void MoveTo(double x, double y)
        {
            XAxis = x;
            YAxis = y;
        }
    }

    public class Point : GeometryObject
    {
        public double x, y;
        public Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }

        public Point( Point a)
        {
            this.x = a.x;
            this.y = a.y;

        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            // The code provided will print ‘Hello World’ to the console.
            // Press Ctrl+F5 (or go to Debug > Start Without Debugging) to run your app.
            //Console.WriteLine("Hello World!");
            //Console.ReadKey();

            // Go to http://aka.ms/dotnet-get-started-console to continue learning how to build a console app! 

            Point P1 = new Point(0.0, 0.0);
            Point P2 = new Point(10.0, 10.0);

            Console.WriteLine("Enter new coordinats for P1 x");
            double x = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Enter new coordinats for P1 y");
            double y = Convert.ToDouble(Console.ReadLine());

            P1.MoveTo



        }
    }
}
