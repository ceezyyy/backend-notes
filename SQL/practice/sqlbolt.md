# SQL Practice

from [SQLBolt](https://sqlbolt.com/)



## Category


  * [Category](#category)
  * [SELECT queries 101](#select-queries-101)
  * [Queries with constraints](#queries-with-constraints)
  * [Review](#review)
  * [Multi-table queries with JOINs](#multi-table-queries-with-joins)
  * [OUTER JOINs](#outer-joins)
  * [A short note on NULLs](#a-short-note-on-nulls)
  * [Queries with expressions](#queries-with-expressions)
  * [Queries with aggregates](#queries-with-aggregates)
  * [Queries with aggregates II](#queries-with-aggregates-ii)



## SELECT queries 101



1. Find the `title` of each film

   ```sql
   SELECT 
   	title 
   FROM 
   	movies;
   ```

   

2. Find the `director` of each film

   ```sql
   SELECT 
   	director 
   FROM 
   	movies;
   ```

   

3. Find the `title` and `director` of each film

   ```sql
   SELECT 
   	title, 
   	director 
   FROM 
   	movies;
   ```

   

4. Find the `title` and `year` of each film

   ```sql
   SELECT 
   	title, 
   	year 
   FROM 
   	movies;
   ```

   

5. Find `all` the information about each film

   ```sql
   SELECT 
   	* 
   FROM 
		movies;
   ```
   
   

## Queries with constraints

1. Find the movie with a row `id` of 6

   ```sql
   SELECT 
   	* 
   FROM 
   	movies 
   WHERE 
   	id = 6;
   ```

   

2. Find the movies released in the `year`s between 2000 and 2010

   ```sql
   SELECT 
   	* 
   FROM 
   	movies 
   WHERE 
   	year BETWEEN 2000 AND 2010;
   ```

   

3. Find the movies **not** released in the `year`s between 2000 and 2010

   ```sql
   SELECT 
   	* 
   FROM 
   	movies 
   WHERE 
   	year NOT BETWEEN 2000 AND 2010;
   ```

   

4. Find the first 5 Pixar movies and their release `year`

   ```sql
   SELECT 
   	* 
   FROM 
   	movies
   WHERE 
   	year LIMIT 5;
   ```
   
   

## Queries with constraints II

1. Find all the Toy Story movies

   ```sql
   SELECT 
   	* 
   FROM 
   	movies 
   WHERE 
   	title LIKE '%Toy Story%';
   ```

   

2. Find all the movies directed by John Lasseter

   ```sql
   SELECT 
   	* 
   FROM 
   	movies 
   WHERE 
   	director = 'John Lasseter';
   ```

   

3. Find all the movies (and director) not directed by John Lasseter

   ```sql
   SELECT 
   	* 
   FROM 
   	movies 
   WHERE 
   	NOT director = 'John Lasseter';
   ```

   

4. Find all the WALL-* movies

   ```sql
   SELECT 
   	* 
   FROM 
   	movies 
WHERE 
   	title LIKE 'WALL-%';
   ```
   
   



## Filtering and sorting Query results

1. List all directors of Pixar movies (alphabetically), without duplicates

   ```sql
   SELECT DISTINCT 
   	director 
   FROM 
   	movies 
   ORDER BY 
   	directors;
   ```

   

   

2. List the last four Pixar movies released (ordered from most recent to least)

   ```sql
   SELECT 
   	* 
   FROM 
   	movies 
   ORDER BY 
   	year DESC 
   LIMIT 
   	4;
   ```

   

3. List the **first** five Pixar movies sorted alphabetically

   ```sql
   SELECT 
   	* 
   FROM 
   	movies 
   ORDER BY 
   	title 
   LIMIT 
   	5;
   ```

   

4. List the **next** five Pixar movies sorted alphabetically

   ```sql
   SELECT 
   	* 
   FROM 
   	movies 
   ORDER BY 
   	title 
   LIMIT 
   	5, 5;
   ```




## Review



1. List all the Canadian cities and their populations

   ```sql
   SELECT 
   	* 
   FROM 
   	north_american_cities 
   WHERE 
   	Country = 'Canada';
   ```

   

2. Order all the cities in the United States by their latitude from north to south

   ```sql
   SELECT 
   	* 
   FROM 
   	north_american_cities 
   WHERE 
   	Country = 'United States' 
   ORDER BY 
   	latitude DESC;
   ```

   

3. List all the cities west of Chicago, ordered from west to east

   ```sql
   SELECT 
   	city 
   FROM 
   	north_american_cities
   WHERE 
   	longitude < (
       	SELECT 
           	longitude 
       	FROM 
           	north_american_cities
       	WHERE 
           	city = 'Chicago'
   	)
   ORDER BY 
   	longitude ASC;
   ```

   

4. List the two largest cities in Mexico (by population)

   ```sql
   SELECT 
   	city 
   FROM 
   	north_american_cities
   WHERE 
   	Country = "Mexico"
   ORDER BY 
   	population DESC
   LIMIT 
   	2;
   ```

   

5. List the third and fourth largest cities (by population) in the United States and their population

   ```sql
   SELECT 
   	city, 
   	population
   FROM 
   	north_american_cities
   WHERE 
	Country = "United States" 
   ORDER BY 
   	population DESC 
   LIMIT 
   	2, 2;
   ```
   
   

## Multi-table queries with JOINs

1. Find the domestic and international sales for each movie 

   ```sql
   SELECT 
   	title,
   	Domestic_sales,
   	International_sales
   FROM 
   	Movies 
   JOIN 
   	Boxoffice 
   ON 
   	Movies.id = Boxoffice.Movie_id;
   ```

   

2. Show the sales numbers for each movie that did better internationally rather than domestically

   ```sql
   SELECT 
   	title, 
   	international_sales, 
   	domestic_sales
   FROM 
   	movies
   JOIN 
   	Boxoffice
   ON 
   	movies.id = boxoffice.movie_id
   WHERE 
   	international_sales > domestic_sales;
   ```

   

3. List all the movies by their ratings in descending order

   ```sql
   SELECT 
   	title
   FROM 
   	movies
   JOIN 
   	Boxoffice
   ON 
   	movies.id = boxoffice.movie_id
   ORDER BY 
   	rating DESC
   ```

   

## OUTER JOINs

1. Find the list of all buildings that have employees 

   ```sql
   SELECT DISTINCT 
   	Building 
   FROM 
   	Employees;
   ```

   

2. Find the list of all buildings and their capacity

   ```sql
   SELECT 
   	*
   FROM 
   	Buildings;
   ```

   

3. List all buildings and the distinct employee roles in each building (including empty buildings)

   ```sql
   SELECT DISTINCT 
   	building_name, 
   	role 
   FROM 
   	Buildings
   LEFT JOIN 
   	Employees
   ON 
   	Buildings.building_name = Employees.Building;
   ```

   

## A short note on NULLs

1. Find the name and role of all employees who have not been assigned to a building 

   ```sql
   SELECT 
   	name, 
   	role
   FROM 
   	Employees
   WHERE 
   	building IS NULL
   ```

   

2. Find the names of the buildings that hold no employees

   ```sql
   SELECT 
   	building_name
   FROM 
   	Buildings t1
   LEFT JOIN 
   	Employees t2
   ON 
   	t1.building_name = t2.building
   WHERE 
   	building IS NULL;
   ```

   

## Queries with expressions

1. List all movies and their combined sales in **millions** of dollars

   ```sql
   SELECT 
       title, 
       (domestic_sales + international_sales) / 1000000 AS total
   FROM 
   	movies
   JOIN 
   	boxoffice 
   ON movies.id = boxoffice.movie_id;
   ```

   

2. List all movies and their ratings **in percent**

   ```sql
   SELECT 
       title, 
       rating * 10
   FROM 
       movies
   JOIN 
       boxoffice 
   ON 
       movies.id = boxoffice.movie_id;
   ```

   

3. List all movies that were released on even number years

   ```sql
   SELECT 
       title
   FROM 
       movies
   WHERE
       year % 2 = 0;
   ```

   

## Queries with aggregates

1. Find the longest time that an employee has been at the studio 

   ```sql
   SELECT 
       MAX(years_employed)
   FROM 
       employees;
   ```

   

2. For each role, find the average number of years employed by employees in that role

   ```sql
   SELECT DISTINCT
       role, AVG(years_employed)
   FROM 
       employees
   GROUP BY 
       role
   ```

   ​         

3. Find the total number of employee years worked in each building

   ```sql
   SELECT DISTINCT
       building, SUM(years_employed)
   FROM 
       employees
   GROUP BY 
       building;
   ```

   

   ## Queries with aggregates II

   1. Find the number of Artists in the studio (without a **HAVING** clause) 

      

   2. Find the number of Employees of each role in the studio

      

   3. Find the total number of years employed by all Engineers

      