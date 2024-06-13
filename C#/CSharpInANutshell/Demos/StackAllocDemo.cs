using System;
namespace CSharpInANutshell.Demos
{
	public class StackAllocDemo
	{
		public StackAllocDemo()
		{
		}

		public unsafe static void Run()
        {
			int* a = stackalloc int[10];
			for(int i = 0; i < 10; i++)
            {
                Console.WriteLine(a[i]);
            }
            Console.WriteLine();
			Span<int> b = stackalloc int[10];
			for(int i = 0; i < 10; ++i)
            {
                Console.WriteLine(b[i]);
            }
        }
	}
}

