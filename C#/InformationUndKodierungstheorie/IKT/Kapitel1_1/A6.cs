using System;
namespace IKT.Kapitel1_1
{
	public class A6
	{
		static double[] p = { 0.47, 0.25, 0.13, 0.07, 0.04, 0.02, 0.02 };
		static double[] p2 = new double[p.Length*16];

		static double a()
        {
			return p.Sum(x => -x * Math.Log2(x));
        }

		static double b()
        {
			for(var j = 0; j < p.Length; j++)
            {
				for(var i = 0; i < 16; i++)
                {
                    p2[j * 16 + i] = p[j] / 16;
                }
            }

            return p2.Sum(x => -x * Math.Log2(x));
        }

		public static void Run()
        {
            Console.WriteLine($"Hm: {b()}");
        }
	}
}

