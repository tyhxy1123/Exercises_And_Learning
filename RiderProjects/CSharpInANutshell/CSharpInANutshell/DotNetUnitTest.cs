using System;
using Xunit;
using Xunit.Abstractions;

namespace CSharpInANutshell
{
    public class UnitTestDotNet
    {
        private readonly ITestOutputHelper output;

        public UnitTestDotNet(ITestOutputHelper testOutputHelper)
        {
            output = testOutputHelper;
        }

        [Fact]
        public void Test()
        {
            var a = 60 / Math.Pow(2, 16);
            output.WriteLine($"{a}");
        }
    }
}