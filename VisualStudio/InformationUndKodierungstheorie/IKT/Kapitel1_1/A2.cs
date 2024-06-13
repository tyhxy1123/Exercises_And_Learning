using System;
namespace IKT.Kapitel1_1
{
	public class A2
	{
		public static void Run()
		{
			double[] p = { 0.1,0.2,0.3,0.4,0.5 };
			var Entropie = p.Sum(x => - x * Math.Log2(x));
            Console.WriteLine($"Entropie: {Entropie}");
		}
	}
}

