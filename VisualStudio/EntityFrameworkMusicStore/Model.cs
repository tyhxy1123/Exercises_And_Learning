using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System;

namespace MyApp
{
    public class MyAppDbContext: DbContext
    {
        public DbSet<Music> Musics{get;set;}
        public DbSet<Singer> Singers{get;set;}

        public DbSet<Post> Posts{get;set;}

        public DbSet<Blog> Blogs{get;set;}

        protected override void OnConfiguring(DbContextOptionsBuilder options)
        {
            options.UseSqlite("Data Source=app.db");
        }
    }

    public class Music
    {
        public int MusicId {get;set;}
        public string Title {get;set;}
        public string Genre {get;set;}
        public DateTime PublishDate{get;set;}
    }

    public class Singer
    {
        public int SingerId{get;set;}
        public string Name{get;set;}
    }
    
    public class Blog
    {
        public int BlogId { get; set; }
        public string Url { get; set; }

        public ICollection<Post> Posts { get; set; }
    }

    public class Post
    {
        public int PostId { get; set; }
        public string Title { get; set; }
        public string Content { get; set; }

        public int BlogId { get; set; }
        public Blog Blog { get; set; }
    }
}