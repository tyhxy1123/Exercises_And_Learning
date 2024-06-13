using System;
namespace CSharpInANutshell.Demos
{
    public class ParamsModifier
    {
        public ParamsModifier()
        {
        }

        private int Sum(params int[] ints)
        {
            int result = 0;
            foreach (var num in ints)
            {
                result += num;
            }
            return result;
        }

        private void FooOpt(int a=0, int b=1)
        {
            Console.WriteLine($"a: {a}, b: {b}");
        }

        public void Run()
        {
            Console.WriteLine($"sum of array is: {Sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)}");
            FooOpt(b:3, a:2);
        }
    }
}
