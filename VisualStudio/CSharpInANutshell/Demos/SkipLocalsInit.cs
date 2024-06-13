using System;
using System.Runtime.CompilerServices;

namespace CSharpInANutshell.Demos
{
	public class SkipLocalsInit
	{
		[SkipLocalsInit]
		unsafe void Foo()
        {
			int local;
			int* ptr = &local;
			Console.WriteLine(*ptr);

			int* a = stackalloc int[100];
			for(int i = 0; i < 100; i++)
            {
                Console.WriteLine(a[i]);
            }

		}

		[SkipLocalsInit]
		void Bar()
        {
			Span<int> a = stackalloc int[100];
			foreach(int n in a)
            {
                Console.WriteLine(n);
            }
        }

		public static void Run()
        {
			//new SkipLocalsInit().Foo();
            Console.WriteLine();
			new SkipLocalsInit().Bar();

        }
	}
}

