```
SELECT * 
FROM north_american_cities 
WHERE Country = 'Canada';
```

# SQL Practice

from [SQLBolt](https://sqlbolt.com/)



## Category





## SELECT queries 101



1. Find the `title` of each film

   ```sql
   SELECT title 
   FROM movies;
   ```

   

2. Find the `director` of each film

   ```sql
   SELECT director 
   FROM movies;
   ```

   

3. Find the `title` and `director` of each film

   ```sql
   SELECT title, director 
   FROM movies;
   ```

   

4. Find the `title` and `year` of each film

   ```sql
   SELECT title, year 
   FROM movies;
   ```

   

5. Find `all` the information about each film

   ```sql
   SELECT * 
   FROM movies;
   ```

   

## Queries with constraints

1. Find the movie with a row `id` of 6

   ```sql
   SELECT * 
   FROM movies 
   WHERE id = 6;
   ```

   

2. Find the movies released in the `year`s between 2000 and 2010

   ```sql
   SELECT * 
   FROM movies 
   WHERE year BETWEEN 2000 AND 2010;
   ```

   

3. Find the movies **not** released in the `year`s between 2000 and 2010

   ```sql
   SELECT * 
   FROM movies 
   WHERE year NOT BETWEEN 2000 AND 2010;
   ```

   

4. Find the first 5 Pixar movies and their release `year`

   ```sql
   SELECT * 
   FROM movies
   WHERE year LIMIT 5;
   ```

   



## Queries with constraints II

1. Find all the Toy Story movies

   ```sql
   SELECT * 
   FROM movies 
   WHERE title LIKE '%Toy Story%';
   ```

   

2. Find all the movies directed by John Lasseter

   ```sql
   SELECT * 
   FROM movies 
   WHERE director = 'John Lasseter';
   ```

   

3. Find all the movies (and director) not directed by John Lasseter

   ```sql
   SELECT * 
   FROM movies 
   WHERE NOT director = 'John Lasseter';
   ```

   

4. Find all the WALL-* movies

   ```sql
   SELECT * 
   FROM movies 
   WHERE title LIKE 'WALL-%';
   ```

   



## Filtering and sorting Query results

1. List all directors of Pixar movies (alphabetically), without duplicates

   ```sql
   SELECT DISTINCT director 
   FROM movies 
   ORDER BY directors;
   ```

   

   

2. List the last four Pixar movies released (ordered from most recent to least)

   ```sql
   SELECT * 
   FROM movies 
   ORDER BY year DESC 
   LIMIT 4;
   ```

   

3. List the **first** five Pixar movies sorted alphabetically

   ```sql
   SELECT * 
   FROM movies 
   ORDER BY title 
   LIMIT 5;
   ```

   

4. List the **next** five Pixar movies sorted alphabetically

   ```sql
   SELECT * 
   FROM movies 
   ORDER BY title 
   LIMIT 5, 5;
   ```

   









## Review



1. List all the Canadian cities and their populations

   ```sql
   SELECT * 
   FROM north_american_cities 
   WHERE Country = 'Canada';
   ```

   

2. Order all the cities in the United States by their latitude from north to south

   ```sql
   SELECT * 
   FROM north_american_cities 
   WHERE Country = 'United States' 
   ORDER BY latitude DESC;
   ```

   

3. List all the cities west of Chicago, ordered from west to east

   ```sql
   SELECT city 
   FROM north_american_cities
   WHERE longitude < (
       SELECT longitude 
       FROM north_american_cities
       WHERE city = 'Chicago'
   )
   ORDER BY longitude ASC;
   ```

   

4. List the two largest cities in Mexico (by population)

   ```sql
   SELECT city 
   FROM north_american_cities
   WHERE Country = "Mexico"
   ORDER BY population DESC
   LIMIT 2;
   ```

   

5. List the third and fourth largest cities (by population) in the United States and their population

   ```sql
   SELECT city, population
   FROM north_american_cities
   WHERE Country = "United States" 
   ORDER BY population DESC 
   LIMIT 2, 2;
   ```

   