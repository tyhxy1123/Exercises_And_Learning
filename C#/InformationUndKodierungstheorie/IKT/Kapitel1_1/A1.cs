using System;
namespace IKT.Kapitel1_1
{
	public class A1
	{
		static void a()
        {
			double[] p = { 0.5, 0.2, 0.1, 0.1, 0.05, 0.05 };
			double Hm = p.Sum(x => - x * Math.Log2(x));
            Console.WriteLine($"Hm = {Hm}");
        }

		public static void Run()
        {
			a();
        }
	}
}

