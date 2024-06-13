using System;
using System.Collections.Generic;
using System.Text;
using System.Xml;
using Xunit;
using Xunit.Abstractions;


namespace CSharpInANutshell
{
    public class LanguageUnitTest
    {
        private readonly ITestOutputHelper output;

        public LanguageUnitTest(ITestOutputHelper testOutputHelper)
        {
            output = testOutputHelper;
        }
        
        [Fact]
        public void Nameof()
        {
            var s = "gogogo";
            output.WriteLine($"name of this is: {nameof(s)}");
        }

        class UpperClass
        {
            public string Name { set; get; }

            public virtual string PrintName()
            {
                return "This is Upper Class";
            }
        }

        class LowerClass : UpperClass
        {
            
            public sealed override string PrintName()
            {
                return "This is Lower Class";
            }
        }

        class LowestClass : LowerClass
        {
            public new string PrintName()
            {
                return base.PrintName() + " This is Lowest Class";
            }
        }

        [Fact]
        public void Casting()
        {
            var dc = new LowerClass();
            dc.Name = "Lower";
            var uc = dc as UpperClass;
            output.WriteLine($"{uc?.Name ?? "NULL"}");
            output.WriteLine($"Upper Class name is: {uc.PrintName()}");
            output.WriteLine($"Lower Class name is: {dc.PrintName()}");
            var lc = new LowestClass();
            output.WriteLine($"Lowest Class name is: {lc.PrintName()}");
        }

        [Fact]
        public void GetTypeAndTypeof()
        {
            String s1 = "String 1";
            String s2 = "String 2";
            int x = 1;
            object box = x;
            
            output.WriteLine($"String's type is: {typeof(String).Name}");
            output.WriteLine($"string's type is: {typeof(string)}");
            output.WriteLine($"s2's type is: {s2.GetType().Name} and it's fullname is: {s2.GetType().FullName}");
            output.WriteLine($"box's ToString is: {box}");
            
        }

        [Fact]
        public void GenericArrayForEach()
        {
            var arr = new[]{ "a","e","i","o","u"};
            Array.ForEach(arr, output.WriteLine);
        }

        delegate int Transformer(int x);

        int Square(int x) => x * x;

        int Cube(int x) => x * x * x;

        [Fact]
        public void DelegateDemo1()
        {
            int x = 2;
            Transformer t = Cube;
            output.WriteLine($"Delegated method result: x: {x} y: {t(x)}");
        }
        
        private void WriteProgressToConsole(int x)
        {
            output.WriteLine($"{x}% complete...");
        }

        private void WriteProgressToFile(int x)
        {
            var str = $"{x}% complete...";
            System.IO.File.WriteAllText("./progress.txt", str);
        }
        
        private delegate void ProgressReporter(int x);
        
        private void HardWork(ProgressReporter p)
        {
            for (var i = 1; i < 11; i++)
            {
                p(i * 10);
                System.Threading.Thread.Sleep(100);
            }
        }

        [Fact]
        public void DelegateDemo2()
        {
            ProgressReporter p = WriteProgressToConsole;
            p += WriteProgressToFile;
            HardWork(p);
        }

        private delegate T GenericTransformer<T>(T t);

        private void Transform<T>(T[] values, GenericTransformer<T> t)
        {
            for (var i = 0; i < values.Length; i++)
            {
                values[i] = t(values[i]);
            }
        }

        [Fact]
        public void DelegateDemo3()
        {
            var values = new[] {1, 2, 3, 4, 5};
            GenericTransformer<int> t = Square;
            Transform(values, t);
            var s = new StringBuilder();
            foreach (var value in values)
            {
                s.Append(value).Append(" ");
            }
            output.WriteLine(s.ToString().Trim());
        }
        
        [Fact]
        public void LambdaExp()
        {
            var seed = 0;
            Func<int> natural = () => seed++;
            for (var i = 0; i < 10; i++)
            {
                output.WriteLine(natural().ToString());
            }
        }

        [Fact]
        public void DictInitDemo()
        {
            var dict1 = new Dictionary<int, string>()
            {
                [1] = "World!",
                [0] = "Hello"
            };
            output.WriteLine($"dict1: [0]:{dict1[0]}, [1]:{dict1[1]}");
        }
        
        [Fact]
        public void IteratorDemo()
        {
            IEnumerable<int> Fibs(int n)
            {
                for(int prev = 1, curr = 1, i = 0; i < n; i++)
                {
                    var tmp = prev + curr;
                    yield return prev;
                    prev = curr;
                    curr = tmp;
                }
            }

            foreach (var n in Fibs(10))
            {
                output.WriteLine(n.ToString());
            }
        }

        [Fact]
        public void IteratorDemo2()
        {
            IEnumerator<int> Naturals(int n)
            {
                var start = 0;
                while (start <= n)
                {
                    yield return start++;   
                }
            }

            //安全缘故，Enumerator用一半就扔会导致未合理dispos,故用using块搞定dispose问题
            using (var itr = Naturals(10))
            {
                while (itr.MoveNext())
                {
                    output.WriteLine(itr.Current.ToString());
                }    
            }
            
            output.WriteLine("****************************");
            
            IEnumerable<int> Trio()
            {
                yield return 1;
                yield return 2;
                yield return 3;
            }

            foreach (var n in Trio())
            {
                output.WriteLine(n.ToString());
            }
        }

        class Demo
        {
            public int x;
        }

        [Fact]
        public void UnsafeDemo()
        {
            Demo d1 = new Demo();
            
            unsafe {
                fixed (int* p = &d1.x)
                {
                    *p += 100;
                }
                output.WriteLine($"{d1.x}");
            }
        }

        [Fact]
        public void StringPadding()
        {
            var s = "Hello World!";
            var s1 = s.PadLeft(20, '*');
            var s2 = s1.PadRight(30, '*');
            output.WriteLine(s1);
            output.WriteLine(s2);
        }

        [Fact]
        public void XmlConvertDemo()
        {
            var s = "Hello World!";
            var res = XmlConvert.EncodeName(s);
            output.WriteLine(res);
        }
    }
}