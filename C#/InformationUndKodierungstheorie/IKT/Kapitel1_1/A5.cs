using System;
namespace IKT.Kapitel1_1
{
	public class A5
	{
		public static void Run()
        {
			double[] H = { 0.5, 0.25, 0.125, 0.0625, 0.0625 };
            Console.WriteLine($"Hm: {H.Sum(x => - x * Math.Log2(x))} pro Bildpunkt");
			double[] H2 = new double[5];
			for (var i = 0; i < H2.Length; i++) H2[i] = 0.2;
            Console.WriteLine($"Hm2: {H2.Sum(x => - x * Math.Log2(x))} pro Bildpunkt");
        }
	}
}

