using Xunit;
using Xunit.Abstractions;
using System;
using System.IO;

namespace CSInANutShell
{

    public class LanguageTest
    {
        private readonly ITestOutputHelper output;

        public LanguageTest(ITestOutputHelper output)
        {
            this.output = output;
        }

        [Fact]
        public void Test1()
        {
            output.WriteLine("World!");
        }

        record Point
        {
            public int Id
            {
                get; init;
            }
            public string Name
            {
                get; init;
            }

            public Point(int id, string name)
            {
                Id = id;
                Name = name;
            }
        }

        [Fact]
        public void RecordDemo()
        {
            Point a = new Point(1, "张三");
            output.WriteLine(a.ToString());
            Point b = a with { Id = 2, Name = "李四" };
            output.WriteLine(b.ToString());

        }

        record Point2
        {
            private int _x, _y;
            private double? _distance;
            public Point2(int x, int y) => (X, Y) = (x, y);
            public int X
            {
                get => _x;
                init { _x = value; _distance = null; }
            }
            public int Y
            {
                get => _y;
                init
                {
                    _y = value;
                    _distance = null;
                }
            }

            public double DistanceFromOrigin
            {
                get
                {
                    if (_distance == null)
                    {
                        _distance = Math.Sqrt(X * X + Y * Y);
                    }
                    return _distance.Value;
                }
            }
        }

        [Fact]
        public void LazyEval()
        {
            Point2 p = new Point2(2, 2);
            output.WriteLine($"distance: {p.DistanceFromOrigin}");
            output.WriteLine($"distance: {p.DistanceFromOrigin}");
            output.WriteLine($"distance: {p.DistanceFromOrigin}");
            Point2 p1 = p with { X = 3, Y = 3 };
            output.WriteLine($"mutated distance: {p1.DistanceFromOrigin}");
            output.WriteLine($"mutated distance: {p1.DistanceFromOrigin}");
            output.WriteLine($"mutated distance: {p1.DistanceFromOrigin}");
        }

        record Point3(int X, int Y)
        {
            private double? _distance;

            public double Distance
            {
                get => _distance ??= Math.Sqrt(X * X + Y * Y);
            }


            // Without this constructor problem happens
            protected Point3(Point3 other) => (X, Y) = other;
        }

        [Fact]
        public void LazyEval2()
        {
            Point3 p31 = new Point3(2, 3);
            output.WriteLine($"distance: {p31.Distance}");
            output.WriteLine($"distance: {p31.Distance}");
            output.WriteLine($"distance: {p31.Distance}");
            Point3 p32 = p31 with { X = 3, Y = 4 };
            output.WriteLine($"mutated distance: {p32.Distance}");
            output.WriteLine($"mutated distance: {p32.Distance}");
            output.WriteLine($"mutated distance: {p32.Distance}");
        }

        record Person(string Name)
        {
            private string _name = Name;
            public string Name
            {
                get => _name;
                init
                {
                    _name = Name ?? throw new ArgumentNullException("Name");
                }
            }
        }

        [Fact]
        public void PrimaryConstructor()
        {
            var p = new Person("Olive");
            output.WriteLine(p.Name);
        }

        [Fact]
        public void PatternDemo()
        {
            Object obj = "I am a string";
            if (obj is string)
            {
                output.WriteLine(((string)obj).ToString());
            }
        }

        [Fact]
        public void PatternDemo2()
        {
            Object obj = "I am a string";
            if (obj is string s)
            {
                output.WriteLine(s);
            }
        }

        [Fact]
        public void PatternDemo3()
        {
            Object obj = "four";
            if (obj is string { Length: 4 })
            {
                output.WriteLine("String with length 4");
            }
        }

        public delegate bool IsJanetOrJohn(string name);

        [Fact]
        public void PatternsChain()
        {
            IsJanetOrJohn ijj = delegate (string name) { return name.ToUpper() is var upper && (upper == "JANET" || upper == "JOHN"); };
            output.WriteLine($"Janet is {ijj("janet")}");

        }

        [Fact]
        public void PatternsChain2()
        {
            //Func<string, bool> JanetOrJohn = delegate (string name) { return false; };
            //Func<string, bool> JanetOrJohn = (string name) => name.ToUpper() is var upper && (upper == "JANET" || upper == "JOHN");
            Func<string, bool> JanetOrJohn = (string name) => name.ToUpper() is "JANET" or "JOHN";
            output.WriteLine($"janet is: {JanetOrJohn("janet")}");
            bool IsJanetOrJohn(string? name) => name?.ToUpper() is "JANET" or "JOHN";
            output.WriteLine($"john is: {IsJanetOrJohn("john")}");
            output.WriteLine($"{IsJanetOrJohn(null)}");
            bool IsLetter(char c) => c is >= 'a' and <= 'z' or >= 'A' and <= 'Z';
            output.WriteLine($"C is a letter: {IsLetter('C')}");

            Object obj = 12;
            if (obj is not string)
            {
                output.WriteLine($"obj is not a string!");
            }
            else
            {
                output.WriteLine($"{obj}");
            }

            var tuple = (2, 3);
            output.WriteLine($"tuple equal is: {tuple is (2, 4)}");
        }

        [Fact]
        public void DynamicDemo()
        {
            dynamic x = "Hello World!";
            output.WriteLine($"{x}");
            x = 123;
            output.WriteLine($"{x}");
        }

        public struct Note
        {
            public double value;
            public Note(double semitonesFromA) { value = semitonesFromA; }
            public static Note operator +(Note x, int semitones) => new Note(x.value + semitones);

            public static implicit operator double(Note x) => 440 * Math.Pow(2, (double)x.value / 12);
            public static explicit operator Note(double x) => new Note(0.5 + 12 * (Math.Log(x / 440) / Math.Log(2)));
        }



        [Fact]
        public void OperatorOverload()
        {
            Note b = new Note(1);
            b += 2;
            output.WriteLine($"{b.value}");
        }



        [Fact]
        public void OperatorOverload2()
        {
            Note n = new Note(5);
            double x = n;
            output.WriteLine($"{x}");
            Note n1 = (Note)x;
            output.WriteLine($"{n1.value}");
        }

        class PointerTestModel
        {
            public int x;
        }

        [Fact]
        public void PointerTest()
        {
            var model = new PointerTestModel();
            unsafe
            {
                fixed(int* ptr = &model.x)
                {
                    *ptr = 42;
                }
                output.WriteLine($"{model.x}");
            }
        }
    }
}
