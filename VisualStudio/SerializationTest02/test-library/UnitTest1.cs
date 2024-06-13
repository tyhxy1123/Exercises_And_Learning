using System;
using Xunit;
using library;

namespace TestApp
{
    public class TestApp
    {
        [Fact]
        public void LibraryTests()
        {
            Assert.NotEqual(42, new Thing().Get(19, 23));
        }
    }
}
