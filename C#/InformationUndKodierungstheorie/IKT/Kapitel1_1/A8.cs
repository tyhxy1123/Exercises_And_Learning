using System;
namespace IKT.Kapitel1_1
{
	public class A8
	{
		double[] p = new[] { 0.5, 0.2, 0.1, 0.1, 0.05, 0.05 };
		double? _Hm = null;
		double? _Streuung = null;
		double? _StandardAbweichung = null;

		public double Hm {
			get {
				if (_Hm == null)
				{
					_Hm = p.Sum(x => -x * Math.Log2(x));
				}
				return (double)_Hm;
			}
		}

		public double StandardAbweichung
        {
			get
            {
				return Math.Sqrt(Streuung);
            }
        }

		public double Streuung
        {
			get {
				if (_Streuung == null)
				{
					_Streuung = p.Sum(x => x * Math.Log2(1 / x) * Math.Log2(1 / x)) - Hm * Hm;
				}
				return (double)_Streuung;
			}
        }

		public static void Run()
        {
			A8 a = new A8();
            Console.WriteLine($"Hm: {a.Hm}");
            Console.WriteLine($"Streuung: {a.Streuung}");
            Console.WriteLine($"Streuung: {a.StandardAbweichung}");

        }
	}
}

