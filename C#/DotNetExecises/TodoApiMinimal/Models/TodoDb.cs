using Microsoft.EntityFrameworkCore;

namespace TodoApiMinimal.Models
{
    public class TodoDb : DbContext
    {
        public TodoDb(DbContextOptions<TodoDb> opts) : base(opts) { }
        public DbSet<Todo> Todos => Set<Todo>();
    }
}
