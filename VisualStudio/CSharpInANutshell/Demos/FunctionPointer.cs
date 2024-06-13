using System;
namespace CSharpInANutshell.Demos
{
	public class FunctionPointer
	{
        static int GetLength(string s) => s.Length;
        public static void Run()
        {
            unsafe
            {
                delegate*<string, int> functionPointer = &GetLength;
                int len = functionPointer("Hello World!");
                Console.WriteLine(len);
                var point2 = (delegate*<string, decimal>)(IntPtr)functionPointer;
                Console.WriteLine(point2 ("Hello, unsafe world!"));
            }
        }
    }
}

