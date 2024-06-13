using System;
namespace CSharpInANutshell.Demos
{
    public class ArrayDemo
    {
        public ArrayDemo()
        {
            
            
        }

        public void Run()
        {
            char[] arr = { 'a', 'b', 'c', 'd', 'e' };
            //显示倒数第二个元素
            //^0 equals length of the array
            Index first = 0;
            Index last = ^1;
            
            Console.WriteLine($"First element of arr is: {arr[first]}");
            Array.ForEach<char>(arr[2..], Console.Write);
            Console.WriteLine();
            Array.ForEach<char>(arr[..2], Console.Write);
            Console.WriteLine();
            Array.ForEach<char>(arr[^2..], Console.Write);
            Console.WriteLine();
            Array.ForEach<char>(arr[..^2], Console.Write);
            Console.WriteLine();
            Array.ForEach<char>(arr[2..3], Console.Write);
            Console.WriteLine();
        }
    }
}
