select name, population from city
where country = 'D'
order by population desc
limit 3;


select * from country
where code='D'
limit 3;


select * from located
where river is not null and lake is not null;

//4
select name // distinct name
from language land
join encompasses as e on land.country=e.country
where continent = 'Europe'
group by name
limit 3;

select name
from language land, encompasses as e
where continent = 'Europe' and land.country = e.country
group by name
limit 3;

//5
select i.name, count(i.country) amount
from is_member m
join language i on m.country=i.country
where organization = 'EU'
group by i.name
order by 2 desc
limit 3;

//6
select city.name, country.name, city.population, country.population
from country
join city on code=country and city.name = capital
where city.population > country.population * 0.3
limit 3;


//7
select * 
from geo_mountain
limit 3;

select *
from mountain
limit 3;

//8
select distinct(country.name)
from country
join city capital on code=capital.country and capital.name = capital
join city rest on code=rest.country
where rest.population > capital.population
limit 3;

//10
select country.name, sum(b2.length)
from country
join borders on country.code = borders.country1 or country.code = borders.country2
join borders as b2 on country.code = b2.country1 or country.code=b2.country2
where country.code != 'D' and (borders.country1 = 'D' or borders.country2 = 'D')
group by country.name
limit 3;

//10 自己做的
select country.name from country
join borders on country.code = borders.country1 or country.code = borders.country2
where borders.country2 = 'D' or borders.country1 = 'D'

//11
select country.name, sum(city.population) *100/country.population as Anteil
from city
join country on code = city.country
where city.population > 1000000
group by country.name
having sum(city.population) > 0.3 * country.population
order by Anteil desc
limit 3;

//12
select c.name, count(distince gl.lake)
from country c inner join geo_lake gl on c.code = gl.country inner join geo_mountain gm on c.code = gm.country
group by c.name
having count(distinct gl.lake) > count(distinct gm.mountain)
order by 2
limit 3;

//12 自己写
select country.name, count(distinct geo_mountain.mountain), count(distinct geo_lake.lake)
from country
join geo_mountain on country.code = geo_mountain.country
join geo_lake on country.code = geo_lake.country
group by country.name
having count(distinct geo_mountain.mountain) < count(distinct geo_lake.lake)
order by count(distinct geo_lake.lake)

//13
select c.name, count(*)
from country c inner join borders b on c.code = b.country1 or c.code = b.country2
group by c.name
having count(*) > (select count(*)
from borders b
where (b.country1 = 'D' or b.country2 = 'D'))
limit 3;

select count(*)
from borderswhere country1 = 'D' or country2 = 'D'