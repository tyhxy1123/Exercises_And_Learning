using Microsoft.OpenApi.Models;
using PizzaStore.DB;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen(c =>
{
    c.SwaggerDoc("v1", new OpenApiInfo { Title = "Todo API", Description = "Keep track of your tasks", Version = "v1" });
});
var app = builder.Build();
app.UseSwagger();
app.UseSwaggerUI(c =>
  {
      c.SwaggerEndpoint("/swagger/v1/swagger.json", "Todo API V1");
  });

app.MapGet("/PizzaStore/pizzas/{id}", (int id) => PizzaDB.GetPizza(id));
app.MapGet("/PizzaStore/pizzas", () => PizzaDB.GetPizzas());
app.MapPost("/PizzaStore/pizzas", (Pizza pizza) => PizzaDB.CreatePizza(pizza));
app.MapPut("/PizzaStore/pizzas", (Pizza pizza) => PizzaDB.UpdatePizza(pizza));
app.MapDelete("/PizzaStore/pizzas/{id}", (int id) => PizzaDB.RemovePizza(id));

app.Run();
