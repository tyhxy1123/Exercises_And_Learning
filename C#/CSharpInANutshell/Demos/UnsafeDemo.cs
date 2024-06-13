using System;
namespace CSharpInANutshell.Demos
{

    public struct UnsafeTest
    {
        int x;
        public unsafe static void Run()
        {
            UnsafeTest test = new UnsafeTest();
            UnsafeTest* p = &test;
            p->x = 9;
            Console.WriteLine(test.x);
        }
    }
	public class UnsafeDemo
	{
		int x;
		public static void Run()
        {
			UnsafeDemo dm = new UnsafeDemo();
            unsafe
            {
				fixed(int* p = &dm.x)
                {
                    *p = 9;
                }
                Console.WriteLine(dm.x);
            }
        }
	}
}

